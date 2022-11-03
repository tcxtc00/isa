package isa.project.blood.transfusion.system.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isa.project.blood.transfusion.system.dto.SortDTO;
import isa.project.blood.transfusion.system.model.BloodTransfusionCenter;
import isa.project.blood.transfusion.system.repository.BloodTransfusionCenterRepository;
import isa.project.blood.transfusion.system.service.BloodTransfusionCenterService;

@Service
public class BloodTransfusionCenterServiceImpl implements BloodTransfusionCenterService{

	@Autowired
	private BloodTransfusionCenterRepository bloodTransfusionCenterRepository;
	
	@Override
	public List<BloodTransfusionCenter> getAll() {
		return bloodTransfusionCenterRepository.findAll();
	}

	@Override
	public List<BloodTransfusionCenter> sort(SortDTO sortDTO) {
		List<BloodTransfusionCenter> centers = bloodTransfusionCenterRepository.findAll();
		if(sortDTO.getSortBy().equals("Name")) {
			if(sortDTO.getSortType().equals("Ascending")) {
				Collections.sort(centers, (c1, c2) ->
			    (c1.getName().compareTo(c2.getName())));
			}
			if(sortDTO.getSortType().equals("Descending")) {
				Collections.sort(centers, (c1, c2) ->
			    (c2.getName().compareTo(c1.getName())));
			}
		}
		
		if(sortDTO.getSortBy().equals("City")) {
			if(sortDTO.getSortType().equals("Ascending")) {
				Collections.sort(centers, (c1, c2) ->
			    (c1.getCity().compareTo(c2.getCity())));
			}
			if(sortDTO.getSortType().equals("Descending")) {
				Collections.sort(centers, (c1, c2) ->
				 (c2.getCity().compareTo(c1.getCity())));
			}
		}
		if(sortDTO.getSortBy().equals("Rate")) {
			if(sortDTO.getSortType().equals("Ascending")) {
				Collections.sort(centers, (c1, c2) ->
			    Double.compare(c1.getRate(), c2.getRate()));
			}
			if(sortDTO.getSortType().equals("Descending")) {
				Collections.sort(centers, (c1, c2) ->
				 Double.compare(c2.getRate(), c1.getRate()));
			}
		}
		return centers;
	}

}
