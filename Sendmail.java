package tasks;

import java.util.Properties;
import javax.mail.*;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
public class Sendmail 
{
	static void sendemail1(String to, String mail, String name, String phone)throws Exception
	{
	    String subject = "Visitor Details";
	    String msg =" Name : "+name+"\n Phone Number : "+phone+"\n Email Address : "+mail+"\n";
	    final String from ="/*Your Email Id*/"; //Your email id that will be used to send mail
	    final  String password ="/*Email Password*/"; //email password


	    Properties props = new Properties();  
	    props.setProperty("mail.transport.protocol", "smtp");     
	    props.setProperty("mail.host", "smtp.gmail.com");  
	    props.put("mail.smtp.auth", "true");  
	    props.put("mail.smtp.port", "465");  
	    props.put("mail.debug", "true");  
	    props.put("mail.smtp.socketFactory.port", "465");  
	    props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");  
	    props.put("mail.smtp.socketFactory.fallback", "false");  
	    Session session = Session.getDefaultInstance(props,  
	    new javax.mail.Authenticator() {
	       protected PasswordAuthentication getPasswordAuthentication() {  
	       return new PasswordAuthentication(from,password);  
	   }  
	   });    
	   Transport transport = session.getTransport();  
	   InternetAddress addressFrom = new InternetAddress(from);  

	   MimeMessage message = new MimeMessage(session);  
	   message.setSender(addressFrom);  
	   message.setSubject(subject);  
	   message.setContent(msg, "text/plain");  
	   message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));  

	   transport.connect();  
	   Transport.send(message);  
	   transport.close();
	}
	static void sendemail2(String to,String name,String phone,String intime,String outtime,String hname)throws Exception
	{
	    String subject = "Visit Details";
	    String msg =" Name : "+name+"\n Phone Number : "+phone+"\n Email Address : "+to+"\n Check in time : "+intime+"\n Check out time : "+outtime+"\n Host Name : "+hname+"\n Address Visited : Innovaccer Office";                                           
	    final String from ="/*Your email id*/"; //Your email id that will be used to send mail
	    final  String password ="/*Email Password*/"; //Email Password


	    Properties props = new Properties();  
	    props.setProperty("mail.transport.protocol", "smtp");     
	    props.setProperty("mail.host", "smtp.gmail.com");  
	    props.put("mail.smtp.auth", "true");  
	    props.put("mail.smtp.port", "465");  
	    props.put("mail.debug", "true");  
	    props.put("mail.smtp.socketFactory.port", "465");  
	    props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");  
	    props.put("mail.smtp.socketFactory.fallback", "false");  
	    Session session = Session.getDefaultInstance(props,  
	    new javax.mail.Authenticator() {
	       protected PasswordAuthentication getPasswordAuthentication() {  
	       return new PasswordAuthentication(from,password);  
	   }  
	   });  

	   //session.setDebug(true);  
	   Transport transport = session.getTransport();  
	   InternetAddress addressFrom = new InternetAddress(from);  

	   MimeMessage message = new MimeMessage(session);  
	   message.setSender(addressFrom);  
	   message.setSubject(subject);  
	   message.setContent(msg, "text/plain");  
	   message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));  

	   transport.connect();  
	   Transport.send(message);  
	   transport.close();
	}
	public static void main(String args[])throws Exception
	{
		
	}
}

