package com.financ.comunication;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import com.financ.model.ScheduledEmail;

public class EmailManagement {

	@Autowired
	private static JavaMailSender javaMailSender;

	@Value("${spring.mail.username}")
	private static String fromEmail;

	public static void send(ScheduledEmail scheduledEmail) {
		MimeMessage mail = javaMailSender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(mail, true);
			helper.setTo(scheduledEmail.getEmail());
			helper.setReplyTo(scheduledEmail.getEmail());
			helper.setFrom(fromEmail);
			helper.setSubject(scheduledEmail.getSubject());
			helper.setText(scheduledEmail.getText());
			javaMailSender.send(mail);
		} catch (MessagingException e) {
			e.printStackTrace();
		} finally {
		}
		
	}
}
