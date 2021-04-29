package com.sid.autoEcole.app.service.Impl;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import com.sid.autoEcole.app.dao.*;
import com.sid.autoEcole.app.entities.*;
import com.sid.autoEcole.app.models.enums.StudentStatus;
import com.sid.autoEcole.app.service.IAutoEcoleInitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class AutoEcoleInitServiceImpl implements IAutoEcoleInitService {
	

	private final CdRomRepository cdRomRepository;
	

	private final SessionRepository sessionRepository;
	

	private final StudentRepository studentRepository;
	

	private final QuestionRepository questionRepository;
	

	private final SeriesRepository serieRepository;
	

	private final OrderRepository orderRepository;


	private final FaultRepository faultRepository;

	@Autowired
	public AutoEcoleInitServiceImpl(CdRomRepository cdRomRepository, SessionRepository sessionRepository, StudentRepository studentRepository, QuestionRepository questionRepository, SeriesRepository serieRepository, OrderRepository orderRepository, FaultRepository faultRepository) {
		this.cdRomRepository = cdRomRepository;
		this.sessionRepository = sessionRepository;
		this.studentRepository = studentRepository;
		this.questionRepository = questionRepository;
		this.serieRepository = serieRepository;
		this.orderRepository = orderRepository;
		this.faultRepository = faultRepository;
	}

	@Override
	public void initStudent() {
		Stream.of("Toto1", "Toto2", "Toto3","Toto4","Toto5","Toto6",
				"Toto7","Toto8","Toto9","Toto10","Toto11").forEach(s -> {
					Student student = new Student();
					student.setFirstName(s);
					GregorianCalendar gc = new GregorianCalendar();
					int year = 1990 + (int)Math.round(Math.random() * (2002 - 1990));
				    gc.set(Calendar.YEAR, year);
				    int dayOfYear = 1 + (int)Math.round(Math.random() * (gc.getActualMaximum(Calendar.DAY_OF_YEAR) - 1));
				    gc.set(Calendar.DAY_OF_YEAR, dayOfYear);
				    student.setBirthDate(gc.getTime());
				    int radomInt = 3+(int)(Math.random()*7);
				    student.setAddress("adress" + radomInt);
				    student.setStatus(StudentStatus.ACTIVE);
				    student.setTotalScore(0);
				    student.setAuthorized(false);
				 
					studentRepository.save(student);
		
				});
		
		
	}

	@Override
	public void initSession() {
		for (int i = 0 ; i <= 10 ; i++) {
			Session session = new Session();
			
			long offset = Timestamp.valueOf("2020-01-01 00:00:00").getTime();
			long end = Timestamp.valueOf("2021-01-01 18:00:00").getTime();
			long diff = end - offset + 1;
			Timestamp rand = new Timestamp(offset + (long)(Math.random() * diff));
			session.setDate(rand);
			Page<CdRom> cdRomPage = cdRomRepository.getRandomCdRom(PageRequest.of(0,1));
			List<CdRom> cdRom = cdRomPage.toList();
			session.setCdRom(cdRom.get(0));
			sessionRepository.save(session);
			
		}
		
	}

	@Override
	public void initCdRom() {
		
		for (int i = 0 ; i <= 10 ; i++) {
			CdRom cd = new CdRom();
			
			int radomInt = 3+(int)(Math.random()*7);
			cd.setPublisherName("publisher" + radomInt);
			cd.setNumber( (long) i);
			
			cdRomRepository.save(cd);
			
		}
		
	}

	@Override
	public void initSerie() {
		cdRomRepository.findAll().forEach(cd -> {
			for (int i = 1 ; i<= 6 ; i++) {
				Series serie = new Series();
				serie.setCdRom(cd);
				serie.setNumber(i);
				serieRepository.save(serie);
			}
		});
		
	}

	@Override
	public void initQuestion() {
		
		String [] themes = {"Theme1", "Theme2", "Theme3","Theme4","Theme5","Theme6",
				"Theme7"};
		for (int i = 1 ; i <= 120 ; i++) {
			Question question = new Question();
			
			question.setContent("question" + i);
			question.setAnswer("reponse" + i);
			int rnd = new Random().nextInt(themes.length);
			question.setTheme(themes[rnd]);
			int radomInt = 1+(int)(Math.random()*3);
			question.setLevel(radomInt);
			
			questionRepository.save(question);
			
		}
		
	}

	@Override
	public void initOrder() {
		
		serieRepository.findAll().forEach(s -> {
			
			Page<Question> questionList = questionRepository.getRandomQuestion(PageRequest.of(0,40));
			List<Question> questions = questionList.toList();
			
			for (int i= 0; i< questions.size() ; i ++) {
				Order order = new Order();
				order.setQuestion(questions.get(i));
				order.setSeries(s);
				order.setOrder(i);
				
				orderRepository.save(order);
			}
			
		});
	}


	@Override
	public void initFaults() {

		sessionRepository.findAll().forEach( s -> {

			List<Student> studentList = studentRepository.findAll();

		    for (Student student : studentList) {
		    	Fault fault = new Fault();
		    	fault.setSession(s);
		    	fault.setStudent(student);
				int radomInt = 3+(int)(Math.random()*7);
				fault.setFaultNumber(radomInt);
				faultRepository.save(fault).getId();

				Integer score = student.getTotalScore();
				if (radomInt <= 5 ) {
					score+=1;
					student.setTotalScore(score);
					if (score >= 4) {
						student.setAuthorized(true);
						student.setAuthorizationDate(LocalDateTime.now());
					}
				} else {
					student.setTotalScore(0);
				}
				studentRepository.save(student);
			}

		});
	}

}
