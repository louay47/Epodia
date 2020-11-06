package org.epodia.component;

import java.io.IOException;
import java.net.URISyntaxException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.epodia.entities.User;
import org.epodia.metier.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;



@Component
public class JwtAuthFilter implements Filter
{
	
	@Autowired
	private JwtService jwtService;
	
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException
	{
		
	}
	
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException
	{
		
		HttpServletRequest servletRequest = (HttpServletRequest) request;
        String authorization = servletRequest.getHeader("Authorization");
        
        if (authorization != null)
        {
        	authorization = authorization.replaceAll("Bearer ", "");
        	User user;
        	
			try
			{
				user = jwtService.verifyToken(authorization);
				JwtAuthToken token = new JwtAuthToken(authorization , user);
	            SecurityContextHolder.getContext().setAuthentication(token);
			}
			catch (URISyntaxException e)
			{
				e.printStackTrace();
			}
            
        }
        
        chain.doFilter(request, response);
        
	}
	
	
	@Override
	public void destroy()
	{
		
	}
	
}
