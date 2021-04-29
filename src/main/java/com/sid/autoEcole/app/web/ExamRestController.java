package com.sid.autoEcole.app.web;

import com.sid.autoEcole.app.entities.Student;
import com.sid.autoEcole.app.models.forms.ExamResultForm;
import com.sid.autoEcole.app.models.forms.SessionResultForm;
import com.sid.autoEcole.app.service.IExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ExamRestController {

	private final IExamService examService;

	@Autowired
	public ExamRestController( IExamService examService) {
		this.examService = examService;
	}



	// Rest API To update Student data after an exam
	@PostMapping("/add/student-exam")
	public Boolean addStudentToPassExam(@RequestBody List<SessionResultForm> sessionResultForm) {

		return true;
	}


	// Rest API to get all authorized student to pass exam
	@GetMapping("/exam/authorized-list/all")
	public List<Student> findAllAuthorizedStudent() {
		return examService.findAllAuthorizedStudent();
	}

	// Rest API To create a new session
	@GetMapping("/exam/authorized-list")
		public Page<Student> findAuthorizedStudentToPassExam() {
		return examService.findAuthorizedStudentToPassExam();
	}

	// Rest API To update Student data after an exam
	@PostMapping("/exam/update-result")
	public Boolean addExamResult(@RequestBody List<ExamResultForm> examResultForm) {
	
	   return examService.updateStudentInformationAfterExam(examResultForm);

    }
	

}

