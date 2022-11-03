package isa.project.blood.transfusion.system.service.impl;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import isa.project.blood.transfusion.system.model.User;
import isa.project.blood.transfusion.system.service.EmailService;

@Service
public class EmailServiceImpl implements EmailService{
	
	@Autowired
    private JavaMailSender javaMailSender;
	
	@Autowired
	private Environment env;

	@Override
	@Async
	public void registrationEmail(User user) throws MessagingException {
		MimeMessage message=javaMailSender.createMimeMessage();
	    MimeMessageHelper helper;
	    helper=new MimeMessageHelper(message,true);
	    helper.setTo(new InternetAddress(user.getUsername()));
	    helper.setFrom(new InternetAddress(env.getProperty("spring.mail.username")));
	    helper.setSubject("Aktivacija naloga");
	    helper.setText("Poštovani/a " + ",\n\nZa aktivaciju naloga kliknite na link ispod." + "\n\nhttp://localhost:8080/api/users/activate/"+ user.getUsername() + "\n\nHvala vam što pristupate uslugama naše aplikacije. "
	    		+ "Nakon što aktivirate vaš nalog, možete da rezervišete odgovarajući termin i postanete davalac krvi." + 
	    		"\nUzimajući - punimo ruke, dajući - punimo srce (Margarete Semann)" + "\nZa sva dalja pitanja pišite nam na mail bloodtransfusion@gmail.com ili nas kontaktirajte na broj 064364534645." + "\n\nPozdrav");
	    javaMailSender.send(message);
		
	}

	
}
