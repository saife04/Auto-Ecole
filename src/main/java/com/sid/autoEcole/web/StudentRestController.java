package com.sid.autoEcole.web;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sid.autoEcole.entities.Student;
import com.sid.autoEcole.service.IStudentService;

import lombok.Data;

@RestController
public class StudentRestController {
	
	@Autowired
	private IStudentService studentService ;
	
	@GetMapping("/list-students")
	public List<Student> students(){
		return studentService.getStudentList();
	}
	
	
	// Rest API To add a new students
	@PostMapping("/student/add")
	public Long students(@RequestBody StudentForm studentForm){
		Assert.notNull(studentForm, "STUDENT CANNOT BE NULL");
		Student student = new Student();
		student.setFirstName(studentForm.getFirstName());
		student.setLastName(studentForm.getLastName());
		student.setAdress(studentForm.getAdress());
		try {
		Date date=new SimpleDateFormat("dd/MM/yyyy").parse(studentForm.getBirthDate());
		student.setBirthDate(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return studentService.addStudent(student);
		
	}

}

@Data
 class StudentForm {
	private String firstName;
	private String lastName;
	private String adress;
	private  String  birthDate;
}
