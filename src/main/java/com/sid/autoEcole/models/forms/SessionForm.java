package com.sid.autoEcole.models.forms;

import java.util.List;

import lombok.Data;

@Data
public class SessionForm {
	private List<Long> students;
	private String date;
	private Long cd;

}
