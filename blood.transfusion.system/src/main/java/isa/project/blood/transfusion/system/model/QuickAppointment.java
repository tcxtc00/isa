package isa.project.blood.transfusion.system.model;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class QuickAppointment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Version
	private Long version;
	
	@Column(name = "date", nullable = false)
	private LocalDateTime date;
	
	@Column(name = "duration", nullable = false)
	private Long duration;
	
	@Column(name = "status", nullable = false)
	private AppointmentStatus status;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "appointment_staff",
				joinColumns = @JoinColumn(name = "appointment_id", referencedColumnName = "id"),
				inverseJoinColumns = @JoinColumn(name = "staff_id", referencedColumnName = "id"))
	private Set<Staff> staffs;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "center_id")
	private BloodTransfusionCenter center;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "user_id")
	private RegisteredUser user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public Long getDuration() {
		return duration;
	}

	public void setDuration(Long duration) {
		this.duration = duration;
	}

	public Set<Staff> getStaffs() {
		return staffs;
	}

	public void setStaffs(Set<Staff> staffs) {
		this.staffs = staffs;
	}

	public BloodTransfusionCenter getCenter() {
		return center;
	}

	public void setCenter(BloodTransfusionCenter center) {
		this.center = center;
	}

	public RegisteredUser getUser() {
		return user;
	}

	public void setUser(RegisteredUser user) {
		this.user = user;
	}

	public AppointmentStatus getStatus() {
		return status;
	}

	public void setStatus(AppointmentStatus status) {
		this.status = status;
	}
	
	
	
	
	
	
	

}
