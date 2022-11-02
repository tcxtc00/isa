package isa.project.blood.transfusion.system.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("RegisteredUser")
public class RegisteredUser extends User{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	

}
