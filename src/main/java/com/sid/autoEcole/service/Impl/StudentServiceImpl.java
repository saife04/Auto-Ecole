package com.sid.autoEcole.service.Impl;

import java.util.List;

import com.sid.autoEcole.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sid.autoEcole.dao.StudentRepository;
import com.sid.autoEcole.entities.Student;
import com.sid.autoEcole.models.enums.StudentStatus;

@Service
public class StudentServiceImpl implements IStudentService {

	

	private final StudentRepository studentRepository;

	@Autowired
	public StudentServiceImpl(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}


	@Override
	public List<Student> getStudentList() {
		return studentRepository.findAll();
		
	}

	@Override
	public Long addStudent(Student student) {
		student.setAuthorized(false);
		student.setStatus(StudentStatus.ACTIVE);
		Student studentCreated = studentRepository.save(student);
		return studentCreated.getId();
	}

	@Override
	public List<Student> getFailedStudent() {
		return studentRepository.getFailedStudent();
	}


}






