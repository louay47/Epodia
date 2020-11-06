package org.epodia.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;


public class LoginCredentials implements Serializable
{
	
	private static final long serialVersionUID = 1L;
	
	@NotEmpty
	private String username;
	private String password;
	public LoginCredentials() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LoginCredentials(@NotEmpty String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	/**
	 * Default Constructor
	 */
	
	
}