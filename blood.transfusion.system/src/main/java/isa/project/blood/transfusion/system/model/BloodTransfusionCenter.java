package isa.project.blood.transfusion.system.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class BloodTransfusionCenter {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "address", nullable = false)
	private String address;
	
	@Column(name = "city", nullable = false)
	private String city;
	
	@Column(name = "description", nullable = false)
	private String description;
	
	@Column(name = "rate")
	private Double rate;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "center", fetch = FetchType.LAZY)
	private Set<AvailableAppointment> appointments;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "center", fetch = FetchType.LAZY)
	private Set<Staff> staffs;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "center", fetch = FetchType.LAZY)
	private Set<QuickAppointment> quickAppointments;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getRate() {
		return rate;
	}

	public void setRate(Double rate) {
		this.rate = rate;
	}
	
	

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Set<AvailableAppointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(Set<AvailableAppointment> appointments) {
		this.appointments = appointments;
	}

	public Set<Staff> getStaffs() {
		return staffs;
	}

	public void setStaffs(Set<Staff> staffs) {
		this.staffs = staffs;
	}

	public Set<QuickAppointment> getQuickAppointments() {
		return quickAppointments;
	}

	public void setQuickAppointments(Set<QuickAppointment> quickAppointments) {
		this.quickAppointments = quickAppointments;
	}
	
	
	
	
}
