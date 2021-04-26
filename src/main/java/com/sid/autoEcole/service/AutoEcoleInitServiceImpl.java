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

@Service
public class AutoEcoleInitServiceImpl implements IAutoEcoleInitService {
	
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
				    student.setAdress("adress" + radomInt);
				 
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

}
