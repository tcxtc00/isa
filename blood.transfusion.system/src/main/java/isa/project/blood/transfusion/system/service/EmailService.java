package isa.project.blood.transfusion.system.service;

import javax.mail.MessagingException;

import isa.project.blood.transfusion.system.model.User;

public interface EmailService {

	public void registrationEmail(User user) throws MessagingException;
}
