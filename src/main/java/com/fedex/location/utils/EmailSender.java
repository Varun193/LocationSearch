package com.fedex.location.utils;

public interface EmailSender {
	
	void sendEmail(String toAddress, String sub, String body);

}
