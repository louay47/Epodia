package org.epodia.exception;

public class AccountAlreadyExist extends RuntimeException{
	
private static final long serialVersionUID = 1L;

	
	public AccountAlreadyExist(String message)
	{
		super(message);
	}

}
