package isa.project.blood.transfusion.system.service;

import java.io.IOException;
import java.util.List;

import com.google.zxing.WriterException;

import isa.project.blood.transfusion.system.dto.SortDTO;
import isa.project.blood.transfusion.system.model.QRCode;
import isa.project.blood.transfusion.system.model.QuickAppointment;

public interface QRCodeService {
	
	public QRCode createQRCode(QuickAppointment quickAppointment, int width, int height) throws WriterException, IOException;
	public List<QRCode> getUserQRCodes(String username);
	public List<QRCode> sort(SortDTO sortDTO);
	
}
