package org.epodia.component;

import java.util.Collection;
import java.util.Collections;

import org.epodia.entities.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;




public class JwtAuthenticatedUser implements Authentication
{
	
	private static final long serialVersionUID = 1L;
	
	private User user;
	
	
	public JwtAuthenticatedUser(User user)
	{
		this.user = user;
	}
	
	
	@Override
	public String getName()
	{
		return user.getUser_last_name();
	}
	

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities()
	{
		return Collections.singletonList(new SimpleGrantedAuthority("ROLE_"+user.getType()));
	}
	

	@Override
	public Object getCredentials()
	{
		return user;
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
		return true;
	}
	

	@Override
	public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException
	{

	}

}
