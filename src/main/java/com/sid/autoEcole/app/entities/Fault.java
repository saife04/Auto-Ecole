package com.sid.autoEcole.app.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.*;

@Entity(name="fault")
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@ToString
public class Fault extends  Base implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    private Integer faultNumber;
	
	
	 
	 @ManyToOne(fetch = FetchType.EAGER)
	    private Student student;
	 
	 @ManyToOne(fetch = FetchType.EAGER)
	    private Session session;
}
