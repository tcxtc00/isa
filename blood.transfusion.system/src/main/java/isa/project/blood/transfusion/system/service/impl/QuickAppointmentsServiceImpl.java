package isa.project.blood.transfusion.system.service.impl;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.zxing.WriterException;

import isa.project.blood.transfusion.system.dto.AppointmentDTO;
import isa.project.blood.transfusion.system.dto.AppointmentResponseDTO;
import isa.project.blood.transfusion.system.dto.SortDTO;
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
	public List<QuickAppointment> sort(SortDTO sortDTO) {
		
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
	public QuickAppointment book(AppointmentDTO appointmentDTO) {
		
		QuickAppointment appointment = quickAppointmentsRepository.findById(appointmentDTO.getId()).get();
		appointment.setStatus(AppointmentStatus.Booked);
		RegisteredUser user = (RegisteredUser) userRepository.findByUsername(appointmentDTO.getUsername());
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
		
		return quickAppointmentsRepository.save(appointment);
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

}