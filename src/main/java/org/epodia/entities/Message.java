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
public class Message  implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
		private long id ;
		
		private String contents  ;
		
		private Date timeSent ;
		
	@ManyToOne
	@JoinColumn(name="CONV_ID")
		private Conversation conversation ;
	@ManyToOne
	@JoinColumn(name="SENDER_ID")
		private User user ;
	@ManyToOne
	@JoinColumn(name="RECIPIENT_ID")
		private User user2 ;
	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Message(  String contents, 
		 User user1, User user2) {
		super();
		
		this.contents = contents;
		
		this.user = user1;
		this.user2 = user2;
		this.timeSent = new Date();
	}
	public long getId_msg() {
		return id;
	}
	public void setId_msg(long id) {
		this.id = id;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public Date getTimeSent() {
		return timeSent;
	}
	public void setTimeSent(Date timeSent) {
		this.timeSent = timeSent;
	}
	public Conversation getConversation() {
		return conversation;
	}
	public void setConversation(Conversation conversation) {
		this.conversation = conversation;
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
