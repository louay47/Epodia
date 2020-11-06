package org.epodia.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Proxy;

@Entity
@Proxy(lazy=false)
public class Conversation implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
		private long id ;
		
		private Date créer_à ;
		
		
	@OneToMany(mappedBy="conversation",fetch=FetchType.LAZY)
		private Collection<Message> message ;
	@ManyToOne
	@JoinColumn(name="CODE_USER_1")
		private User user ;
	@ManyToOne
	@JoinColumn(name="CODE_USER_2")
		private User user2 ;
	public Conversation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Conversation( 
			 User user1, User user2) {
		super();
		
		
		
		
		
		this.user = user1;
		this.user2 = user2;
	}
	public long getId_conv() {
		return id;
	}
	public void setId_conv(long id) {
		this.id = id;
	}
	
	public Date getCréer_à() {
		return créer_à;
	}
	public void setCréer_à(Date créer_à) {
		this.créer_à = créer_à;
	}
	
	public Collection<Message> getMessage() {
		return message;
	}
	public void setMessage(Collection<Message> message) {
		this.message = message;
	}
	public User getUser1() {
		return user;
	}
	public void setUser1(User user1) {
		this.user = user1;
	}
	public User getUser2() {
		return user2;
	}
	public void setUser2(User user2) {
		this.user2 = user2;
	}
	
	
	
	
	
	
	

}
