package com.sid.autoEcole.app.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.*;


@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@ToString
@Entity(name = "_order")
public class Order extends  Base implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="_order")
	private Integer order;
	
	 @ManyToOne
	 @JsonProperty(access = Access.WRITE_ONLY)
	    private Series series;
	 
	 @ManyToOne
	 @JsonProperty(access = Access.WRITE_ONLY)
	    private Question question;

}
