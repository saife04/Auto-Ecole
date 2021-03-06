package com.sid.autoEcole.app.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.*;

@EqualsAndHashCode(callSuper = false)
@Getter  @Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity(name="session")


public class Session extends  Base implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	

	 @OneToMany(
	            mappedBy = "session",
	            cascade = CascadeType.ALL,
	            orphanRemoval = true
	    )
	    private List<Fault> faults = new ArrayList<>();
	 
	 @OneToOne
	 @JoinColumn(name = "cdrom_id", referencedColumnName = "cdrom_id")
	 @JsonProperty(access = Access.READ_ONLY)
	 private  CdRom cdRom;
	

}
