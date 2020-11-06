package org.epodia.metier;

import java.io.IOException;
import java.net.URISyntaxException;

import org.epodia.entities.User;




public interface JwtService
{
	
	/**
	 * login createToken, Implemented in JwtServiceImpl
	 * 
	 * @param user
	 * @return
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	public String createToken(User user) throws IOException, URISyntaxException;
	
	
	/**
	 * login verifyToken, Implemented in JwtServiceImpl
	 * 
	 * @param token
	 * @return
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	public User verifyToken(String token) throws IOException, URISyntaxException;
	
}