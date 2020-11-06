package org.epodia.services;



import java.util.Collection;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.epodia.dto.EmailDto;
import org.epodia.entities.User;
import org.epodia.exception.AccountAlreadyExist;
import org.epodia.exception.UserNotFoundException;
import org.epodia.metier.UserMetier;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/v1")
public class UserRestService  {
	@Autowired
	private UserMetier userMetier ;

	@Autowired
	private PasswordEncoder passwordEncoder ;
	
	
	
	@RequestMapping(value="/users",method=RequestMethod.POST)
	
	public User saveUser(@RequestBody User u) {
	
		u.setPassword(passwordEncoder.encode(u.getPassword()));
		
		return userMetier.saveUser(u);
	}
	
	@RequestMapping(value = "/user/registration", method = RequestMethod.POST)
	//@ResponseBody
	@Transactional
	public void registerUserAccount(@RequestBody User user, HttpServletRequest request) throws Exception {
		
		System.out.println("Registring user account with infos "+user);
		
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		
	 
	   
	    if (user==null) {
	    	throw new UserNotFoundException("user credentials are empty");
	    }
	    else {
	    	if (user.getUsername().equals(userMetier.getUserByUsername(user.getUsername()))) {
	    		
	    		throw new AccountAlreadyExist("Another account with the same Username exists") ;
	    	}
	    	else if (user.getEmail().equals(userMetier.findByEmail(user.getEmail()))) {
	    		
	    		throw new AccountAlreadyExist("Another account with the same Email exists") ;
	    		
	    	}
	    	else {
	    		user.setEnabled(false);
	    		
	    		user.setConfirmationToken(UUID.randomUUID().toString());
	    		
	    		userMetier.saveUser(user);
	    		
	    		String appUrl = request.getScheme() + "://" + request.getServerName();
	    		
	    		userMetier.SendConfirmationEmail(user);
	    		
	    	}
	    }
	    
	 
	}
	
	@RequestMapping(value = "/user/confirm/{confirm}", method = RequestMethod.GET)
	public String confirmUserAccount(@PathVariable("confirm") String confirm) {
		String res ;
		User user = userMetier.findByConfirmationToken(confirm) ;
		if (user == null) {
			
			throw new UserNotFoundException("Registration failed");
		}
		else {
			user.setEnabled(true) ;
			
			System.out.println("user confirmed "+user.getEmail());
			
			userMetier.UpdateUser(user, user.getId());
			
			res="ACCOUNT ACTIVATED , YOU CAN USE THIS CREDENTIALS IN ORDER TO LOGIN <br> login : "+user.getUsername()+"<br> email : "+user.getEmail() ;
			
			return res ;
		}
	}

	@RequestMapping(value="/users",method=RequestMethod.GET)
	public List<User> ListUsers() {
		return userMetier.ListUsers();
	}
	
	@RequestMapping(value="/users/{id}",method=RequestMethod.GET)
	public User GetUserById(@PathVariable("id") Long id) {
		return userMetier.GetUserById(id);
	}
	
	@RequestMapping(value="/users/{id}",method=RequestMethod.PUT)
	public User UpdateUser(@RequestBody User u, @PathVariable("id") Long id) {
		return userMetier.UpdateUser(u, id);
	}
	
	@RequestMapping(value="/users/{expert_id}/{patient_id}",method=RequestMethod.GET)
	public Boolean CreatePatientExpert(@PathVariable("expert_id") Long expert_id,
										@PathVariable("patient_id")Long patient_id) 
	{
		return userMetier.CreatePatientExpertRelation(expert_id, patient_id);
	}
	
	@RequestMapping(value="/users/patientList/{expert_id}",method=RequestMethod.GET)
	public Collection<User> getPatientList(@PathVariable("expert_id") Long expert_id) 
	{
		return userMetier.getPatientList(expert_id);
	}	
	
	@RequestMapping(value="/users/expertList/{patient_id}",method=RequestMethod.GET)
	public Collection<User> getExpertList(@PathVariable("patient_id") Long patient_id) 
	{
		return userMetier.getExpertList(patient_id);
	}
	
	@RequestMapping(value ="/users/findByEmail",method=RequestMethod.POST)
	public User findByEmail(@RequestBody EmailDto email) {
		
		return userMetier.findByEmail(email);
	}

	@RequestMapping(value ="/users/findByConfirmationToken/{confirmationToken}",method=RequestMethod.GET)
	public User findByConfirmationToken(@PathVariable("confirmationToken") String confirmationToken) {
		return userMetier.findByConfirmationToken(confirmationToken);
	}

	@RequestMapping(value ="/users/getUserByLogin/{username}",method=RequestMethod.GET)
	public User getUserByLogin(@PathVariable("username") String username) {
		return userMetier.getUserByUsername(username);
	}

}
