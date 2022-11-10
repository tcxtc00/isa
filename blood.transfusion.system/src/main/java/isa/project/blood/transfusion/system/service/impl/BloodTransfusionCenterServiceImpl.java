package isa.project.blood.transfusion.system.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isa.project.blood.transfusion.system.dto.SortDTO;
import isa.project.blood.transfusion.system.model.AppointmentStatus;
import isa.project.blood.transfusion.system.model.BloodTransfusionCenter;
import isa.project.blood.transfusion.system.model.QuickAppointment;
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
		
		if(sortDTO.getSortBy().equals("") || sortDTO.getSortType().equals("")) {
			return null;
		}
		
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

	@Override
	public BloodTransfusionCenter getById(Long id) {
		BloodTransfusionCenter center = bloodTransfusionCenterRepository.findById(id).get();
		Set<QuickAppointment> appointments = center.getQuickAppointments();
		Set<QuickAppointment> filteredAppointments = appointments.stream()
				.filter(a -> (a.getStatus().equals(AppointmentStatus.Free)))
                .collect(Collectors.toSet());
		center.setQuickAppointments(filteredAppointments);
		return center;
	}

}
