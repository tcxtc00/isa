package isa.project.blood.transfusion.system.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import isa.project.blood.transfusion.system.dto.UserDTO;
import isa.project.blood.transfusion.system.dto.UserTokenState;
import isa.project.blood.transfusion.system.model.User;
import isa.project.blood.transfusion.system.repository.UserRepository;
import isa.project.blood.transfusion.system.security.JwtAuthenticationRequest;
import isa.project.blood.transfusion.system.security.TokenUtils;
import isa.project.blood.transfusion.system.service.RegisteredUserService;
import isa.project.blood.transfusion.system.service.impl.CustomUserDetailsService;

@RestController
@RequestMapping(value = "api/users")
public class RegisteredUserController {
	
	@Autowired
	private RegisteredUserService registeredUserService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private TokenUtils tokenUtils;
	
	@Autowired
	private UserRepository userRepository;
	
	
	@PostMapping(path = "/register")
	public ResponseEntity<?> register(@RequestBody UserDTO userDTO){
		User user = registeredUserService.register(userDTO);
		if(user == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PostMapping("/login")
	public ResponseEntity<UserTokenState> createAuthenticationToken(@RequestBody JwtAuthenticationRequest authenticationRequest,
			HttpServletResponse response) {

		// 
		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),
						authenticationRequest.getPassword()));

		// Ubaci korisnika u trenutni security kontekst
		SecurityContextHolder.getContext().setAuthentication(authentication);

		// Kreiraj token za tog korisnika
		User user = (User) authentication.getPrincipal();
		
		String jwt = tokenUtils.generateToken(user.getUsername(), userRepository.findTypeById(user.getId()));
		int expiresIn = tokenUtils.getExpiredIn();

		// Vrati token kao odgovor na uspesnu autentifikaciju
		return ResponseEntity.ok(new UserTokenState(jwt, expiresIn));
	}
	
	@PreAuthorize("hasRole('REGISTEREDUSER')")
	@GetMapping(path = "/all")
	public ResponseEntity<?> getAll(){
		return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
	}
		
	

}
