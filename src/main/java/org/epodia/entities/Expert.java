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

import org.epodia.enumeration.Expert_type;
import org.epodia.enumeration.User_type;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

@Entity
@DiscriminatorValue("EXPERT")
public class Expert extends User{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Enumerated(EnumType.STRING)
	@JoinColumn(name = "EXPERT_TYPE" , nullable = false)
		private Expert_type expert_type ;
	
	@OneToMany(mappedBy="experts",fetch=FetchType.LAZY)
		private Collection<Generated_exercice> generated_exercice ;
	/*
	 * 
	 * NEW RELATION BETWEEN EXPERT & AFFECTED_EXERCICE
	 * 
	 */
	@OneToMany(mappedBy="experts",fetch=FetchType.LAZY)
		private Collection<Affected_exercice> affected_exercice ;

	
	public Expert() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Expert( @NotEmpty(message = "Please provide your last name") String user_last_name,
			@NotNull String username, @NotEmpty(message = "Please provide your first name") String user_first_name,
			@Email(message = "Please provide a valid e-mail") @NotEmpty(message = "Please provide an e-mail") String email,
			int user_age, String password, String gendre, Long phone_numbre, String address, User_type type,
			boolean enabled, String confirmationToken, boolean isPresent, Collection<Conversation> conversations,
			Collection<Message> message, Collection<Relation> experts, Collection<Relation> patients) {
		super(user_last_name, username, user_first_name, email, user_age, password, gendre, phone_numbre, address, type,
				enabled, confirmationToken, isPresent, conversations, message, experts, patients);
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Expert( @NotEmpty(message = "Please provide your last name") String user_last_name,
			@NotNull String username, @NotEmpty(message = "Please provide your first name") String user_first_name,
			@Email(message = "Please provide a valid e-mail") @NotEmpty(message = "Please provide an e-mail") String email,
			int user_age, String password, String gendre, Long phone_numbre, String address, User_type type,
			boolean enabled, String confirmationToken, boolean isPresent, Collection<Conversation> conversations,
			Collection<Message> message, Collection<Relation> experts, Collection<Relation> patients,
			Expert_type expert_type, Collection<Generated_exercice> generated_exercice,
			Collection<Affected_exercice> affected_exercice) {
		super(user_last_name, username, user_first_name, email, user_age, password, gendre, phone_numbre, address,
				type, enabled, confirmationToken, isPresent, conversations, message, experts, patients);
		this.expert_type = expert_type;
		this.generated_exercice = generated_exercice;
		this.affected_exercice = affected_exercice;
	}
	
	
	
	public Expert_type getExpert_type() {
		return expert_type;
	}
	public void setExpert_type(Expert_type expert_type) {
		this.expert_type = expert_type;
	}
	@JsonIgnore
	public Collection<Generated_exercice> getGenerated_exercice() {
		return generated_exercice;
	}
	@JsonSetter
	public void setGenerated_exercice(Collection<Generated_exercice> generated_exercice) {
		this.generated_exercice = generated_exercice;
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
