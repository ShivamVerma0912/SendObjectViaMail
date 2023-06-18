package com.annotations.Spring_Boot_Annotations;

import MyPackage.Dog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.Date;

@SpringBootApplication
public class SpringBootAnnotationsApplication implements CommandLineRunner {

	@Autowired
	private Date date;

	@Autowired
	@Qualifier("student2")
	private Student student;

	@Autowired
	private Emp emp;

	@Autowired
	private Dog dog;

	public static void main(String[] args) {

		SpringApplication.run(SpringBootAnnotationsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		this.student.studying();
		this.emp.whatsYourName();
		this.dog.eating();
	}

}
