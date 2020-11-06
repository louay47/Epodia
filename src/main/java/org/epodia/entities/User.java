package org.epodia.entities;

import java.io.Serializable;
import java.util.Collection;


import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.epodia.enumeration.User_type;
import org.hibernate.annotations.Proxy;

import com.fasterxml.jackson.annotation.JsonIgnore;

import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;



@JsonTypeInfo(use = JsonTypeInfo.Id.NAME , include = JsonTypeInfo.As.PROPERTY , property = "userType")
@JsonSubTypes({
	@Type(name="EXPERT" , value = Expert.class),
	@Type(name="DEVICE_USER" , value = Device_user.class)
})


@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="DC",discriminatorType=DiscriminatorType.STRING,length=20)
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Proxy(lazy=false)
public abstract class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Long id ;
	
	@NotEmpty(message = "Please provide your last name")
		private String user_last_name ; 
		
	@NotNull
	@Column(name = "USERNAME" , nullable = false , unique = true)
		private String username ;
	
	@NotEmpty(message = "Please provide your first name")
		private String user_first_name ;
	
	@Column(name = "email", nullable = false, unique = true)
	@javax.validation.constraints.Email(message = "Please provide a valid e-mail")
	@NotEmpty(message = "Please provide an e-mail")
		private String email ;
	
	//@NotEmpty(message = "Please provide your age")
		private int user_age ;
	
	
		private String password ;
		private String gendre ;
		
	
		private Long phone_numbre ; 
	
		private String address ;
	@Enumerated(EnumType.STRING)
	@JoinColumn(name = "TYPE", nullable = false)
		private User_type type;
	
	@Column(name = "enabled")
		private boolean enabled;
	
	@Column(name = "confirmation_token")
		private String confirmationToken;
	
		private boolean isPresent ;
		
	@OneToMany(mappedBy="user",fetch=FetchType.LAZY)
		private Collection<Conversation> conversations ;
	@OneToMany(mappedBy="user",fetch=FetchType.LAZY)
		private Collection<Message> message ;
	
	@OneToMany(mappedBy="expert" ,fetch=FetchType.LAZY)
	private Collection<Relation> experts ;
	
	@OneToMany(mappedBy="patient",fetch=FetchType.LAZY)
	private Collection<Relation> patients ;

	
	
	
	/*
	 * 
	 * OLD RELATION BETWEEN USER & AFFECTED_EXERCICE
	 * 
	 */
	/*@OneToMany(mappedBy="users",fetch=FetchType.LAZY)
		private Collection<Affected_exercice> affected_exercice ;*/
	
	
	/*
	 * 
	 * OLD RELATION BETWEEN USER & USER
	 * 
	 */
	/*@ManyToMany
	@JoinTable(name="EXPERT_PATIENT",
	joinColumns={@JoinColumn(name="EXPERT_ID")},
	inverseJoinColumns={@JoinColumn(name="PATIENT_ID")})
		private Collection<User> user;*/


	public User() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	

	public User( @NotEmpty(message = "Please provide your last name") String user_last_name,
			@NotNull String username, @NotEmpty(message = "Please provide your first name") String user_first_name,
			@Email(message = "Please provide a valid e-mail") @NotEmpty(message = "Please provide an e-mail") String email,
			int user_age, String password, String gendre, Long phone_numbre, String address, User_type type,
			boolean enabled, String confirmationToken, boolean isPresent, Collection<Conversation> conversations,
			Collection<Message> message, Collection<Relation> experts, Collection<Relation> patients) {
		super();
		
		this.user_last_name = user_last_name;
		this.username = username;
		this.user_first_name = user_first_name;
		this.email = email;
		this.user_age = user_age;
		this.password = password;
		this.gendre = gendre;
		this.phone_numbre = phone_numbre;
		this.address = address;
		this.type = type;
		this.enabled = enabled;
		this.confirmationToken = confirmationToken;
		this.isPresent = isPresent;
		this.conversations = conversations;
		this.message = message;
		this.experts = experts;
		this.patients = patients;
	}



	public Long getId() {
		return id;
	}





	public void setId(Long id) {
		this.id = id;
	}





	public String getUser_last_name() {
		return user_last_name;
	}





	public void setUser_last_name(String user_last_name) {
		this.user_last_name = user_last_name;
	}





	public String getUsername() {
		return username;
	}





	public void setUsername(String username) {
		this.username = username;
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





	public String getGendre() {
		return gendre;
	}





	public void setGendre(String gendre) {
		this.gendre = gendre;
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





	public User_type getType() {
		return type;
	}





	public void setType(User_type type) {
		this.type = type;
	}





	public boolean isEnabled() {
		return enabled;
	}





	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}





	public String getConfirmationToken() {
		return confirmationToken;
	}





	public void setConfirmationToken(String confirmationToken) {
		this.confirmationToken = confirmationToken;
	}





	public boolean isPresent() {
		return isPresent;
	}





	public void setPresent(boolean isPresent) {
		this.isPresent = isPresent;
	}





	@JsonIgnore
	public Collection<Conversation> getConversations() {
		return conversations;
	}



	


	@JsonSetter
	public void setConversations(Collection<Conversation> conversations) {
		this.conversations = conversations;
	}



	@JsonIgnore
	public Collection<Message> getMessage() {
		return message;
	}



	@JsonSetter
	public void setMessage(Collection<Message> message) {
		this.message = message;
	}



	@JsonIgnore
	public Collection<Relation> getExperts() {
		return experts;
	}

	@JsonSetter
	public void setExperts(Collection<Relation> experts) {
		this.experts = experts;
	}


	@JsonIgnore
	public Collection<Relation> getPatients() {
		return patients;
	}


	@JsonSetter
	public void setPatients(Collection<Relation> patients) {
		this.patients = patients;
	}
	
	
	
	
	
	
	
	
	
}
