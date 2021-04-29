package com.sid.autoEcole.app.service.Impl;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import com.sid.autoEcole.app.service.ISessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.sid.autoEcole.app.dao.CdRomRepository;
import com.sid.autoEcole.app.dao.FaultRepository;
import com.sid.autoEcole.app.dao.OrderRepository;
import com.sid.autoEcole.app.dao.QuestionRepository;
import com.sid.autoEcole.app.dao.SeriesRepository;
import com.sid.autoEcole.app.dao.SessionRepository;
import com.sid.autoEcole.app.dao.StudentRepository;
import com.sid.autoEcole.app.entities.CdRom;
import com.sid.autoEcole.app.entities.Fault;
import com.sid.autoEcole.app.entities.Order;
import com.sid.autoEcole.app.entities.Question;
import com.sid.autoEcole.app.entities.Series;
import com.sid.autoEcole.app.entities.Session;
import com.sid.autoEcole.app.entities.Student;
import com.sid.autoEcole.app.models.forms.SessionForm;
import com.sid.autoEcole.app.models.forms.SessionResultForm;

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
			faultRepository.save(fault);
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
				int score = student.getStatus().getValue() ;
				score += 1;
				if (score >= 4) {
					student.setAuthorized(true);
					student.setAuthorizationDate(LocalDateTime.now());
				}
				student.setTotalScore(score);
			} else {
				student.setTotalScore(0);
			}
			studentRepository.save(student);


		}
		
		return true;
	}



}






