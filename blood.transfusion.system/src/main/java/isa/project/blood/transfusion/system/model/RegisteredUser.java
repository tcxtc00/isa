package isa.project.blood.transfusion.system.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@DiscriminatorValue("RegisteredUser")
public class RegisteredUser extends User{

	private static final long serialVersionUID = 1L;

	private static String userType = "ROLE_REGISTEREDUSER";
	
	@JsonManagedReference
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private Set<QRCode> qrCodes;
	
	@Column(name = "questionnaire")
	private boolean questionnaire;
	
	@Column(name = "penalties")
	private int penalties;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private Set<QuickAppointment> appointments;

	
	@Override
    public String getUserType() {
        return userType;
    }

	public Set<QRCode> getQrCodes() {
		return qrCodes;
	}

	public void setQrCodes(Set<QRCode> qrCodes) {
		this.qrCodes = qrCodes;
	}

	public Set<QuickAppointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(Set<QuickAppointment> appointments) {
		this.appointments = appointments;
	}

	public boolean isQuestionnaire() {
		return questionnaire;
	}

	public void setQuestionnaire(boolean questionnaire) {
		this.questionnaire = questionnaire;
	}

	public int getPenalties() {
		return penalties;
	}

	public void setPenalties(int penalties) {
		this.penalties = penalties;
	}
	
	
	
	
	
	
	
	
	

}
