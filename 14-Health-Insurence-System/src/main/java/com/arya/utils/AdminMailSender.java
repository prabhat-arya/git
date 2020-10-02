package com.arya.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.arya.admin.entities.AdminAccountEntity;

@Component
public class AdminMailSender {
	@Autowired(required = true)
	private JavaMailSender javaMailSender;
	
	public boolean sendMail(AdminAccountEntity Admin) {
		boolean isTrue=false;
		try {
			MimeMessage mimeMessage = javaMailSender.createMimeMessage();
			MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
			
			mimeMessageHelper.setTo(Admin.getEmailId());
			mimeMessageHelper.setSubject("Unlock Account");
			System.out.println("sending");
			mimeMessageHelper.setText(getUnlockEmailBody(Admin),true);
			System.out.println("sending");
			javaMailSender.send(mimeMessage);
			isTrue=true;
			System.out.println(isTrue);
		} catch (Exception e) {
		}
		return isTrue;
	}

	private String getUnlockEmailBody(AdminAccountEntity Admin) throws IOException {
		 StringBuffer sb=new StringBuffer();
		 FileReader fr= new FileReader("Email-body.txt");
		 BufferedReader br=new BufferedReader(fr);
		 String line=br.readLine();
		 while(line!=null) {
			 sb.append(line);
			 line=br.readLine();
		 }
		 System.out.println("file is readed");
		 br.close();
		 
		 String mailBody=sb.toString();
			
			  mailBody=mailBody.replace("{FNAME}", Admin.getName());
			//  mailBody=mailBody.replace("{TEMP-PWD}", PasswordGenerator.generateRandomPassword(AppContent.pwd_Lenth));
			  mailBody=mailBody.replace("{TEMP-PWD}", Admin.getTempPassword());
			  mailBody=mailBody.replace("{EMAIL}", Admin.getEmailId());
				 System.out.println("file is ");
		return mailBody;
	}

}
