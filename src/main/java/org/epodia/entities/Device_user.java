package org.epodia.entities;

import java.util.Collection;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.epodia.enumeration.Foot_type;
import org.epodia.enumeration.User_type;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;


@Entity
@DiscriminatorValue("DU")
public class Device_user extends User {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Enumerated(EnumType.STRING)
	@JoinColumn(name = "FOOT_TYPE" , nullable = false)
			private Foot_type foot_type ;
			private int weight ;
			private int height ;
			private int glucose ;
	
	@OneToMany(mappedBy="device_user",fetch=FetchType.LAZY)
			private Collection<Anomality> anomalities;
	
	@OneToMany(mappedBy="device_user",fetch=FetchType.LAZY)
			private Collection<Pathological_genealogy> pathological_genealogy;
	
	@OneToMany(mappedBy="device_user",fetch=FetchType.LAZY)
			private Collection<Relatives> realtives;
	
	@OneToMany(mappedBy="device_user",fetch=FetchType.LAZY)
			private Collection<Stats> stats;
	/*
	 * 
	 * NEW RELATION BETWEEN DEVICE_USER & AFFECTED_EXERCICE
	 * 
	 */
	@OneToMany(mappedBy="dusers",fetch=FetchType.LAZY)
		private Collection<Affected_exercice> affected_exercice;
	
		
		
		
	
	
	
	
	public Device_user() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Device_user(@NotEmpty(message = "Please provide your last name") String user_last_name,
			@NotNull String username, @NotEmpty(message = "Please provide your first name") String user_first_name,
			@Email(message = "Please provide a valid e-mail") @NotEmpty(message = "Please provide an e-mail") String email,
			int user_age, String password, String gendre, Long phone_numbre, String address, User_type type,
			boolean enabled, String confirmationToken, boolean isPresent, Collection<Conversation> conversations,
			Collection<Message> message, Collection<Relation> experts, Collection<Relation> patients) {
		super(user_last_name, username, user_first_name, email, user_age, password, gendre, phone_numbre, address, type,
				enabled, confirmationToken, isPresent, conversations, message, experts, patients);
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Device_user(@NotEmpty(message = "Please provide your last name") String user_last_name,
			@NotNull String username, @NotEmpty(message = "Please provide your first name") String user_first_name,
			@Email(message = "Please provide a valid e-mail") @NotEmpty(message = "Please provide an e-mail") String email,
			int user_age, String password, String gendre, Long phone_numbre, String address, User_type type,
			boolean enabled, String confirmationToken, boolean isPresent, Collection<Conversation> conversations,
			Collection<Message> message, Collection<Relation> experts, Collection<Relation> patients,
			Foot_type foot_type, int weight, int height, int glucose, Collection<Anomality> anomalities,
			Collection<Pathological_genealogy> pathological_genealogy, Collection<Relatives> realtives,
			Collection<Stats> stats, Collection<Affected_exercice> affected_exercice) {
		super(user_last_name, username, user_first_name, email, user_age, password, gendre, phone_numbre, address,
				type, enabled, confirmationToken, isPresent, conversations, message, experts, patients);
		this.foot_type = foot_type;
		this.weight = weight;
		this.height = height;
		this.glucose = glucose;
		this.anomalities = anomalities;
		this.pathological_genealogy = pathological_genealogy;
		this.realtives = realtives;
		this.stats = stats;
		this.affected_exercice = affected_exercice;
	}
	
	
	public Foot_type getFoot_type() {
		return foot_type;
	}
	public void setFoot_type(Foot_type foot_type) {
		this.foot_type = foot_type;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getGlucose() {
		return glucose;
	}
	public void setGlucose(int glucose) {
		this.glucose = glucose;
	}
	
	@JsonIgnore
	public Collection<Anomality> getAnomalities() {
		return anomalities;
	}
	@JsonSetter
	public void setAnomalities(Collection<Anomality> anomalities) {
		this.anomalities = anomalities;
	}
	@JsonIgnore
	public Collection<Pathological_genealogy> getPathological_genealogy() {
		return pathological_genealogy;
	}
	@JsonSetter
	public void setPathological_genealogy(Collection<Pathological_genealogy> pathological_genealogy) {
		this.pathological_genealogy = pathological_genealogy;
	}
	@JsonIgnore
	public Collection<Relatives> getRealtives() {
		return realtives;
	}
	@JsonSetter
	public void setRealtives(Collection<Relatives> realtives) {
		this.realtives = realtives;
	}
	@JsonIgnore
	public Collection<Stats> getStats() {
		return stats;
	}
	@JsonSetter
	public void setStats(Collection<Stats> stats) {
		this.stats = stats;
	}
	@JsonIgnore
	public Collection<Affected_exercice> getAffected_exercice() {
		return affected_exercice;
	}
	@JsonSetter
	public void setAffected_exercice(Collection<Affected_exercice> affected_exercice) {
		this.affected_exercice = affected_exercice;
	}
	
		
		
		
		
	
	

}
