package com.mail.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.mail.util.MailUtil;

public class MailService {

	@Autowired
	private MailUtil mail;

	public void sendMailService() {
		try {
			String subject = "REG : System generated maill";
			String bodyText = "Dear User,\n The mail was system. \n for the testing purpose \n\n Note:System generated mail. \n Regards,\nRagunathan ";
			// mail.sendMail("raghunathan731@gmail.com", "shobanamuruganantham04@gmail.com",
			// subject, bodyText);
		} catch (Exception e) {
			System.out.printf("Exception Occured", e);
		}

	}

	public static void main(String[] args) {
		MailService service = new MailService();
		service.sendMailService();
	}

}
