package isa.project.blood.transfusion.system.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import isa.project.blood.transfusion.system.model.BloodTransfusionCenter;
import isa.project.blood.transfusion.system.model.QuickAppointment;

@Repository
public interface QuickAppointmentsRepository extends JpaRepository<QuickAppointment, Long>{
	
	public List<QuickAppointment> findByCenter(BloodTransfusionCenter center);

}
