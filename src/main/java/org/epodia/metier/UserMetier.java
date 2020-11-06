package org.epodia.metier;

import java.util.Collection;
import java.util.List;

import org.epodia.dto.EmailDto;

import org.epodia.entities.User;



public interface UserMetier {
	
	public User saveUser(User u) ;
	
	public List<User> ListUsers() ;
	
	public User GetUserById (Long id);
	
	public User UpdateUser (User u, Long id);
	
	public Boolean CreatePatientExpertRelation (Long expert_id , Long patient_id );
	
	public Collection<User> getPatientList( Long id);
	
	public Collection<User> getExpertList( Long id);
	
	public User findByEmail(EmailDto email);
	
	public User findByEmail(String email);
	
    public User findByConfirmationToken(String confirmationToken);
	
    public User getUserByUsername(String username);
    
    public void SendConfirmationEmail(User user) throws Exception;
    
   // public User CompleteRegistration (String email);
    
    public void setIsPresent(User user, Boolean stat);

    public Boolean isPresent(User user);

   // public void notifyUser(User user, NotificationDTO notification);
  

	

}
