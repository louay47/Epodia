package org.epodia.metier;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.epodia.dao.UserRepository;
import org.epodia.dto.LoginCredentials;
import org.epodia.entities.User;
import org.epodia.exception.AccountNotActiveException;
import org.epodia.exception.UserNotFoundException;
import org.epodia.exception.WrongPasswordException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;



@Service
public class LoginServiceImpl implements LoginService
{
	
	/**
	 * Dependency Injection
	 */
	@Autowired
	private UserRepository userRepository;
	
	
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	private static final Log LOGGER = LogFactory.getLog(LoginService.class);
	

	/**
	 * Implementation of the login method defined in LoginService Interface
	 * {@inheritDoc}
	 */
	@Override
	public User login(LoginCredentials loginCredentials)
	{
		
		LOGGER.info("Method login in progress...");
		
		System.out.println("username : "+loginCredentials.getUsername());
		System.out.println("password : "+loginCredentials.getPassword());
		
		// We look for a user with the provided login
		User user = userRepository.getUserByUsername(loginCredentials.getUsername());
		
		
		if(user == null)
		{
			// There is no user with such login
			// We throw UserNotFoundException
			throw new UserNotFoundException("Login incorrect");
		}
		else
		{ 
			System.out.println(loginCredentials.getPassword());
			System.out.println(user.getUsername());
			//loginCredentials.setPassword(passwordEncoder.encode(loginCredentials.getPassword()));
			
			// We found a user with the provided login so we verify the provided password with the one stored in the database
			if((loginCredentials.getPassword() == null) || !(passwordEncoder.matches(loginCredentials.getPassword(), user.getPassword())))
			{
				// The passwords doesn't match
				// We throw WrongPasswordException
				throw new WrongPasswordException("Mot de passe incorrect");
			}
			else
			{
				// The provided password is correct
				// We check if the user account is activated
				if(user.isEnabled() == false)
				{
					// The account is not activated
					// We throw AccountNotActiveException
					throw new AccountNotActiveException("Compte bloqué");
				}
				else
				{
					// The credentials are valid and the account is activated we return the user
					return userRepository.getUserByUsername(loginCredentials.getUsername());
				}
			}
		}
		
	}
	
	
	/*public UserDto buildUserDto(User user)
	{
		
		UserDto userDto = new UserDto();
		
		if((user.getProfile().equals(UserProfileType.ADMINISTRATOR)) || (user.getProfile().equals(UserProfileType.ACCOUNTING)))
		{
			
			userDto.setUserID(user.getUserID());
			userDto.setUserFirstName(user.getUserFirstName());
			userDto.setUserName(user.getUserName());
			userDto.setLogin(user.getLogin());
			userDto.setProfile(user.getProfile());
			userDto.setAccountCreationDate(user.getAccountCreationDate());
			userDto.setAccountState(user.isAccountState());
			userDto.setValidationGroupID(null);
			userDto.setValidationGroupName("");
			userDto.setAssignmentGroupID(null);
			userDto.setAssignmentGroupName("");
			
		}
		else if(user.getProfile().equals(UserProfileType.VALIDATOR_1))
		{
			Validator1 validator1 = validator1Dao.findOne(user.getUserID());
						
			userDto.setUserID(validator1.getUserID());
			userDto.setUserFirstName(validator1.getUserFirstName());
			userDto.setUserName(validator1.getUserName());
			userDto.setLogin(validator1.getLogin());
			userDto.setProfile(validator1.getProfile());
			userDto.setAccountCreationDate(validator1.getAccountCreationDate());
			userDto.setAccountState(validator1.isAccountState());
			userDto.setValidationGroupID(validator1.getValidationGroup().getGroupID());
			userDto.setValidationGroupName(validator1.getValidationGroup().getGroupName());
			userDto.setAssignmentGroupID(validator1.getAssignmentGroup().getGroupID());
			userDto.setAssignmentGroupName(validator1.getAssignmentGroup().getGroupName());
			
		}
		else if(user.getProfile().equals(UserProfileType.VALIDATOR_2))
		{
			Validator2 validator2 = validator2Dao.findOne(user.getUserID());
						
			userDto.setUserID(validator2.getUserID());
			userDto.setUserFirstName(validator2.getUserFirstName());
			userDto.setUserName(validator2.getUserName());
			userDto.setLogin(validator2.getLogin());
			userDto.setProfile(validator2.getProfile());
			userDto.setAccountCreationDate(validator2.getAccountCreationDate());
			userDto.setAccountState(validator2.isAccountState());
			userDto.setValidationGroupID(null);
			userDto.setValidationGroupName("");
			userDto.setAssignmentGroupID(validator2.getAssignmentGroup().getGroupID());
			userDto.setAssignmentGroupName(validator2.getAssignmentGroup().getGroupName());
			
		}
		else if((user.getProfile().equals(UserProfileType.OPERATOR_P1)) || (user.getProfile().equals(UserProfileType.OPERATOR_P2)))
		{
			Operator operator = operatorDao.findOne(user.getUserID());
						
			userDto.setUserID(operator.getUserID());
			userDto.setUserFirstName(operator.getUserFirstName());
			userDto.setUserName(operator.getUserName());
			userDto.setLogin(operator.getLogin());
			userDto.setProfile(operator.getProfile());
			userDto.setAccountCreationDate(operator.getAccountCreationDate());
			userDto.setAccountState(operator.isAccountState());
			userDto.setValidationGroupID(operator.getValidationGroup().getGroupID());
			userDto.setValidationGroupName(operator.getValidationGroup().getGroupName());
			userDto.setAssignmentGroupID(null);
			userDto.setAssignmentGroupName("");
			
		}
		else if (user.getProfile().equals(UserProfileType.POST_OFFICE_AGENT))
		{
			PostOfficeAgent postOfficeAgent = postOfficeAgentDao.findOne(user.getUserID());
						
			userDto.setUserID(postOfficeAgent.getUserID());
			userDto.setUserFirstName(postOfficeAgent.getUserFirstName());
			userDto.setUserName(postOfficeAgent.getUserName());
			userDto.setLogin(postOfficeAgent.getLogin());
			userDto.setProfile(postOfficeAgent.getProfile());
			userDto.setAccountCreationDate(postOfficeAgent.getAccountCreationDate());
			userDto.setAccountState(postOfficeAgent.isAccountState());
			userDto.setValidationGroupID(postOfficeAgent.getValidationGroup().getGroupID());
			userDto.setValidationGroupName(postOfficeAgent.getValidationGroup().getGroupName());
			userDto.setAssignmentGroupID(null);
			userDto.setAssignmentGroupName("");
			
		}
		
		return userDto;
		
	}*/

}