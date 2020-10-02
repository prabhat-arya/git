package com.arya;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.arya.ustil.JavaMailSenderUtil;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);
		JavaMailSenderUtil jmsu=ctx.getBean(JavaMailSenderUtil.class);
		
		//String to="prabhat823349@gmail.com";
		String subject="Spring Boot Mail App";
		String body="<b> This mail is sending through java mail sender</b>";
		//boolean sendMail = jmsu.sendMail(to, subject, body);
		boolean sendMail = jmsu.sendMailByMineType(subject, body);
		System.out.println("Successfully send mails =" +sendMail);
		
		
		/** Important Note*/
		/*1)Add the spring-boot-starter-mail dependency */
		/*2)add the SMTP properties in to properties file */
		/*3)create the util class and inject the JavaMailSender class in that using @Autowired*/
		/*4)create the object of SimpleMailMessage or MimeMessage*/
		/*5)Before sending the mails first you have enable the 'Less secure app access' in your gmail
		 *   go to google search Less secure app access and enable it*/
		/**/
		/**/
	}

}
