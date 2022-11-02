package isa.project.blood.transfusion.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import isa.project.blood.transfusion.system.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	public User findByUsername(String username);

}
