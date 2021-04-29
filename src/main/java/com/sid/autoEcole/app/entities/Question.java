package com.sid.autoEcole.app.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.*;

@Entity(name="question")
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@ToString
public class Question extends  Base implements Serializable {
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
