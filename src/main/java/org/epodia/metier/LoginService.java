package org.epodia.metier;

import org.epodia.dto.LoginCredentials;
import org.epodia.entities.User;




public interface LoginService
{
	
	/**
	 * login Method, Implemented in LoginServiceImpl
	 * 
	 * @param loginCredentials
	 * @return
	 */
	public User login(LoginCredentials loginCredentials);
	
}