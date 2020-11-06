package org.epodia.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.epodia.enumeration.Relative_type;
import org.hibernate.annotations.Proxy;

@Entity
@Proxy(lazy=false)
public class Pathological_genealogy implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
		private long id ;
		private String disease_name ;
	@Enumerated(EnumType.STRING)
	@JoinColumn(name = "RELATE_TYPE" , nullable = false)
		private Relative_type relative_type;
	@ManyToOne
	@JoinColumn(name="CODE_DUSER")
		private Device_user device_user;
	public Pathological_genealogy() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Pathological_genealogy(String disease_name, Relative_type relative_type, Device_user device_user) {
		super();
		this.disease_name = disease_name;
		this.relative_type = relative_type;
		this.device_user = device_user;
	}
	public long getId_path() {
		return id;
	}
	public void setId_path(long id) {
		this.id = id;
	}
	public String getDisease_name() {
		return disease_name;
	}
	public void setDisease_name(String disease_name) {
		this.disease_name = disease_name;
	}
	public Relative_type getRelative_type() {
		return relative_type;
	}
	public void setRelative_type(Relative_type relative_type) {
		this.relative_type = relative_type;
	}
	public Device_user getDevice_user() {
		return device_user;
	}
	public void setDevice_user(Device_user device_user) {
		this.device_user = device_user;
	}
	
	

}
