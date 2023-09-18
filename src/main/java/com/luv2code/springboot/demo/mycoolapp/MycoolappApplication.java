package com.luv2code.springboot.demo.mycoolapp;

import com.luv2code.springboot.demo.mycoolapp.dao.StudentDAO;
import com.luv2code.springboot.demo.mycoolapp.dao.StudentDAOImpl;
import com.luv2code.springboot.demo.mycoolapp.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.SQLOutput;
import java.util.List;


@SpringBootApplication
public class MycoolappApplication {

	public static void main(String[] args) {
		SpringApplication.run(MycoolappApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner ->{
//			createStudent(studentDAO);
			createMultiperStudents(studentDAO);

//			readStudent(studentDAO);

//			queryForStudents(studentDAO);

//			queryForStudentsByLastName(studentDAO);

//			updateStudent(studentDAO);

//			deleteStudent(studentDAO);

//			deleteAllStudents(studentDAO);

		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("DELETING all students");
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("DELETED row count " + numRowsDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {

		int studentId = 4;
		System.out.println("Deleting student id: " + studentId);
		studentDAO.delete(studentId);

	}

	private void updateStudent(StudentDAO studentDAO) {
		//retrieve student based on the id: primary key
		int studentId= 1;
		System.out.println("Getting student with id: " + studentId);
		Student myStudent = studentDAO.findById(studentId);

		//change the first name to "Scooby"
		System.out.println("Updating student ...");
		myStudent.setFirstName(("Scooby"));

		//update the student
		studentDAO.update(myStudent);

		//display the updated student
		System.out.println("Updated Student" + myStudent);
	}


	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		//get a list of students
		List<Student> theStudents = studentDAO.findByLastName("Duck");

		//display list of students
		for(Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		//get a list of students
		List<Student> theStudents = studentDAO.findAll();

		//display list of students
		for(Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}

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
