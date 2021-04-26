package com.sid.autoEcole.service;

import java.util.List;

import com.sid.autoEcole.models.forms.SessionForm;
import com.sid.autoEcole.models.forms.SessionResultForm;

public interface ISessionService {
	 
       public Boolean createSession(SessionForm sessionForm);
       
       public Boolean addSessionResult(List<SessionResultForm> sessionResultForm);
}
