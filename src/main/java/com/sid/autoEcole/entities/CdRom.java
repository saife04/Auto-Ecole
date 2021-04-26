package com.sid.autoEcole.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name="cd_rom")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CdRom implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cdrom_id")
	private Long id;
	@Column(name="publisher_name", length=50, nullable=false, unique=false) // taille de caractere pour le string
	private String publisherName;
	
	private Long number;
	
	
	@OneToMany(mappedBy="cdRom")
    @JsonProperty(access = Access.WRITE_ONLY)
	private Collection<Series> serie;
}
