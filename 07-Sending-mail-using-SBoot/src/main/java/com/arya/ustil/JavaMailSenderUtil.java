package com.arya.ustil;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class JavaMailSenderUtil {
	
	@Autowired
	private JavaMailSender javaMailSender;

	public boolean sendMail(String to, String subject, String body) {
		try {
			SimpleMailMessage smsg=new SimpleMailMessage();
			smsg.setTo(to);
			smsg.setSubject(subject);
			smsg.setText(body);
			javaMailSender.send(smsg);
			return true;
			
		} catch (Exception e) {
		}
		return false;
	}
	
	public boolean sendMailByMineType(String subject, String body) {
		try {
			MimeMessage mimeMessage = javaMailSender.createMimeMessage();
			MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
			String[] mails={"prabhat823349@gmail.com","mail2k.prabhat@gmail.com"};
			mimeMessageHelper.setTo(mails);
			mimeMessageHelper.setSubject(subject);
			mimeMessageHelper.setText(body,true);
			javaMailSender.send(mimeMessage);
			return true;
			
		} catch (Exception e) {
		}
		return false;
	}
}
