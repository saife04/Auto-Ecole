package com.sid.autoEcole.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sid.autoEcole.dao.SeriesRepository;
import com.sid.autoEcole.dao.SessionRepository;
import com.sid.autoEcole.entities.Series;
import com.sid.autoEcole.entities.Session;
import com.sid.autoEcole.entities.Student;
import com.sid.autoEcole.models.forms.SessionForm;
import com.sid.autoEcole.models.forms.SessionResultForm;
import com.sid.autoEcole.service.ISessionService;
import com.sid.autoEcole.service.IStudentService;

import lombok.Data;

@RestController("/session")
public class SessionRestController {
	
	@Autowired
	private SessionRepository sessionRepository;
	
	@Autowired
	private ISessionService sessionService;
	
	@Autowired
	private SeriesRepository serieRepository;
	
	// Rest API to get all session list
	@GetMapping("/list")
	public List<Session> sessions(){
		return sessionRepository.findAll();
	}
	
	@GetMapping("/list-series")
	public List<Series> series(){
		return serieRepository.findAll();
	}
	
	// Rest API To create a new session
	@PostMapping("/create")
		public Boolean createSession(@RequestBody SessionForm sessionForm) {
		
		return sessionService.createSession(sessionForm);
	
		
	}
	
	
	// Rest API To update Student data after each session
	@PostMapping("/update-result")
	public Boolean addSessionResult(@RequestBody List<SessionResultForm> sessionResultForm) {
	
	return sessionService.addSessionResult(sessionResultForm);

	
}
	

}


//@Data
//class SessionForm {
//	private List<Long> students;
//	private String date;
//	private Long cd;
//	
//}
