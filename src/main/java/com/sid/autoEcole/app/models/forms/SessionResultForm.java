package com.sid.autoEcole.app.models.forms;

import lombok.Data;

@Data
public class SessionResultForm {
	private Long studentId;
	private Integer faultScore;
	private Long sessionId;

}
