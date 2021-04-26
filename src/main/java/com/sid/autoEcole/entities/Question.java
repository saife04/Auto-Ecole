package com.sid.autoEcole.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name="question")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Question implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String content;
	private String answer;
	private String theme;
	private Integer level;
	
	 @OneToMany(
	            mappedBy = "question",
	            cascade = CascadeType.ALL,
	            orphanRemoval = true
	    )
	    private List<Order> orders = new ArrayList<>();

}
