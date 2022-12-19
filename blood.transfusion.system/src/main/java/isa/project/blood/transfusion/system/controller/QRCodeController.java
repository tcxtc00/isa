package isa.project.blood.transfusion.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import isa.project.blood.transfusion.system.dto.SortDTO;
import isa.project.blood.transfusion.system.model.QRCode;
import isa.project.blood.transfusion.system.service.QRCodeService;

@RestController()
@RequestMapping(value = "api/qrCodes")
public class QRCodeController {
	
	@Autowired
	private QRCodeService qrCodeService;
	
	@GetMapping(path = "/userQRCodes/{username}")
	@PreAuthorize("hasRole('REGISTEREDUSER')")
	public ResponseEntity<?> getUserQRCodes(@PathVariable String username){
		return new ResponseEntity<>(qrCodeService.getUserQRCodes(username), HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('REGISTEREDUSER')")
	@PostMapping(path = "/sort")
	public ResponseEntity<?> sort(@RequestBody SortDTO sortDTO){
		List<QRCode> qrCodes = qrCodeService.sort(sortDTO);
		if(qrCodes == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(qrCodes, HttpStatus.OK);
	}
	


}
