package com.cyu.laclad.utils;

import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class LacladUtils {
	private static final Random RANDOM = new Random();
	public static final char[] validCharacters = new String("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789").toCharArray();
	public static final int PASWWORD_LENGHT = 8;
	
	public static String generateRandomPassword() {
		char[] password = new char[PASWWORD_LENGHT];
        for (int i = 0; i < PASWWORD_LENGHT; i++) {
        	password[i] = validCharacters[RANDOM.nextInt(validCharacters.length)];
		}
        return new String(password);
    }
	
	public static void sendEmail(String email, String name, String newPssword) {
		final String username = "ajcr81@gmail.com";
		final String password = "GM@jcr81";
	
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		
		
		Session session = Session.getInstance(props, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("laclad@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
			message.setSubject("LACLAD Credentials");
			message.setText("Dear ," + name + " those are your credentials for LACLAD application. Username: " + email + " Password: " + newPssword + " http://localhost:8080/laclad/");
			//Transport.send(message);
			
			System.out.println("Done");
	
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}
