package isa.project.blood.transfusion.system.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isa.project.blood.transfusion.system.dto.SortDTO;
import isa.project.blood.transfusion.system.model.BloodTransfusionCenter;
import isa.project.blood.transfusion.system.model.QuickAppointment;
import isa.project.blood.transfusion.system.repository.BloodTransfusionCenterRepository;
import isa.project.blood.transfusion.system.repository.QuickAppointmentsRepository;
import isa.project.blood.transfusion.system.service.QuickAppointmentsService;

@Service
public class QuickAppointmentsServiceImpl implements QuickAppointmentsService{

	@Autowired
	private BloodTransfusionCenterRepository bloodTransfusionCenterRepository;
	
	@Autowired
	private QuickAppointmentsRepository quickAppointmentsRepository;
	
	@Override
	public List<QuickAppointment> sort(SortDTO sortDTO) {
		
		BloodTransfusionCenter center = bloodTransfusionCenterRepository.findById(sortDTO.getId()).get();
		List<QuickAppointment> appointments = quickAppointmentsRepository.findByCenter(center);
		
		if(sortDTO.getSortBy().equals("Date")) {
			if(sortDTO.getSortType().equals("Ascending")) {
				Collections.sort(appointments, (a1, a2) ->
			    (a1.getDate().compareTo(a2.getDate())));
			}
			if(sortDTO.getSortType().equals("Descending")) {
				Collections.sort(appointments, (a1, a2) ->
			    (a2.getDate().compareTo(a1.getDate())));
			}
		}
		
		if(sortDTO.getSortBy().equals("Duration")) {
			if(sortDTO.getSortType().equals("Ascending")) {
				Collections.sort(appointments, (a1, a2) ->
			    (a1.getDuration().compareTo(a2.getDuration())));
			}
			if(sortDTO.getSortType().equals("Descending")) {
				Collections.sort(appointments, (a1, a2) ->
			    (a2.getDuration().compareTo(a1.getDuration())));
			}
		}
		
		return appointments;
	}

}
