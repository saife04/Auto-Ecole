package com.sid.autoEcole.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name="student")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Student implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="first_name",nullable=false, length=50, unique=false)
	private String firstName;
	@Column(name="last_name", length=50, unique=false)
	private String lastName;
	private String adress;
	@Temporal(TemporalType.DATE)
	@Column(name="birth_date", length=50, unique=false)
	private Date birthDate;
	@Column(length=50,  unique=true)
	private String userName;
	private Integer status;
	private Integer actif;
	private Boolean authorized;
	@Temporal(TemporalType.DATE)
	@Column(name="authorization_date", length=50, unique=false)
	private Date authorizationDate;
	

	
	 @OneToMany(
	            mappedBy = "student",
	            cascade = CascadeType.ALL,
	            orphanRemoval = true
	    )
	    private List<Fault> faults = new ArrayList<>();
	 
	 @OneToMany(
	            mappedBy = "student",
	            cascade = CascadeType.ALL,
	            orphanRemoval = true
	    )
	    private List<ExamResult> results = new ArrayList<>();
	 
	 

}
