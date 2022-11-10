package isa.project.blood.transfusion.system.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@DiscriminatorValue("staff")
public class Staff extends User{
	
	private static final long serialVersionUID = 1L;
	
	private static String userType = "ROLE_STAFF";
	
	@JsonBackReference
	@ManyToOne()
	private BloodTransfusionCenter center;
	
	@Override
    public String getUserType() {
        return userType;
    }

	public BloodTransfusionCenter getCenter() {
		return center;
	}

	public void setCenter(BloodTransfusionCenter center) {
		this.center = center;
	}
	
	

}
