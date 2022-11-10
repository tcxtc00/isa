package isa.project.blood.transfusion.system.service.impl;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import isa.project.blood.transfusion.system.model.QuickAppointment;
import isa.project.blood.transfusion.system.model.User;
import isa.project.blood.transfusion.system.service.EmailService;

@Service
public class EmailServiceImpl implements EmailService{
	
	@Autowired
    private JavaMailSender javaMailSender;
	
	@Autowired
	private Environment env;
	
	private static final String QR_CODE_IMAGE_PATH = "./src/main/resources/images/";

	@Override
	@Async
	public void registrationEmail(User user) throws MessagingException {
		MimeMessage message=javaMailSender.createMimeMessage();
	    MimeMessageHelper helper;
	    helper=new MimeMessageHelper(message,true);
	    helper.setTo(new InternetAddress(user.getUsername()));
	    helper.setFrom(new InternetAddress(env.getProperty("spring.mail.username")));
	    helper.setSubject("Aktivacija naloga");
	    helper.setText("Poštovani/a " + ",\n\nZa aktivaciju naloga kliknite na link ispod." + "\n\nhttp://localhost:8080/api/users/activate/"+ user.getUsername() + "\n\nHvala Vam što pristupate uslugama naše aplikacije. "
	    		+ "Nakon što aktivirate Vaš nalog, možete da rezervišete odgovarajući termin i postanete davalac krvi." + 
	    		"\nUzimajući - punimo ruke, dajući - punimo srce (Margarete Semann)" + "\nZa sva dalja pitanja pišite nam na mail bloodtransfusion@gmail.com ili nas kontaktirajte na broj 064364534645." + "\n\nPozdrav");
	    javaMailSender.send(message);
		
	}

	@Override
	@Async
	public void sendQRCode(QuickAppointment appointment, String path) throws MessagingException {
		MimeMessage message=javaMailSender.createMimeMessage();
	    MimeMessageHelper helper;
	    helper=new MimeMessageHelper(message,true);
	    helper.setTo(new InternetAddress(appointment.getUser().getUsername()));
	    helper.setFrom(new InternetAddress(env.getProperty("spring.mail.username")));
	    helper.setSubject("Termin za davanje krvi");
	    helper.setText("Poštovani/a" + "\n\nU prilogu Vam šaljemo QR kod preko koga možete videti sve informacije vezane za Vaš termin za davanje krvi." + "\n\nHvala Vam što dajete krv." + "\nUzimajući - punimo ruke, dajući - punimo srce (Margarete Semann)" + "\nZa sva dalja pitanja pišite nam na mail bloodtransfusion@gmail.com ili nas kontaktirajte na broj 064364534645." + "\n\nPozdrav");
	    FileSystemResource file = new FileSystemResource(new File(QR_CODE_IMAGE_PATH + path));
        helper.addAttachment(path, file);
	    javaMailSender.send(message);
		
	}

	
}
