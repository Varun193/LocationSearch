package com.fedex.location.utils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailSenderImpl implements EmailSender {

	    @Autowired
		JavaMailSender javaMailSender;
	    
	@Override
	public void sendEmail(String toAddress, String sub, String body) {
		
		MimeMessage MimeMessage= javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(MimeMessage);
		try {
			helper.setTo(toAddress);
			helper.setSubject(sub);
			helper.setText(body);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
		javaMailSender.send(MimeMessage);
	    

	}

}
