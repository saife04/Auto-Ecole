package com.sid.autoEcole.service;

import java.util.List;

import com.sid.autoEcole.entities.Student;

public interface IStudentService {
	
       List<Student> getStudentList();
       
       Long addStudent(Student student);

       List<Student> getFailedStudent();
}
