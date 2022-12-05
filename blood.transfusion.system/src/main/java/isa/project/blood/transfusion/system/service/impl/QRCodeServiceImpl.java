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
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import isa.project.blood.transfusion.system.dto.SortDTO;
import isa.project.blood.transfusion.system.model.AppointmentStatus;
import isa.project.blood.transfusion.system.model.QRCode;
import isa.project.blood.transfusion.system.model.QuickAppointment;
import isa.project.blood.transfusion.system.model.RegisteredUser;
import isa.project.blood.transfusion.system.repository.QRCodeRepository;
import isa.project.blood.transfusion.system.repository.UserRepository;
import isa.project.blood.transfusion.system.service.QRCodeService;

@Service
public class QRCodeServiceImpl implements QRCodeService {

	private static final String QR_CODE_IMAGE_PATH = "./src/main/resources/images/";

	@Autowired
	private QRCodeRepository qrCodeRepository;

	@Autowired
	private UserRepository userRepository;

	@Override
	public QRCode createQRCode(QuickAppointment quickAppointment, int width, int height)
			throws WriterException, IOException {

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

	@Override
	public List<QRCode> getUserQRCodes(String username) {

		RegisteredUser user = (RegisteredUser) userRepository.findByUsername(username);
		return qrCodeRepository.findByUser(user);
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
