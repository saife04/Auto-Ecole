package com.sid.autoEcole.app.web;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/api")
public class SessionRestController {

	private static final Logger LOG = LoggerFactory.getLogger(ExamRestController.class);
	
	@Autowired
	private SessionRepository sessionRepository;
	
	@Autowired
	private ISessionService sessionService;
	

	
	// Rest API to get all session list
	@GetMapping("/session/list")
	public List<Session> sessions() {
		try {
			return sessionRepository.findAll();
		} catch (Exception e) {
			LOG.error(e.getMessage());
			return new ArrayList<>();
		}
	}

	
	// Rest API To create a new session
	@PostMapping("/session/create")
		public Boolean createSession(@RequestBody SessionForm sessionForm) {
		
		return sessionService.createSession(sessionForm);
	
		
	}

	// Rest API To update Student data after each session
	@PostMapping("/session/update-result")
	public Boolean addSessionResult(@RequestBody List<SessionResultForm> sessionResultForm) {
	
	return sessionService.addSessionResult(sessionResultForm);

	
}
	

}

