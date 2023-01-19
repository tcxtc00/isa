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
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import isa.project.blood.transfusion.system.dto.SortDTO;
import isa.project.blood.transfusion.system.model.AppointmentStatus;
import isa.project.blood.transfusion.system.model.QRCode;
import isa.project.blood.transfusion.system.model.QuickAppointment;
import isa.project.blood.transfusion.system.model.RegisteredUser;
import isa.project.blood.transfusion.system.repository.QRCodeRepository;
import isa.project.blood.transfusion.system.repository.QuickAppointmentsRepository;
import isa.project.blood.transfusion.system.repository.UserRepository;
import isa.project.blood.transfusion.system.service.QRCodeService;

@Service
public class QRCodeServiceImpl implements QRCodeService {

	private static final String QR_CODE_IMAGE_PATH = "./src/main/resources/images/";

	@Autowired
	private QRCodeRepository qrCodeRepository;

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private QuickAppointmentsRepository quickAppointmentsRepository;

	@Override
	public QRCode createQRCode(QuickAppointment quickAppointment, int width, int height)
			throws WriterException, IOException {

		createTestQRCodes(quickAppointment, width, height);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		String formattedDateTime = quickAppointment.getDate().format(formatter);
		QRCodeWriter qrCodeWriter = new QRCodeWriter();
		BitMatrix bitMatrix = qrCodeWriter.encode(
				"Informacije o terminu:\n\n" + "Datum: " + formattedDateTime + "\nTrajanje: "
						+ quickAppointment.getDuration() + " min" + "\n\nHvala Vam sto dajete krv."
						+ "\nUzimajuci - punimo ruke, dajuci - punimo srce (Margarete Semann)",
				BarcodeFormat.QR_CODE, width, height);
		Path path = FileSystems.getDefault().getPath(QR_CODE_IMAGE_PATH + quickAppointment.getUser().getUsername() + "_"
				+ quickAppointment.getId() + ".png");
		MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
		ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
		MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutputStream);
		byte[] pngData = pngOutputStream.toByteArray();
		QRCode qr = new QRCode();
		qr.setAppointment(quickAppointment);
		qr.setData(pngData);
		qr.setFileName(quickAppointment.getUser().getUsername() + "_" + quickAppointment.getId() + ".png");
		qr.setUser(quickAppointment.getUser());
		qr.setDate(LocalDateTime.now());
		qrCodeRepository.save(qr);
		return qr;

	}
	
	private void createTestQRCodes(QuickAppointment appointment, int width,int height) throws WriterException, IOException {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		LocalDateTime firstDateTest1 = LocalDateTime.of(2019, 
                Month.JULY, 29, 19, 30, 40);
		QuickAppointment quickAppointmentTest1 = new QuickAppointment();
		quickAppointmentTest1.setDate(firstDateTest1);
		quickAppointmentTest1.setCenter(appointment.getCenter());
		quickAppointmentTest1.setDuration(30l);
		quickAppointmentTest1.setStatus(AppointmentStatus.SuccessFinished);
		quickAppointmentTest1.setUser(appointment.getUser());
		quickAppointmentsRepository.save(quickAppointmentTest1);
		
		String formattedDateTime1 = firstDateTest1.format(formatter);
		QRCodeWriter qrCodeWriter1 = new QRCodeWriter();
		BitMatrix bitMatrix1 = qrCodeWriter1.encode(
				"Informacije o terminu:\n\n" + "Datum: " + formattedDateTime1 + "\nTrajanje: "
						+ 30 + " min" + "\n\nHvala Vam sto dajete krv."
						+ "\nUzimajuci - punimo ruke, dajuci - punimo srce (Margarete Semann)",
				BarcodeFormat.QR_CODE, width, height);
		Path path1 = FileSystems.getDefault().getPath(QR_CODE_IMAGE_PATH + appointment.getUser().getUsername() + "_"
				+ quickAppointmentTest1.getId() + ".png");
		MatrixToImageWriter.writeToPath(bitMatrix1, "PNG", path1);
		ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
		MatrixToImageWriter.writeToStream(bitMatrix1, "PNG", pngOutputStream);
		byte[] pngData = pngOutputStream.toByteArray();
		QRCode qr1 = new QRCode();
		qr1.setAppointment(quickAppointmentTest1);
		qr1.setData(pngData);
		qr1.setFileName(quickAppointmentTest1.getUser().getUsername() + "_" + quickAppointmentTest1.getId() + ".png");
		qr1.setUser(quickAppointmentTest1.getUser());
		qr1.setDate(LocalDateTime.of(2019, 
                Month.JULY, 20, 19, 30, 40));
		qrCodeRepository.save(qr1);
		
		
		
		LocalDateTime firstDateTest2 = LocalDateTime.of(2021, 
                Month.FEBRUARY, 10, 19, 30, 40);
		QuickAppointment quickAppointmentTest2 = new QuickAppointment();
		quickAppointmentTest2.setDate(firstDateTest2);
		quickAppointmentTest2.setCenter(appointment.getCenter());
		quickAppointmentTest2.setDuration(35l);
		quickAppointmentTest2.setStatus(AppointmentStatus.NotSatisfiedConditions);
		quickAppointmentTest2.setUser(appointment.getUser());
		quickAppointmentsRepository.save(quickAppointmentTest2);
		
		String formattedDateTime2 = firstDateTest2.format(formatter);
		QRCodeWriter qrCodeWriter2 = new QRCodeWriter();
		BitMatrix bitMatrix2 = qrCodeWriter2.encode(
				"Informacije o terminu:\n\n" + "Datum: " + formattedDateTime2 + "\nTrajanje: "
						+ 30 + " min" + "\n\nHvala Vam sto dajete krv."
						+ "\nUzimajuci - punimo ruke, dajuci - punimo srce (Margarete Semann)",
				BarcodeFormat.QR_CODE, width, height);
		Path path2 = FileSystems.getDefault().getPath(QR_CODE_IMAGE_PATH + appointment.getUser().getUsername() + "_"
				+ quickAppointmentTest2.getId() + ".png");
		MatrixToImageWriter.writeToPath(bitMatrix2, "PNG", path2);
		ByteArrayOutputStream pngOutputStream2 = new ByteArrayOutputStream();
		MatrixToImageWriter.writeToStream(bitMatrix2, "PNG", pngOutputStream2);
		byte[] pngData2 = pngOutputStream.toByteArray();
		QRCode qr2 = new QRCode();
		qr2.setAppointment(quickAppointmentTest2);
		qr2.setData(pngData2);
		qr2.setFileName(quickAppointmentTest2.getUser().getUsername() + "_" + quickAppointmentTest2.getId() + ".png");
		qr2.setUser(quickAppointmentTest2.getUser());
		qr2.setDate(LocalDateTime.of(2021, 
                Month.JANUARY, 25, 19, 30, 40));
		qrCodeRepository.save(qr2);
		
		
		
		LocalDateTime firstDateTest3 = LocalDateTime.of(2018, 
                Month.FEBRUARY, 12, 19, 30, 40);
		QuickAppointment quickAppointmentTest3 = new QuickAppointment();
		quickAppointmentTest3.setDate(firstDateTest3);
		quickAppointmentTest3.setCenter(appointment.getCenter());
		quickAppointmentTest3.setDuration(35l);
		quickAppointmentTest3.setStatus(AppointmentStatus.SuccessFinished);
		quickAppointmentTest3.setUser(appointment.getUser());
		quickAppointmentsRepository.save(quickAppointmentTest3);
		
		String formattedDateTime3 = firstDateTest3.format(formatter);
		QRCodeWriter qrCodeWriter3 = new QRCodeWriter();
		BitMatrix bitMatrix3= qrCodeWriter3.encode(
				"Informacije o terminu:\n\n" + "Datum: " + formattedDateTime3 + "\nTrajanje: "
						+ 30 + " min" + "\n\nHvala Vam sto dajete krv."
						+ "\nUzimajuci - punimo ruke, dajuci - punimo srce (Margarete Semann)",
				BarcodeFormat.QR_CODE, width, height);
		Path path3 = FileSystems.getDefault().getPath(QR_CODE_IMAGE_PATH + appointment.getUser().getUsername() + "_"
				+ quickAppointmentTest3.getId() + ".png");
		MatrixToImageWriter.writeToPath(bitMatrix2, "PNG", path3);
		ByteArrayOutputStream pngOutputStream3 = new ByteArrayOutputStream();
		MatrixToImageWriter.writeToStream(bitMatrix3, "PNG", pngOutputStream3);
		byte[] pngData3 = pngOutputStream.toByteArray();
		QRCode qr3 = new QRCode();
		qr3.setAppointment(quickAppointmentTest3);
		qr3.setData(pngData3);
		qr3.setFileName(quickAppointmentTest3.getUser().getUsername() + "_" + quickAppointmentTest3.getId() + ".png");
		qr3.setUser(quickAppointmentTest3.getUser());
		qr3.setDate(LocalDateTime.of(2018, 
                Month.JANUARY, 29, 19, 30, 40));
		qrCodeRepository.save(qr3);
	}

	@Override
	public List<QRCode> getUserQRCodes(String username) {

		RegisteredUser user = (RegisteredUser) userRepository.findByUsername(username);
		Set<QRCode> qrCodes = user.getQrCodes();
		List<QRCode> filteredQrCodes = qrCodes.stream()
				.filter(qr -> (qr.getAppointment().getStatus().equals(AppointmentStatus.Booked) || qr.getAppointment().getStatus().equals(AppointmentStatus.SuccessFinished) || qr.getAppointment().getStatus().equals(AppointmentStatus.NotSatisfiedConditions)))
				.collect(Collectors.toList());
		
		return filteredQrCodes;
	}

	@Override
	public List<QRCode> sort(SortDTO sortDTO) {

		if ((sortDTO.getFilter().equals("") && sortDTO.getSortBy().equals(""))
				|| sortDTO.getUsername().equals("")) {
			return null;
		}

		RegisteredUser user = (RegisteredUser) userRepository.findByUsername(sortDTO.getUsername());
		List<QRCode> qrCodes = qrCodeRepository.findByUser(user);
		List<QRCode> filteredQRCodes = new ArrayList<>();

		if (!sortDTO.getSortBy().equals("")) {

			if (sortDTO.getSortBy().equals("DateAscending")) {

				Collections.sort(qrCodes, (a1, a2) -> (a1.getDate().compareTo(a2.getDate())));
			}

			if (sortDTO.getSortBy().equals("DateDescending")) {

				Collections.sort(qrCodes, (a1, a2) -> (a2.getDate().compareTo(a1.getDate())));

			}

			filteredQRCodes.addAll(qrCodes);

		}

		if (!sortDTO.getFilter().equals("")) {
			filteredQRCodes = qrCodes.stream().filter(
					qr -> (qr.getAppointment().getStatus().equals(AppointmentStatus.valueOf(sortDTO.getFilter()))))
					.collect(Collectors.toList());

		}

		return filteredQRCodes;

	}

}
