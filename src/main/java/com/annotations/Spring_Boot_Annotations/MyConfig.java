package com.annotations.Spring_Boot_Annotations;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import java.util.Date;

@Configuration
@ComponentScan(basePackages = {"MyPackage"})
public class MyConfig {

    @Bean("student1")
    @Lazy
    public Student getStudent(){
        System.out.println("Created student1 object..!");
        return new Student("Student1 is created.");
    }

    @Bean("student2")
    public Student createStudent(){
        System.out.println("Creating second student object..!!");
        return new Student("Student2");
    }

    @Bean
    public Date getDate(){
        System.out.println("Creating new date");
        return new Date();
    }
}
