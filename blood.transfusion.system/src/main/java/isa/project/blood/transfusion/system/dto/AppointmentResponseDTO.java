package isa.project.blood.transfusion.system.dto;

import java.time.LocalDateTime;

public class AppointmentResponseDTO {

	private Long id;
	private LocalDateTime date;
	private Long duration;
	private boolean canCancel;
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
	public boolean isCanCancel() {
		return canCancel;
	}
	public void setCanCancel(boolean canCancel) {
		this.canCancel = canCancel;
	}
	
	
}
