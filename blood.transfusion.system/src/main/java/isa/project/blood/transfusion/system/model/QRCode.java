package isa.project.blood.transfusion.system.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class QRCode {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "file_name", unique = true, nullable = false)
	private String fileName;
	
	@Lob
	@Column(name = "data", nullable = false)
	@Type(type = "org.hibernate.type.BinaryType")
	private byte[] data;
	
	@OneToOne()
	@JoinColumn(name = "appointment_id")
	private QuickAppointment appointment;
	
	@JsonBackReference
	@ManyToOne()
	@JoinColumn(name = "user_id")
	private RegisteredUser user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public QuickAppointment getAppointment() {
		return appointment;
	}

	public void setAppointment(QuickAppointment appointment) {
		this.appointment = appointment;
	}

	public RegisteredUser getUser() {
		return user;
	}

	public void setUser(RegisteredUser user) {
		this.user = user;
	}
	
	
	

}
