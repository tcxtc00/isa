package isa.project.blood.transfusion.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import isa.project.blood.transfusion.system.dto.UserDTO;
import isa.project.blood.transfusion.system.model.User;
import isa.project.blood.transfusion.system.service.RegisteredUserService;

@RestController
@RequestMapping(value = "api/users")
public class RegisteredUserController {
	
	@Autowired
	private RegisteredUserService registeredUserService;
	
	
	@PostMapping(path = "/register")
	public ResponseEntity<?> register(@RequestBody UserDTO userDTO){
		User user = registeredUserService.register(userDTO);
		if(user == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
		
	

}
