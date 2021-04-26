package com.sid.autoEcole.models.forms;

import java.util.List;

import lombok.Data;

@Data
public class SessionResultForm {
	private Long studentId;
	private Integer faultScore;
	private Long sessionId;

}
