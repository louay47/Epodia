package org.epodia.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import org.epodia.component.CORSFilter;
//import com.wevioo.gteleg.component.JwtAuthFilter;
//import com.wevioo.gteleg.component.JwtAuthenticationProvider;
//import com.wevioo.gteleg.component.RESTAuthenticationEntryPoint;
import org.epodia.component.JwtAuthFilter;
import org.epodia.component.JwtAuthenticationProvider;
import org.epodia.component.RESTAuthenticationEntryPoint;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter
{
	
	@Autowired
    private JwtAuthFilter jwtAuthFilter;
	
	@Autowired
	private CORSFilter corsFilter;
	
	@Autowired
	private JwtAuthenticationProvider jwtAuthenticationProvider;
	
	@Autowired
	private RESTAuthenticationEntryPoint authenticationEntryPoint;
	
	@Bean
	public PasswordEncoder passwordEncoder()
	{
	    return new BCryptPasswordEncoder();
	}
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception
	{
		auth.authenticationProvider(jwtAuthenticationProvider);
	}
	
	
	@Override
    protected void configure(HttpSecurity http) throws Exception
	{
		
        http.csrf().disable();
        
        http.sessionManagement()
        	.sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.authorizeRequests()
           // .antMatchers("/users").permitAll()
        .antMatchers("/api/	**").permitAll()
        .antMatchers("/api/v1/**").permitAll()
            .antMatchers("/api/v1/login").permitAll()
            .antMatchers("/user/registration").permitAll()
            .antMatchers("/user/confirm/*").permitAll()
            .antMatchers("/private/chat/*").permitAll()
            .antMatchers("/api/private-chat/channel").permitAll()
            .antMatchers("/api/private-chat/channel/*").permitAll()
            .antMatchers("/topic/user.notification.*").permitAll()
            
            .antMatchers("/v2/api-docs").permitAll()
            .antMatchers("/topic/private/chat/*").permitAll()
            .antMatchers("/swagger-resources/**").permitAll()
            .antMatchers("/swagger-ui.html").permitAll()
            .antMatchers("/webjars/**").permitAll()
            .antMatchers(HttpMethod.OPTIONS , "/*/**").permitAll()
            .antMatchers("/**/*").authenticated();
        
        http.addFilterBefore(corsFilter, ChannelProcessingFilter.class);
        
        http.addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
        
        http.exceptionHandling()
           .authenticationEntryPoint(authenticationEntryPoint);
        
    }
	
}