package com.sid.autoEcole.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sid.autoEcole.models.enums.StudentStatus;
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
	private String address;
	@Temporal(TemporalType.DATE)
	@Column(name="birth_date", length=50, unique=false)
	private Date birthDate;
	@Column(length=50,  unique=true)
	private String userName;
	@Enumerated(EnumType.STRING)
	private  StudentStatus status;
	private Integer totalScore;
	private Boolean authorized;
	@Column(name="authorization_date", length=50, unique=false)
	private LocalDateTime authorizationDate;
	

     @JsonIgnore
	 @OneToMany(
	            mappedBy = "student",
	            cascade = CascadeType.ALL,
	            orphanRemoval = true
	    )
	    private List<Fault> faults = new ArrayList<>();

	 @JsonIgnore
	 @OneToMany(
	            mappedBy = "student",
	            cascade = CascadeType.ALL,
	            orphanRemoval = true
	    )
	    private List<ExamResult> results = new ArrayList<>();
	 
	 

}
