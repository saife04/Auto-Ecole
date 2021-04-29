package com.sid.autoEcole.app.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.*;

@Entity(name="series")
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@ToString
public class Series extends  Base implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Integer number;
	


	
	 @ManyToOne
	 @JoinColumn(name = "cdrom_id", referencedColumnName = "cdrom_id")
	 @JsonProperty(access = Access.WRITE_ONLY)
	 private CdRom cdRom;
	 

	 @OneToMany(mappedBy = "series"  )
	    private List<Order> orders = new ArrayList<>();

}
