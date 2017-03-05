package com.ch.occ.email;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.ch.occ.utils.PropertyUtil;
import com.ch.occ.utils.constants.FileConstants;



/**
 * @author 11:59:11 AM Prasanna Kumar Reddy Mar 6, 2016
 */
public class EmailUtility implements FileConstants {
	public static void sendEmail(String subject, String body) {
	    final String username = "automationexecutionreports@chtsinc.com";
	       final String password = "Test@12345$";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("AutomationReports@chtsinc.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(PropertyUtil.getConfigValue(EMAILIDS)));
			message.setSubject(subject);
			message.setText(body);
			message.setContent(body, "text/html;charset=gb2312");

			Transport.send(message);

			System.out.println("Sent Sucessfully");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}
