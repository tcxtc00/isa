package isa.project.blood.transfusion.system;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.google.zxing.WriterException;

import isa.project.blood.transfusion.system.service.QRCodeService;


@EnableAsync
@SpringBootApplication
@EnableScheduling
public class Application {
	
	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Application.class, args);
		QRCodeService qrCodeService = ctx.getBean(QRCodeService.class);
		

		try {
			qrCodeService.createTestQRCodes(250, 250);
		} catch (WriterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
