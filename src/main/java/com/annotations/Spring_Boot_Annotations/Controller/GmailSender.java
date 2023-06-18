package com.annotations.Spring_Boot_Annotations.Controller;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import java.util.Properties;

public class GmailSender {

    public boolean sendEmail(String to, String from,String subject,String text){
        boolean flag = false;

        //logic
        //smtp properties
        Properties props = System.getProperties();
        props.put("mail.smtp.host","smtp.gmail.com");
        props.put("mail.smtp.auth","true");
        props.put("mail.smtp.port","587");
        props.put("mail.smtp.starttls.enable","true");

        String username = "shivamverma.op@gmail.com";
        String password="";         //enter password
        //session
        Session session = Session.getInstance(props, new Authenticator(){
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username,password);
            }
        });

        try{
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipient(Message.RecipientType.TO,new InternetAddress(to));
            message.setSubject(subject);
            message.setText(text);
            Transport.send(message);
            flag = true;

        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }
}
