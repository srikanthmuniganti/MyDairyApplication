package com.mycompany.gui;/*
import java.util.*;  
import javax.mail.*;  
import javax.mail.internet.*;  
import javax.activation.*;  

public class SendEmail {
	
	 public static void main(String [] args){  
	      String to = "srikanthmuniganti7977@gmail.com";//change accordingly  
	      String from = "srikanthsri10143s@gmail.com";//change accordingly  
	      String host = "mail.javatpoint.com";//or IP address  
	  
	     //Get the session object  
	      Properties properties = System.getProperties();  
	      properties.setProperty("mail.smtp.host", host);  
	      Session session = Session.getDefaultInstance(properties);  
	  
	     //compose the message  
	      try{  
	         MimeMessage message = new MimeMessage(session);  
	         message.setFrom(new InternetAddress(from));  
	         message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));  
	         message.setSubject("Ping");  
	         message.setText("Hello, this is example of sending email  ");  
	  
	         // Send message  
	         Transport.send(message);  
	         System.out.println("message sent successfully....");  
	  
	      }catch (MessagingException mex) {mex.printStackTrace();}  
	   }  
	}  
	*/
	
import java.util.Properties;    
import javax.mail.*;    
import javax.mail.internet.*;    
class SendEmail{  
	
	
	// srikanthmuniganti7977@gmail.com
	
	static String username,pin;
	public static String sendEmail(String username1,String pin1,Register r)
	{
		 username=username1;
		 pin=pin1;
		 String msg="";
			//from,password,to,subject,message  
		 try {
			
		 System.err.println("message send requesting ");
		 msg=SendEmail.send("mydairydesktop@gmail.com","myDairydesk",username,"myDAiry account verification","Thank you for choosing Us and pin for the validation is "+pin); 
		     //change from, password and to 
		 r.jLabel5.setText("message sent successfully....");
		 }
		 catch(Exception e)
		 {
			 r.jLabel6.setText("Problem in connecting with server, please try after some time! email");
		 }
		 return msg;
	}
    public static String send(String from,String password,String to,String sub,String msg){  
          //Get properties object    
          Properties props = new Properties();    
          props.put("mail.smtp.host", "smtp.gmail.com");    
          props.put("mail.smtp.socketFactory.port", "465");    
          props.put("mail.smtp.socketFactory.class",    
                    "javax.net.ssl.SSLSocketFactory");    
          props.put("mail.smtp.auth", "true");    
          props.put("mail.smtp.port", "465");    
          //get Session   
          Session session = Session.getDefaultInstance(props,    
           new javax.mail.Authenticator() {    
           protected PasswordAuthentication getPasswordAuthentication() {   
        	   System.err.println("password authentication!!!");
           return new PasswordAuthentication(from,password);  
           }    
          }); 
          
          try {    
           MimeMessage message = new MimeMessage(session);    
           message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));    
           message.setSubject(sub);    
           message.setText(msg); 
           System.err.println("message  "+message);
           Transport.send(message); 
           System.err.println("message sent successflly");
           return "sent successfully";
          } catch (MessagingException e) {
        	  System.err.println("error in Sending message "+ e);
        	  return "unsuccessfull";
          }                        
    } 
}   
	
