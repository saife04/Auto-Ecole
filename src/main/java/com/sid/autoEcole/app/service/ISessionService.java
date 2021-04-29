package com.sid.autoEcole.app.service;

import java.util.List;

import com.sid.autoEcole.app.models.forms.SessionForm;
import com.sid.autoEcole.app.models.forms.SessionResultForm;

public interface ISessionService {
	 
       public Boolean createSession(SessionForm sessionForm);
       
       public Boolean addSessionResult(List<SessionResultForm> sessionResultForm);
}
