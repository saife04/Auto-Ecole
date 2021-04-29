package com.sid.autoEcole.app.web;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.sid.autoEcole.app.models.forms.StudentForm;
import com.sid.autoEcole.app.service.IFaultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import com.sid.autoEcole.app.entities.Student;
import com.sid.autoEcole.app.service.IStudentService;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	

	private final IStudentService studentService ;

	private final IFaultService faultService;

	@Autowired
	public StudentRestController(IStudentService studentService, IFaultService faultService) {
		this.studentService = studentService;
		this.faultService = faultService;
	}

	@GetMapping("/student/list")
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
		student.setAddress(studentForm.getAdress());
		try {
		Date date=new SimpleDateFormat("dd/MM/yyyy").parse(studentForm.getBirthDate());
		student.setBirthDate(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return studentService.addStudent(student);
		
	}

	// REST API to get average fault score for a cd and series
	@GetMapping("/average-fault/{cdRomId}/{serieId}")
	public Double getAverageFault(@PathVariable Long cdRomId,@PathVariable Long serieId ){

		return faultService.getAverageFault(cdRomId, serieId);
	}


    // REST API to get list students have failed the exam at least once
	@GetMapping("/student/failed-exam")
	public List<Student> getFailedStudent(){

		return studentService.getFailedStudent();
	}

}


