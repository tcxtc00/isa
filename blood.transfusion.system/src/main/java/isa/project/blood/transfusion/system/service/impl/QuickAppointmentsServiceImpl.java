package isa.project.blood.transfusion.system.service.impl;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.google.zxing.WriterException;

import isa.project.blood.transfusion.system.dto.AppointmentDTO;
import isa.project.blood.transfusion.system.dto.AppointmentResponseDTO;
import isa.project.blood.transfusion.system.dto.SortDTO;
import isa.project.blood.transfusion.system.dto.SuccessfullyCompletedAppointmentDTO;
import isa.project.blood.transfusion.system.model.AppointmentStatus;
import isa.project.blood.transfusion.system.model.BloodTransfusionCenter;
import isa.project.blood.transfusion.system.model.QuickAppointment;
import isa.project.blood.transfusion.system.model.RegisteredUser;
import isa.project.blood.transfusion.system.model.Staff;
import isa.project.blood.transfusion.system.repository.BloodTransfusionCenterRepository;
import isa.project.blood.transfusion.system.repository.QuickAppointmentsRepository;
import isa.project.blood.transfusion.system.repository.UserRepository;
import isa.project.blood.transfusion.system.service.EmailService;
import isa.project.blood.transfusion.system.service.QRCodeService;
import isa.project.blood.transfusion.system.service.QuickAppointmentsService;

@Service
public class QuickAppointmentsServiceImpl implements QuickAppointmentsService{

	@Autowired
	private BloodTransfusionCenterRepository bloodTransfusionCenterRepository;
	
	@Autowired
	private QuickAppointmentsRepository quickAppointmentsRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private QRCodeService qrCodeService;
	
	@Autowired
	private EmailService emailService;
	
	@Override
	public List<QuickAppointment> sortFreeAppointments(SortDTO sortDTO) {
		
		BloodTransfusionCenter center = bloodTransfusionCenterRepository.findById(sortDTO.getId()).get();
		List<QuickAppointment> appointments = quickAppointmentsRepository.findByCenterAndStatus(center, AppointmentStatus.Free);
		
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

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public QuickAppointment book(AppointmentDTO appointmentDTO) throws Exception{
		

		RegisteredUser user = (RegisteredUser) userRepository.findByUsername(appointmentDTO.getUsername());
		
		if(user.getPenalties() >= 3) {
			return null;
		}
		
		if(!user.isQuestionnaire()) {
			return null;
		}
		QuickAppointment appointment = quickAppointmentsRepository.findById(appointmentDTO.getId()).get();
		List<QuickAppointment> finishedAppointments = quickAppointmentsRepository.findByStatusAndUser(AppointmentStatus.SuccessFinished, user);
		for(QuickAppointment finishedAppointment: finishedAppointments) {
			long months = finishedAppointment.getDate().until(appointment.getDate(), ChronoUnit.MONTHS);
			if(months < 6 /*&& months > 0*/) {
				return null;
			}
		}
		
		appointment.setStatus(AppointmentStatus.Booked);
		Set<QuickAppointment> appointments = user.getAppointments();
		for(QuickAppointment qa: appointments) {
			if(qa.getCenter().getId() == appointment.getCenter().getId() && qa.getDate().compareTo(appointment.getDate()) == 0 && qa.getDuration() == appointment.getDuration()) {
				return null;
			}
		}
		appointment.setUser(user);
		try {
			String fileName = qrCodeService.createQRCode(appointment, 250, 250).getFileName();
			emailService.sendQRCode(appointment, fileName);
		} catch (WriterException | IOException | MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		QuickAppointment app = quickAppointmentsRepository.save(appointment);
		System.out.println(app.getStatus());
		return app;
	}

	@Override
	public List<AppointmentResponseDTO> notPassed(String username) {
		RegisteredUser user = (RegisteredUser) userRepository.findByUsername(username);
		List<QuickAppointment> appointments = quickAppointmentsRepository.findByStatusAndUser(AppointmentStatus.Booked, user);
		List<QuickAppointment> filteredAppointments = appointments.stream().
				filter(a -> (a.getDate().compareTo(LocalDateTime.now())>= 0))
                .collect(Collectors.toList());
		List<AppointmentResponseDTO> result = new ArrayList<>();
		for(QuickAppointment qa: filteredAppointments) {
			AppointmentResponseDTO appointment = new AppointmentResponseDTO();
			appointment.setDate(qa.getDate());
			appointment.setDuration(qa.getDuration());
			appointment.setId(qa.getId());
			if(qa.getDate().minusHours(24).compareTo(LocalDateTime.now()) >= 0) {
				appointment.setCanCancel(true);
			}else {
				appointment.setCanCancel(false);
			}
			result.add(appointment);
		}
		return result;
	}

	@Override
	public QuickAppointment cancel(Long id) {
		QuickAppointment appointment = quickAppointmentsRepository.findById(id).get();
		appointment.setStatus(AppointmentStatus.Canceled);
		quickAppointmentsRepository.save(appointment);
		QuickAppointment sameAppointment = new QuickAppointment();
		sameAppointment.setCenter(appointment.getCenter());
		sameAppointment.setDate(appointment.getDate());
		sameAppointment.setDuration(appointment.getDuration());
		Set<Staff> staffs = new HashSet<>();
		for(Staff staff: appointment.getStaffs()) {
			staffs.add(staff);
		}
		sameAppointment.setStaffs(staffs);
		sameAppointment.setStatus(AppointmentStatus.Free);
		
		return quickAppointmentsRepository.save(sameAppointment);
	}

	@Override
	public List<SuccessfullyCompletedAppointmentDTO> getSuccessfullyCompletedAppointments(String username) {
		
		RegisteredUser user = (RegisteredUser) userRepository.findByUsername(username);
		List<QuickAppointment> successfullyCompletedAppointments = quickAppointmentsRepository.findByStatusAndUser(AppointmentStatus.SuccessFinished, user);
		List<SuccessfullyCompletedAppointmentDTO> result = new ArrayList<>();
		for(QuickAppointment appointment: successfullyCompletedAppointments) {
			SuccessfullyCompletedAppointmentDTO dto = new SuccessfullyCompletedAppointmentDTO();
			dto.setDate(appointment.getDate());
			dto.setDuration(appointment.getDuration());
			dto.setCenterName(appointment.getCenter().getName());
			dto.setCenterAddress(appointment.getCenter().getAddress());
			dto.setCenterCity(appointment.getCenter().getCity());
			result.add(dto);
		}
		return result;
	}

	@Override
	public List<SuccessfullyCompletedAppointmentDTO> sortSuccessfullyFinishedAppointments(SortDTO sortDTO) {
		RegisteredUser user = (RegisteredUser) userRepository.findByUsername(sortDTO.getUsername());
		List<QuickAppointment> appointments = quickAppointmentsRepository.findByStatusAndUser(AppointmentStatus.SuccessFinished, user);
		
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
		
		List<SuccessfullyCompletedAppointmentDTO> result = new ArrayList<>();
		for(QuickAppointment appointment: appointments) {
			SuccessfullyCompletedAppointmentDTO dto = new SuccessfullyCompletedAppointmentDTO();
			dto.setDate(appointment.getDate());
			dto.setDuration(appointment.getDuration());
			dto.setCenterName(appointment.getCenter().getName());
			dto.setCenterAddress(appointment.getCenter().getAddress());
			dto.setCenterCity(appointment.getCenter().getCity());
			result.add(dto);
		}
		return result;
	}

}
