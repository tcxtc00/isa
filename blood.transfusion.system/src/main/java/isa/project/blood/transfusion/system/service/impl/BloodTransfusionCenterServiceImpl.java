package isa.project.blood.transfusion.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isa.project.blood.transfusion.system.model.BloodTransfusionCenter;
import isa.project.blood.transfusion.system.repository.BloodTransfusionCenterRepository;
import isa.project.blood.transfusion.system.service.BloodTransfusionCenterService;

@Service
public class BloodTransfusionCenterServiceImpl implements BloodTransfusionCenterService{

	@Autowired
	private BloodTransfusionCenterRepository bloodTransfusionCenterRepository;
	
	@Override
	public List<BloodTransfusionCenter> getAll() {
		for(BloodTransfusionCenter b: bloodTransfusionCenterRepository.findAll()) {
			System.out.println();
		}
		return bloodTransfusionCenterRepository.findAll();
	}

}
