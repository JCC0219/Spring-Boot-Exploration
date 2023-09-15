package com.luv2code.springboot.demo.mycoolapp;

import com.luv2code.springboot.demo.mycoolapp.dao.StudentDAO;
import com.luv2code.springboot.demo.mycoolapp.dao.StudentDAOImpl;
import com.luv2code.springboot.demo.mycoolapp.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.SQLOutput;


@SpringBootApplication
public class MycoolappApplication {

	public static void main(String[] args) {
		SpringApplication.run(MycoolappApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner ->{
//			createStudent(studentDAO);
//			createMultiperStudents(studentDAO);

			readStudent(studentDAO);


		};
	}

	private void readStudent(StudentDAO studentDAO) {
//		//create a student object
//		System.out.println("Creating new student object");
//		Student tempStudent = new Student("Daffy","Duck","john@test.com");
//
//		//save the student
//		System.out.println("Saving the student");
//		studentDAO.save(tempStudent);

		//display id of the saved student
//		int theId = tempStudent.getId();
		int theId = 7;

		System.out.println("saved student. Generated id: "+ theId);

		//retrieve student based on the id:primary key
		Student myStudent = studentDAO.findById(theId);
		System.out.println("saved student. Generated id: "+ theId);

		//display student
		System.out.println("Found the student: " + myStudent);


	}

	private void createMultiperStudents(StudentDAO studentDAO) {

		//create multiple students
		System.out.println("Creating 3 student objects...");
		Student tempStudent1 = new Student("John","Doe","john@test.com");
		Student tempStudent2 = new Student("Mary","Public","mary@test.com");
		Student tempStudent3 = new Student("Bonita","Applebum","bonita@test.com");

		//save the student objects
		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);




	}

	private void createStudent(StudentDAO studentDAO) {
		//create the student object
		System.out.println("Creating new student object .....");
		Student tempStudent = new Student("Paul","Doe","paul@test.com");

		//save the student object
		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent);

		//display the id of the saved student
		System.out.println("Saved student. Generated id:" + tempStudent.getId());
	}
}
