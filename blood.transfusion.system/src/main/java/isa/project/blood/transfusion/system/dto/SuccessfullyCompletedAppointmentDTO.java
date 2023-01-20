package isa.project.blood.transfusion.system.dto;

import java.time.LocalDateTime;

public class SuccessfullyCompletedAppointmentDTO {
	
	private LocalDateTime date;
	private Long duration;
	private String centerName;
	private String centerAddress;
	private String centerCity;
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
	public String getCenterName() {
		return centerName;
	}
	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}
	public String getCenterAddress() {
		return centerAddress;
	}
	public void setCenterAddress(String centerAddress) {
		this.centerAddress = centerAddress;
	}
	public String getCenterCity() {
		return centerCity;
	}
	public void setCenterCity(String centerCity) {
		this.centerCity = centerCity;
	}
	

}
