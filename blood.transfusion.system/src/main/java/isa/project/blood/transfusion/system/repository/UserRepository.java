package isa.project.blood.transfusion.system.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import isa.project.blood.transfusion.system.model.RegisteredUser;
import isa.project.blood.transfusion.system.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	public User findByUsername(String username);
	@Query(value = "SELECT type FROM users_table WHERE id = ?1", nativeQuery = true)
	public String findTypeById(Long id);

	@Query(value = "SELECT * FROM public.users_table WHERE id in (SELECT user_id FROM public.user_authority WHERE authority_id = 1);", nativeQuery = true)
	public List<RegisteredUser> getReqisteredUsers();
}
