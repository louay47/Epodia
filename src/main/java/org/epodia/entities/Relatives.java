package org.epodia.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


import org.epodia.enumeration.Relative_type;
import org.hibernate.annotations.Proxy;

@Entity
@Proxy(lazy=false)
public class Relatives implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
		private long id ; 
		private String relative_name ;
		private String relative_first_name ;
		private String email ;
		private long num_relative ;
	@Enumerated(EnumType.STRING)
	@JoinColumn(name = "RELATE_TYPE" , nullable = false)
		private Relative_type relative_type ;
	@ManyToOne
	@JoinColumn(name="CODE_DUSER")
		private Device_user device_user ;
	
	
	public Relatives() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Relatives(String relative_name, String relative_first_name, String email, long num_relative,
			Relative_type relative_type) {
		super();
		this.relative_name = relative_name;
		this.relative_first_name = relative_first_name;
		this.email = email;
		this.num_relative = num_relative;
		this.relative_type = relative_type;
	}
	public long getId_relative() {
		return id;
	}
	public void setId_relative(long id) {
		this.id = id;
	}
	public String getRelative_name() {
		return relative_name;
	}
	public void setRelative_name(String relative_name) {
		this.relative_name = relative_name;
	}
	public String getRelative_first_name() {
		return relative_first_name;
	}
	public void setRelative_first_name(String relative_first_name) {
		this.relative_first_name = relative_first_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getNum_relative() {
		return num_relative;
	}
	public void setNum_relative(long num_relative) {
		this.num_relative = num_relative;
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
