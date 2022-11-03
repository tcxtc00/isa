package isa.project.blood.transfusion.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import isa.project.blood.transfusion.system.service.BloodTransfusionCenterService;

@RestController
@RequestMapping(value = "api/centers")
public class BloodTransfusionCenterController {
	
	@Autowired
	private BloodTransfusionCenterService bloodTransfusionCenterService;
	
	
	@GetMapping(path = "/all")
	public ResponseEntity<?> getAll(){
		return new ResponseEntity<>(bloodTransfusionCenterService.getAll(), HttpStatus.OK);
	}

}
