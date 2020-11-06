package org.epodia.metier;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.util.Date;

import org.epodia.component.SecretKeyProvider;
import org.epodia.dao.UserRepository;
import org.epodia.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import static java.time.ZoneOffset.UTC;


@Service
public class JwtServiceImpl implements JwtService
{
	
	/**
	 * Dependency Injection
	 */
	@Autowired
	private SecretKeyProvider secretKeyProvider;
	
	@Autowired
	private UserRepository userRepository;
	
	
	
	private static final String ISSUER = "ff.epodia.jwt";
	
	
	/**
	 * Implementation of the createToken method defined in JwtService Interface
	 * {@inheritDoc}
	 */
	@Override
	public String createToken(User user) throws IOException, URISyntaxException
	{
		
		byte[] secretKey = secretKeyProvider.getKey();
        Date expiration = Date.from(LocalDateTime.now().plusHours(8).toInstant(UTC));
        return Jwts.builder()
                   .setSubject(user.getUser_last_name())
                   .setExpiration(expiration)
                   .setIssuer(ISSUER)
                   .signWith(SignatureAlgorithm.HS512, secretKey)
                   .compact();
        
	}
	
	
	/**
	 * Implementation of the verifyToken method defined in JwtService Interface
	 * {@inheritDoc}
	 */
	@Override
	public User verifyToken(String token) throws IOException, URISyntaxException
	{
		
		byte[] secretKey = secretKeyProvider.getKey();
        Jws<Claims> claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
        return userRepository.getUserByUsername(claims.getBody().getSubject().toString());
        
	}
	
	
/*	public UserDto buildUserDto(User user)
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