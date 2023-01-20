package isa.project.blood.transfusion.system.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import isa.project.blood.transfusion.system.model.AppointmentStatus;
import isa.project.blood.transfusion.system.model.BloodTransfusionCenter;
import isa.project.blood.transfusion.system.model.QuickAppointment;
import isa.project.blood.transfusion.system.model.RegisteredUser;

@Repository
public interface QuickAppointmentsRepository extends JpaRepository<QuickAppointment, Long>{
	
	public List<QuickAppointment> findByCenterAndStatus(BloodTransfusionCenter center, AppointmentStatus status);
	public List<QuickAppointment> findByStatusAndUser(AppointmentStatus status, RegisteredUser user);

}
