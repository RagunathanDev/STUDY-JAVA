package com.mail.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class MailUtil {

	@Autowired
	private JavaMailSender sender;

	public String sendMail() {
		SimpleMailMessage message = null;
		try {
			message = new SimpleMailMessage();
			message.setTo("shobanamuruganantham04@gmail.com");
			message.setSubject("REG : System generated maill");
			message.setFrom("raghunathan731@gmail.com");
			message.setText(
					"Dear User,\n The mail was system. \n for the testing purpose \n\n Note:System generated mail. \n Regards,\nRagunathan ");
			sender.send(message);
			System.out.println("Mail send successfully To : ");

		} catch (Exception e) {
			System.out.println("Exception Occured in sed Mail");
		}
		return "Mail send successfully to";
	}

	public static void main(String[] args) {
		MailUtil util = new MailUtil();
		util.sendMail();
	}
}
