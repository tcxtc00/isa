package isa.project.blood.transfusion.system.controller;

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

import isa.project.blood.transfusion.system.dto.AppointmentDTO;
import isa.project.blood.transfusion.system.dto.SortDTO;
import isa.project.blood.transfusion.system.service.QuickAppointmentsService;

@RestController
@RequestMapping(value = "api/quickAppointments")
public class QuickAppointmentsController {
	
	@Autowired
	private QuickAppointmentsService quickAppointmentsService;
	
	@PreAuthorize("hasRole('REGISTEREDUSER')")
	@PostMapping(path = "/sort")
	public ResponseEntity<?> sort(@RequestBody SortDTO sortDTO){
		return new ResponseEntity<>(quickAppointmentsService.sort(sortDTO), HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('REGISTEREDUSER')")
	@PostMapping(path = "/book")
	public ResponseEntity<?> book(@RequestBody AppointmentDTO appointmentDTO){
		return new ResponseEntity<>(quickAppointmentsService.book(appointmentDTO), HttpStatus.OK);
	}
	@PreAuthorize("hasRole('REGISTEREDUSER')")
	@GetMapping(path = "/notPassed/{username}")
	public ResponseEntity<?> notPassed(@PathVariable String username){
		return new ResponseEntity<>(quickAppointmentsService.notPassed(username), HttpStatus.OK);
	}
	
	

}
