package isa.project.blood.transfusion.system.service;

import java.util.List;

import isa.project.blood.transfusion.system.dto.AppointmentDTO;
import isa.project.blood.transfusion.system.dto.AppointmentResponseDTO;
import isa.project.blood.transfusion.system.dto.SortDTO;
import isa.project.blood.transfusion.system.dto.SuccessfullyCompletedAppointmentDTO;
import isa.project.blood.transfusion.system.model.QuickAppointment;

public interface QuickAppointmentsService {
	
	public List<QuickAppointment> sortFreeAppointments(SortDTO sortDTO);
	public QuickAppointment book(AppointmentDTO appointmentDTO) throws Exception;
	public List<AppointmentResponseDTO> notPassed(String username);
	public QuickAppointment cancel(Long id);
	public List<SuccessfullyCompletedAppointmentDTO> getSuccessfullyCompletedAppointments(String username);
	public List<SuccessfullyCompletedAppointmentDTO> sortSuccessfullyFinishedAppointments(SortDTO sortDTO);

}
