package isa.project.blood.transfusion.system.service;

import isa.project.blood.transfusion.system.dto.UserDTO;
import isa.project.blood.transfusion.system.model.User;

public interface RegisteredUserService {

	public User register(UserDTO userDTO);
}
