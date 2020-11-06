package org.epodia.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class UserDto {

	@NotNull
    @NotEmpty
	private String user_last_name ;
	@NotNull
    @NotEmpty
	private String user_first_name ;
	@NotNull
    @NotEmpty
	private String email;
	@NotNull
    @NotEmpty
	private int user_age ;
	@NotNull
    @NotEmpty
	private String password ;
	private String matchingPassword;
	@NotNull
    @NotEmpty
	private Long phone_numbre ;
	@NotNull
    @NotEmpty
	private String address ;
	public String getUser_last_name() {
		return user_last_name;
	}
	public void setUser_name(String user_last_name) {
		this.user_last_name = user_last_name;
	}
	public String getUser_first_name() {
		return user_first_name;
	}
	public void setUser_first_name(String user_first_name) {
		this.user_first_name = user_first_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getUser_age() {
		return user_age;
	}
	public void setUser_age(int user_age) {
		this.user_age = user_age;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMatchingPassword() {
		return matchingPassword;
	}
	public void setMatchingPassword(String matchingPassword) {
		this.matchingPassword = matchingPassword;
	}
	public Long getPhone_numbre() {
		return phone_numbre;
	}
	public void setPhone_numbre(Long phone_numbre) {
		this.phone_numbre = phone_numbre;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
}
