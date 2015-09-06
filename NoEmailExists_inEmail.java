package Utilities;


import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.mail.BodyPart;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.search.SubjectTerm;

import org.testng.annotations.Test;

public class NoEmailExists_inEmail {
	
	
	public  static void An_email_alert_should_be_sent(String email, String Passwd, String Username, String Pswd, String Createdby, String emailLabel, String enrollssp  ) {

	try
		{
			Properties props = System.getProperties();
			props.setProperty("mail.store.protocol", "imaps");

			Session session = Session.getDefaultInstance(props, null);
			Store store = session.getStore();
			store.connect("imap.gmail.com", email, Passwd);

			Folder folder = store.getFolder("INBOX");
			folder.open(Folder.READ_WRITE);

			System.out.println("Total Message:" + folder.getMessageCount());
			System.out.println("Unread Message:"+ folder.getUnreadMessageCount());

			Message[] messages = null;
	
			
            //Searches email by subject line
            for (int i = 0; i< 1; i++) {
                messages = folder.search(new SubjectTerm("A Silverback user account has been created for you.") , folder.getMessages());
                 //Wait for 10 seconds
                if (messages.length == 0) {
                    Thread.sleep(10000);
                }
            }

          
		for (Message mail : messages) {
			
			Date sentDate = mail.getSentDate();
			Date currentDate = new Date();
			
			
			if ((!mail.getSubject().equalsIgnoreCase("A Silverback user account has been created for you."))
					&& ((sentDate.getDate() == currentDate.getDate()) && (sentDate.getMonth() == currentDate.getMonth())
							&& (sentDate.getYear() == currentDate.getYear()))){
				
				System.out.println(" Mail from search : ---" + "Subject : " +  mail.getSubject() + "mail " + mail.getSentDate() + "content" + readMailContent(mail, Username, Pswd, Createdby, emailLabel, enrollssp));
				break;
				
		}
	


			
		}}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	
	}
	
	public static boolean readMailContent(Message msg, String searchUser, String searchPass, String createdBy, String email_label,  String enroll_ssp) {
		boolean found = false;
		Object msgContent = null;
		try {
			msgContent = msg.getContent();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (MessagingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	    String content = "";             

	     /* Check if content is pure text/html or in parts */                     
	     if (msgContent instanceof Multipart) {
	    	 try{
	         Multipart multipart = (Multipart) msgContent;


	         for (int j = 0; j < multipart.getCount(); j++) {

	          BodyPart bodyPart = multipart.getBodyPart(j);

	          String disposition = bodyPart.getDisposition();

	          if (disposition != null && (disposition.equalsIgnoreCase("ATTACHMENT"))) { 
	              System.out.println("Mail have some attachment");

	              DataHandler handler = bodyPart.getDataHandler();
	              System.out.println("file name : " + handler.getName());                                 
	            }
	          else { 
	        	  content = bodyPart.getContent().toString();  // the changed code      
	        	  if (content.contains(searchPass) && content.contains(searchUser)&& content.contains(createdBy)&& content.contains(email_label)&& content.contains(enroll_ssp)) 
	        		  found = true;
	        	  break;
	            }
	        }
	    	 }catch(Exception e)
	    	 {
	    		 
	    	 }
	     } else
			try {
				content= msg.getContent().toString();
	        	  if (content.contains(searchPass) && content.contains(searchUser)&& content.contains(createdBy))
	        		  found = true;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return found;

	}

}
