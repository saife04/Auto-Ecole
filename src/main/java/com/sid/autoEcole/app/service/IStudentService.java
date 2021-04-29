package com.sid.autoEcole.app.service;

import java.util.List;

import com.sid.autoEcole.app.entities.Student;

public interface IStudentService {
	
       List<Student> getStudentList();
       
       Long addStudent(Student student);

       List<Student> getFailedStudent();
}
