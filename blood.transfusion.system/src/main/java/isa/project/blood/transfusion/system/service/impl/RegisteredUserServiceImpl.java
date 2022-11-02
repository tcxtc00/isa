package isa.project.blood.transfusion.system.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import isa.project.blood.transfusion.system.dto.UserDTO;
import isa.project.blood.transfusion.system.model.Authority;
import isa.project.blood.transfusion.system.model.Gender;
import isa.project.blood.transfusion.system.model.RegisteredUser;
import isa.project.blood.transfusion.system.model.User;
import isa.project.blood.transfusion.system.repository.UserRepository;
import isa.project.blood.transfusion.system.service.AuthorityService;
import isa.project.blood.transfusion.system.service.RegisteredUserService;

@Service
public class RegisteredUserServiceImpl implements RegisteredUserService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private AuthorityService authorityService;
	
	
	public User register(UserDTO userDTO) {
		
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
        if(userDTO.getGender().equals("Male")) {
        	registeredUser.setGender(Gender.Male);
        }else if (userDTO.getGender().equals("Female")) {
        	registeredUser.setGender(Gender.Femaile);
        }
      
        return userRepository.save(registeredUser);
		
	}
}
