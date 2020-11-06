package org.epodia.component;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;


@Component
public class CORSFilter implements Filter
{
	
	// The list of domains allowed to access the server
	private final List<String> allowedOrigins = Arrays.asList("http://localhost:4200", "http://127.0.0.1:4200" ,"http://localhost:5000" , "http://127.0.0.1:5000");

	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException
	{
		
	}
	
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException
	{
		
		// Lets make sure that we are working with HTTP (that is, against HttpServletRequest and HttpServletResponse objects)
		if (request instanceof HttpServletRequest && response instanceof HttpServletResponse)
		{
			HttpServletRequest httpServletRequest = (HttpServletRequest) request;
			HttpServletResponse httpServletResponse = (HttpServletResponse) response;
			
			// Access-Control-Allow-Origin
			String origin = httpServletRequest.getHeader("Origin");
			httpServletResponse.setHeader("Access-Control-Allow-Origin", allowedOrigins.contains(origin) ? origin : "");
			httpServletResponse.setHeader("Vary", "Origin");
			
			// Access-Control-Max-Age
			httpServletResponse.setHeader("Access-Control-Max-Age", "3600");
			
			// Access-Control-Allow-Credentials
			httpServletResponse.setHeader("Access-Control-Allow-Credentials", "true");
			
			// Access-Control-Allow-Methods
			httpServletResponse.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT");
			
			// Access-Control-Allow-Headers
			httpServletResponse.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, Authorization");
			
			// We expose the Token Header in order to make the front application able to read it
			//httpServletResponse.setHeader("Access-Control-Expose-Headers", "Token");
		}
		chain.doFilter(request, response);
		
	}
	
	
	@Override
	public void destroy()
	{
		
	}
	
}