package isa.project.blood.transfusion.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import isa.project.blood.transfusion.system.model.Authority;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Long>{

	public Authority findByName(String name);
	
}
