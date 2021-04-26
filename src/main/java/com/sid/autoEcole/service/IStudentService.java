package com.sid.autoEcole.service;

import java.util.List;

import com.sid.autoEcole.entities.Student;

public interface IStudentService {
	
       public List<Student> getStudentList();
       
       public Long addStudent(Student student);
}
