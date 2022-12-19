package isa.project.blood.transfusion.system.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import isa.project.blood.transfusion.system.dto.UserDTO;
import isa.project.blood.transfusion.system.dto.UserTokenState;
import isa.project.blood.transfusion.system.model.Authority;
import isa.project.blood.transfusion.system.model.Gender;
import isa.project.blood.transfusion.system.model.RegisteredUser;
import isa.project.blood.transfusion.system.model.User;
import isa.project.blood.transfusion.system.model.UserStatus;
import isa.project.blood.transfusion.system.repository.UserRepository;
import isa.project.blood.transfusion.system.security.JwtAuthenticationRequest;
import isa.project.blood.transfusion.system.security.SecurityUtils;
import isa.project.blood.transfusion.system.security.TokenUtils;
import isa.project.blood.transfusion.system.service.AuthorityService;
import isa.project.blood.transfusion.system.service.EmailService;
import isa.project.blood.transfusion.system.service.RegisteredUserService;

@Service
public class RegisteredUserServiceImpl implements RegisteredUserService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private AuthorityService authorityService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private TokenUtils tokenUtils;
	
	@Autowired
	private EmailService emailService;
	
	
	public User register(UserDTO userDTO) {
		
		if(!userDTO.getJmbg().matches("[0-9]{13,13}")) {
			return null;
		}	
		if(!userDTO.getPhoneNumber().matches("[0-9]{7,15}")) {
			return null;
		}
		if(!userDTO.getAddress().matches("[a-žA-Ž\s[0-9]*]+")) {
			return null;
		}
		if(!userDTO.getName().matches("[a-žA-Ž\s]+")) {
			return null;
		}
		if(!userDTO.getSurname().matches("[a-žA-Ž\s]+")) {
			return null;
		}
		if(!userDTO.getProfession().matches("[a-žA-Ž\s]+")) {
			return null;
		}
		if(!userDTO.getProfessionInfo().matches("[a-zA-Z\s[0-9]*]+")) {
			return null;
		}
		if(!userDTO.getCity().matches("[a-žA-Ž\s]+")) {
			return null;
		}
		if(!userDTO.getCountry().matches("[a-žA-Ž\s]+")) {
			return null;
		}
		if(!userDTO.getGender().equals("Male")) {	
			if(!userDTO.getGender().equals("Female")) {
				return null;
			}	
		}
		if(!userDTO.getUsername().matches("[A-Za-z0-9\\.\\+]+@gmail\\.com")) {
			return null;
		}
		if(userDTO.getPassword().matches("^$")) {
			return null;
		}
		
		User user = userRepository.findByUsername(userDTO.getUsername());
		
		if(user != null) {
			return null;
		}
		
		RegisteredUser registeredUser = new RegisteredUser();
		ArrayList<Authority> authorities = new ArrayList<>();
		authorities.add(authorityService.findByName("ROLE_REGISTEREDUSER"));
        registeredUser.setAuthorities(authorities);
        registeredUser.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        registeredUser.setUsername(userDTO.getUsername());
        registeredUser.setName(userDTO.getName());
        registeredUser.setSurname(userDTO.getSurname());
        registeredUser.setPhoneNumber(userDTO.getPhoneNumber());
        registeredUser.setAddress(userDTO.getAddress());
        registeredUser.setCity(userDTO.getCity());
        registeredUser.setCountry(userDTO.getCountry());
        registeredUser.setProfession(userDTO.getProfession());
        registeredUser.setProfessionInfo(userDTO.getProfessionInfo());
        registeredUser.setJmbg(userDTO.getJmbg());
        registeredUser.setPenalties(0);
        registeredUser.setStatus(UserStatus.Pending);
        if(userDTO.getGender().equals("Male")) {
        	registeredUser.setGender(Gender.Male);
        }else if (userDTO.getGender().equals("Female")) {
        	registeredUser.setGender(Gender.Female);
        }     
        try {
			emailService.registrationEmail(registeredUser);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      
        return userRepository.save(registeredUser);
		
	}


	@Override
	public UserTokenState login(JwtAuthenticationRequest authenticationRequest) {
		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),
						authenticationRequest.getPassword()));

		// Ubaci korisnika u trenutni security kontekst
		SecurityContextHolder.getContext().setAuthentication(authentication);

		// Kreiraj token za tog korisnika
		User user = (User) authentication.getPrincipal();
		
		if(!user.getStatus().equals(UserStatus.Accepted)) {
			return null;
		}
		
		String jwt = tokenUtils.generateToken(user.getUsername(), userRepository.findTypeById(user.getId()));
		int expiresIn = tokenUtils.getExpiredIn();

		// Vrati token kao odgovor na uspesnu autentifikaciju
		return new UserTokenState(jwt, expiresIn);
	}


	@Override
	public User current() {
		String username = SecurityUtils.getCurrentUserLogin().get();
        return userRepository.findByUsername(username);
	}


	@Override
	public User changeStatusToAccepted(String username) {
		User user = userRepository.findByUsername(username);
		user.setStatus(UserStatus.Accepted);
		return userRepository.save(user);
	}
	
	//@Scheduled(cron = "0 0 0 1 * *")
	//@Scheduled(cron = " 0 */5 * * * *")
	public void deletePenalties() {
		List<RegisteredUser> users = userRepository.getReqisteredUsers();
		
		for(RegisteredUser user: users) {
			user.setPenalties(0);
			userRepository.save(user);
		}
		
	}
}
