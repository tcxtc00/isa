package isa.project.blood.transfusion.system.service;

import java.util.List;

import isa.project.blood.transfusion.system.dto.AppointmentDTO;
import isa.project.blood.transfusion.system.dto.SortDTO;
import isa.project.blood.transfusion.system.model.QuickAppointment;

public interface QuickAppointmentsService {
	
	public List<QuickAppointment> sort(SortDTO sortDTO);
	public QuickAppointment book(AppointmentDTO appointmentDTO);
	public List<QuickAppointment> notPassed(String username);

}
