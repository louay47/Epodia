package org.epodia.component;

import org.epodia.entities.User;
import org.epodia.metier.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;




@Component
public class JwtAuthenticationProvider implements AuthenticationProvider
{
	
	@Autowired
	private JwtService jwtService;
	

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException
	{
		
		try
		{
			User user = jwtService.verifyToken((String)authentication.getCredentials());
			return new JwtAuthenticatedUser(user);
		}
		catch(Exception e)
		{
			throw new RuntimeException(e);
		}
		
	}

	
	@Override
	public boolean supports(Class<?> authentication)
	{
		
		return JwtAuthToken.class.equals(authentication);
		
	}

}