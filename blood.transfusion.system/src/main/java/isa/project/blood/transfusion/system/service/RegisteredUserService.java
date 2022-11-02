package isa.project.blood.transfusion.system.service;

import isa.project.blood.transfusion.system.dto.UserDTO;
import isa.project.blood.transfusion.system.dto.UserTokenState;
import isa.project.blood.transfusion.system.model.User;
import isa.project.blood.transfusion.system.security.JwtAuthenticationRequest;

public interface RegisteredUserService {

	public User register(UserDTO userDTO);
	public UserTokenState login(JwtAuthenticationRequest authenticationRequest);
}
