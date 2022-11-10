package isa.project.blood.transfusion.system.controller;

import javax.servlet.http.HttpServletResponse;

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
import org.springframework.web.servlet.view.RedirectView;

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
	
	@GetMapping(path = "/current")
	@PreAuthorize("hasRole('REGISTEREDUSER')")
	public ResponseEntity<?> current(){
		User user = registeredUserService.current();
		if(user == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	@PostMapping("/login")
	public ResponseEntity<UserTokenState> createAuthenticationToken(@RequestBody JwtAuthenticationRequest authenticationRequest,
			HttpServletResponse response) {

		UserTokenState token = registeredUserService.login(authenticationRequest);
		if(token == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.ok(token);
	}
	
	@GetMapping(path = "/activate/{username}")
	public RedirectView activateAcount(@PathVariable String username){
		registeredUserService.changeStatusToAccepted(username);
		return new RedirectView("http://localhost:4200/accountActivation");
	}
		

}
