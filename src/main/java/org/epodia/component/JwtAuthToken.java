package org.epodia.component;

import java.util.Collection;

import org.epodia.entities.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;




public class JwtAuthToken implements Authentication
{
	
	private static final long serialVersionUID = 1L;
	
	private final String token;
	private User user;
	
	
	public JwtAuthToken(String token , User user)
    {
        this.token = token;
        this.user = user;
    }
	
	
	@Override
	public String getName()
	{
		return null;
	}

	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities()
	{
		return null;
	}

	
	@Override
	public Object getCredentials()
	{
		return token;
	}

	
	@Override
	public Object getDetails()
	{
		return null;
	}

	
	@Override
	public Object getPrincipal()
	{
		return user;
	}

	
	@Override
	public boolean isAuthenticated()
	{
		return false;
	}

	
	@Override
	public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException
	{
		
	}

}
