package isa.project.blood.transfusion.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isa.project.blood.transfusion.system.model.Authority;
import isa.project.blood.transfusion.system.repository.AuthorityRepository;
import isa.project.blood.transfusion.system.service.AuthorityService;

@Service
public class AuthorityServiceImpl implements AuthorityService{
	
	@Autowired
	private AuthorityRepository authorityRepository;
	
	@Override
	public Authority findByName(String name) {
		return authorityRepository.findByName(name);
	}

}
