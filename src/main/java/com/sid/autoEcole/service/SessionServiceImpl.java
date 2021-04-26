package com.sid.autoEcole.service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.sid.autoEcole.dao.CdRomRepository;
import com.sid.autoEcole.dao.FaultRepository;
import com.sid.autoEcole.dao.OrderRepository;
import com.sid.autoEcole.dao.QuestionRepository;
import com.sid.autoEcole.dao.SeriesRepository;
import com.sid.autoEcole.dao.SessionRepository;
import com.sid.autoEcole.dao.StudentRepository;
import com.sid.autoEcole.entities.CdRom;
import com.sid.autoEcole.entities.Fault;
import com.sid.autoEcole.entities.Order;
import com.sid.autoEcole.entities.Question;
import com.sid.autoEcole.entities.Series;
import com.sid.autoEcole.entities.Session;
import com.sid.autoEcole.entities.Student;
import com.sid.autoEcole.models.forms.SessionForm;
import com.sid.autoEcole.models.forms.SessionResultForm;

import lombok.Data;

@Service
public class SessionServiceImpl implements ISessionService {
	
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
	
	@Autowired
	private FaultRepository faultRepository;



	@Override
	public Boolean createSession(SessionForm sessionForm) {
		
		Session session = new Session();
		
		CdRom cdRom = cdRomRepository.findById(sessionForm.getCd()).get();
		Assert.notNull(cdRom, "CDROM CANNOT BE NULL");
		session.setCdRom(cdRom);
		
		try {
			Timestamp timestamp = Timestamp.valueOf(sessionForm.getDate());
			session.setDate(timestamp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		Session session1 = sessionRepository.save(session);
		
		sessionForm.getStudents().forEach(s -> {
			Fault fault = new Fault();
			fault.setSession(session1);
			Student student = studentRepository.findById(s).get();
			Assert.notNull(student, "STUDENT CANNOT BE NULL");
			fault.setStudent(student);
			fault.setFaultNumber(0);
		});
		
		
		return true;
	}



	@Override
	public Boolean addSessionResult(List<SessionResultForm> sessionResultsForm) {
		
		for (SessionResultForm sessionResultForm : sessionResultsForm) {
			
			Student student = studentRepository.findById(sessionResultForm.getStudentId()).get();
			Assert.notNull(student, "STUDENT CANNOT BE NULL");
			Session session = sessionRepository.findById(sessionResultForm.getSessionId()).get();
			Assert.notNull(session, "SESSION CANNOT BE NULL");
			Fault fault = faultRepository.findBySessionAndStudent(session, student);
			faultRepository.save(fault);
			
			if (sessionResultForm.getFaultScore() < 5) {
				Integer score = student.getStatus() ;
				score += 1;
				if (score == 5) {
					student.setAuthorized(true);
				}
				student.setStatus(score);
				studentRepository.save(student);
			} else {
				student.setStatus(0);
				studentRepository.save(student);
			}
			
			
		}
		
		return true;
	}



}






