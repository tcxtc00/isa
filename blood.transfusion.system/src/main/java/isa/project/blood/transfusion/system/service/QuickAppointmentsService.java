package isa.project.blood.transfusion.system.service;

import java.util.List;

import isa.project.blood.transfusion.system.dto.SortDTO;
import isa.project.blood.transfusion.system.model.QuickAppointment;

public interface QuickAppointmentsService {
	
	public List<QuickAppointment> sort(SortDTO sortDTO);

}
