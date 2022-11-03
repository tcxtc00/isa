package isa.project.blood.transfusion.system.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import isa.project.blood.transfusion.system.dto.UserDTO;
import isa.project.blood.transfusion.system.dto.UserTokenState;
import isa.project.blood.transfusion.system.model.User;
import isa.project.blood.transfusion.system.security.JwtAuthenticationRequest;
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
		
		return new ResponseEntity<>(user, HttpStatus.CREATED);
	}
	
	@PostMapping("/login")
	public ResponseEntity<UserTokenState> createAuthenticationToken(@RequestBody JwtAuthenticationRequest authenticationRequest,
			HttpServletResponse response) {

		UserTokenState token = registeredUserService.login(authenticationRequest);
		return ResponseEntity.ok(token);
	}
	
	/*@PreAuthorize("hasRole('REGISTEREDUSER')")
	@GetMapping(path = "/all")
	public ResponseEntity<?> getAll(){
		return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
	}*/
		
	

}
