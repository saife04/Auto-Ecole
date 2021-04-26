package com.sid.autoEcole.service;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.sid.autoEcole.dao.CdRomRepository;
import com.sid.autoEcole.dao.OrderRepository;
import com.sid.autoEcole.dao.QuestionRepository;
import com.sid.autoEcole.dao.SeriesRepository;
import com.sid.autoEcole.dao.SessionRepository;
import com.sid.autoEcole.dao.StudentRepository;
import com.sid.autoEcole.entities.CdRom;
import com.sid.autoEcole.entities.Order;
import com.sid.autoEcole.entities.Question;
import com.sid.autoEcole.entities.Series;
import com.sid.autoEcole.entities.Session;
import com.sid.autoEcole.entities.Student;
import com.sid.autoEcole.models.enums.StudentStatus;

import lombok.Data;

@Service
public class StudentServiceImpl implements IStudentService {
	
	@Autowired
	private CdRomRepository cdRomRepository;
	
	@Autowired
	private SessionRepository sessionRepository;
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private QuestionRepository questionRepository;
	
	@Autowired
	private SeriesRepository serieRepository;
	
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public List<Student> getStudentList() {
		return studentRepository.findAll();
		
	}

	@Override
	public Long addStudent(Student student) {
		student.setAuthorized(false);
		student.setActif(StudentStatus.ACTIF.getValue());
		 Student studentCreated	 = studentRepository.save(student);
		 return studentCreated.getId();
	}



}






