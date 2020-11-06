package org.epodia.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.epodia.enumeration.Anomality_type;
import org.hibernate.annotations.Proxy;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

@Entity
@Proxy(lazy=false)
public class Anomality implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
		private long id ;
	@Enumerated(EnumType.STRING)
	@JoinColumn(name = "ANOM_TYPE" , nullable = false)
		private Anomality_type anomality_type ;
		private String symptome ;
		private Date start_date ;
	@ManyToOne
	@JoinColumn(name="CODE_PATIENT")
		private Device_user device_user ;
	public Anomality() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Anomality(long id, Anomality_type anomality_type, String symptome, Date start_date) {
		super();
		this.id = id;
		this.anomality_type = anomality_type;
		this.symptome = symptome;
		this.start_date = start_date;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Anomality_type getAnomality_type() {
		return anomality_type;
	}
	public void setAnomality_type(Anomality_type anomality_type) {
		this.anomality_type = anomality_type;
	}
	public String getSymptome() {
		return symptome;
	}
	public void setSymptome(String symptome) {
		this.symptome = symptome;
	}
	public Date getStart_date() {
		return start_date;
	}
	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}
	@JsonIgnore
	public Device_user getDevice_user() {
		return device_user;
	}
	@JsonSetter
	public void setDevice_user(Device_user device_user) {
		this.device_user = device_user;
	}
	
	
	

}
