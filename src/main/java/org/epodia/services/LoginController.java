package org.epodia.services;

import javax.servlet.http.HttpServletResponse;

import org.epodia.dto.LoginCredentials;
import org.epodia.entities.User;
import org.epodia.metier.JwtService;
import org.epodia.metier.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping(value = "api/v1")
public class LoginController
{
	
	/**
	 * Dependency Injection
	 */
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private JwtService jwtService;

	
	@RequestMapping(value = "/login" , method = RequestMethod.POST)
	public User login(@RequestBody LoginCredentials loginCredentials , HttpServletResponse response)
	{
		
		User user = loginService.login(loginCredentials);
		
		if(user != null)
		{
			try
			{
				response.setHeader("Token", jwtService.createToken(user));
			}
			catch(Exception e)
			{
				throw new RuntimeException(e);
			}
		}
		
		return user;
		
	}
	
}