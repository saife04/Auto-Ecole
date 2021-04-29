package com.sid.autoEcole.app.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sid.autoEcole.app.dao.SeriesRepository;
import com.sid.autoEcole.app.dao.SessionRepository;
import com.sid.autoEcole.app.entities.Series;
import com.sid.autoEcole.app.entities.Session;
import com.sid.autoEcole.app.entities.Student;
import com.sid.autoEcole.app.models.forms.SessionForm;
import com.sid.autoEcole.app.models.forms.SessionResultForm;
import com.sid.autoEcole.app.service.ISessionService;
import com.sid.autoEcole.app.service.IStudentService;

@RestController
public class SessionRestController {
	
	@Autowired
	private SessionRepository sessionRepository;
	
	@Autowired
	private ISessionService sessionService;
	

	
	// Rest API to get all session list
	@GetMapping("/list")
	public List<Session> sessions(){
		return sessionRepository.findAll();
	}

	
	// Rest API To create a new session
	@PostMapping("/session/create")
		public Boolean createSession(@RequestBody SessionForm sessionForm) {
		
		return sessionService.createSession(sessionForm);
	
		
	}

	// Rest API To update Student data after each session
	@PostMapping("/update-result")
	public Boolean addSessionResult(@RequestBody List<SessionResultForm> sessionResultForm) {
	
	return sessionService.addSessionResult(sessionResultForm);

	
}
	

}

