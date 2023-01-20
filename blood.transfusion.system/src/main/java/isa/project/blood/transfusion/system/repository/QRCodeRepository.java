package isa.project.blood.transfusion.system.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import isa.project.blood.transfusion.system.model.QRCode;
import isa.project.blood.transfusion.system.model.RegisteredUser;

@Repository
public interface QRCodeRepository extends JpaRepository<QRCode, Long>{

	public List<QRCode> findByUser(RegisteredUser user);
	
}
