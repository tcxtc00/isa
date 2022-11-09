package isa.project.blood.transfusion.system.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.time.format.DateTimeFormatter;

import isa.project.blood.transfusion.system.model.QRCode;
import isa.project.blood.transfusion.system.model.QuickAppointment;
import isa.project.blood.transfusion.system.repository.QRCodeRepository;
import isa.project.blood.transfusion.system.service.QRCodeService;

@Service
public class QRCodeServiceImpl implements QRCodeService{
	
	private static final String QR_CODE_IMAGE_PATH = "./src/main/resources/images/";
	
	@Autowired
	private QRCodeRepository qrCodeRepository;

	@Override
	public QRCode createQRCode(QuickAppointment quickAppointment, int width, int height) throws WriterException, IOException {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		String formattedDateTime = quickAppointment.getDate().format(formatter);
		QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode("Informacije o terminu:\n\n" + "Datum: "+ formattedDateTime + "\nTrajanje: " + quickAppointment.getDuration() + " min" + "\n\nHvala vam sto dajete krv." + "\nUzimajuci - punimo ruke, dajuci - punimo srce (Margarete Semann)"  , BarcodeFormat.QR_CODE, width, height);
        Path path = FileSystems.getDefault().getPath(QR_CODE_IMAGE_PATH + quickAppointment.getUser().getUsername() + "_" + quickAppointment.getId() + ".png");
        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
        ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
	    MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutputStream);
	    byte[] pngData = pngOutputStream.toByteArray(); 
        QRCode qr = new QRCode();
        qr.setAppointment(quickAppointment);
        qr.setData(pngData);
        qr.setFileName(quickAppointment.getUser().getUsername() + "_" + quickAppointment.getId() + ".png");
        qr.setUser(quickAppointment.getUser());
        qrCodeRepository.save(qr);
        return qr;
		
	}

}
