package isa.project.blood.transfusion.system.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@DiscriminatorValue("staff")
public class Staff extends User{
	
	private static final long serialVersionUID = 1L;
	
	private static String userType = "ROLE_STAFF";
	
	@Override
    public String getUserType() {
        return userType;
    }

}
