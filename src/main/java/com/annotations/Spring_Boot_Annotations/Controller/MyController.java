package com.annotations.Spring_Boot_Annotations.Controller;

import com.annotations.Spring_Boot_Annotations.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//We can use Restcontroller which works both for conroller and responsebody singly
@RestController
public class MyController {

    @Autowired
    @Qualifier("student1")
    private Student student;

    @GetMapping("home")
    //requestBody takes the data in json and then with the help of setter stores data in object of student
    public String home(Student st){
        GmailSender gmailSender = new GmailSender();
        String to = "shivamverma.op@gmail.com";
        String from = "shivamverma.op@gmail.com";
        String subject = student.getName();
        String text = student.getName();
        boolean b = gmailSender.sendEmail(to,from,subject,text);
        if(b){
            System.out.println("Email is sent successfully");
        }else{
            System.out.println("There is problem in sending g mail");
        }
        return this.student.getName();
    }

//    @RequestMapping(value ="/user/{userId}",method = RequestMethod.GET)
//    public String user(@PathVariable("userId") Integer userId){
//        return String.valueOf(userId);
//    }
}
