package com.sid.autoEcole.app.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name="result")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ExamResult extends  Base implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	
	 
	 @ManyToOne(fetch = FetchType.EAGER)
	    private Student student;
	 
	 @ManyToOne(fetch = FetchType.EAGER)
	    private Exam exam;
	 
	 
	

}
