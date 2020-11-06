package org.epodia.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Proxy;

@Entity
@Proxy(lazy=false)
public class Relation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Long id ; 
		private Date date_relation ;
		
	@ManyToOne
	@JoinColumn(name = "expert_id")
		private User expert;
		 
	@ManyToOne
	@JoinColumn(name = "patient_id")
		private User patient;

	public Relation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Relation(Date date_relation, User expert, User patient) {
		super();
		
		this.date_relation = date_relation;
		this.expert = expert;
		this.patient = patient;
	}

	public Long getId_relation() {
		return id;
	}

	public void setId_relation(Long id) {
		this.id = id;
	}

	public Date getDate_relation() {
		return date_relation;
	}

	public void setDate_relation(Date date_relation) {
		this.date_relation = date_relation;
	}

	public User getExpert() {
		return expert;
	}

	public void setExpert(User expert) {
		this.expert = expert;
	}

	public User getPatient() {
		return patient;
	}

	public void setPatient(User patient) {
		this.patient = patient;
	}
		 
		
	
	

}
