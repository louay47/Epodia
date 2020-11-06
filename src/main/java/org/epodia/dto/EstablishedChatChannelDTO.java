package org.epodia.dto;

public class EstablishedChatChannelDTO {
	
	  private Long id;
	  
	  private String userOneFullName;
	  
	  private String userTwoFullName;

	public EstablishedChatChannelDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EstablishedChatChannelDTO(Long id, String userOneFullName, String userTwoFullName) {
		super();
		this.id = id;
		this.userOneFullName = userOneFullName;
		this.userTwoFullName = userTwoFullName;
	}

	public Long getConv_id() {
		return id;
	}

	public void setConv_id(Long id) {
		this.id = id;
	}

	public String getUserOneFullName() {
		return userOneFullName;
	}

	public void setUserOneFullName(String userOneFullName) {
		this.userOneFullName = userOneFullName;
	}

	public String getUserTwoFullName() {
		return userTwoFullName;
	}

	public void setUserTwoFullName(String userTwoFullName) {
		this.userTwoFullName = userTwoFullName;
	}

	 
}
