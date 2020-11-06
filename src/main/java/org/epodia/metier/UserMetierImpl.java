package org.epodia.metier;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.epodia.dao.RelationRepository;
import org.epodia.dao.UserRepository;
import org.epodia.dto.EmailDto;
import org.epodia.dto.NotificationDTO;
import org.epodia.entities.Relation;
import org.epodia.entities.User;
import org.epodia.enumeration.User_type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import freemarker.template.Configuration;
import freemarker.template.Template;

@Service
public class UserMetierImpl implements UserMetier{

	@Autowired
	private UserRepository userRepository ;
	
	@Autowired
	private RelationRepository relationRepository ; 
	
	@Autowired
	private JavaMailSender sender ;
	
	@Autowired
	private Configuration freemarkerConfig;
	
/*	@Autowired
	private SimpMessagingTemplate simpMessagingTemplate;*/
	
	@Override
	public User saveUser(User u) {
		// TODO Auto-generated method stub
		return userRepository.save(u);
	}

	@Override
	public List<User> ListUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public User GetUserById (Long id) {
		// TODO Auto-generated method stub
		return userRepository.getOne(id);
	}
	
	@Override
	public User UpdateUser(User u, Long id) {
		u.setId(id);
		return userRepository.saveAndFlush(u);
	}
	
	@Override
	public Boolean CreatePatientExpertRelation(Long expert_id, Long patient_id ) {
		User expert =  GetUserById( expert_id );
		System.out.println("expert id : "+expert.getId());
		User patient =  GetUserById( patient_id );
		
		
		if (expert.getType().equals(User_type.EXPERT) && patient.getType().equals(User_type.DEVICE_USER)) {
			
			Relation relation = new Relation();
			relation.setDate_relation(new Date());
			relation.setExpert(expert);
			relation.setPatient(patient);
			
			relation = relationRepository.save(relation);
			
			Collection<Relation> c = expert.getPatients();
			c.add(relation);
			expert.setPatients(c);
			
			c = null;
			c = patient.getExperts();
			c.add(relation);
			patient.setExperts(c);
			
			userRepository.saveAndFlush(expert);
			userRepository.saveAndFlush(patient);
			
			/*Collection<User> receiverUsers = receiver.getUser();
			receiverUsers.add(issuer);
			receiver.setUser(receiverUsers);
			this.UpdateUser(receiver, receiver_id);*/
			
			/*Collection<User> issuerUsers = issuer.getUser();
			issuerUsers.add(receiver);
			issuer.setUser(issuerUsers);
			this.UpdateUser(issuer, issuer_id);*/
			
			return true;
		}
		else {
			return false;
		}
		
	}

	@Override
	public Collection<User> getPatientList(Long id) {
		// TODO Auto-generated method stub
		return userRepository.getPatientList(id);
	}

	@Override
	public Collection<User> getExpertList(Long id) {
		// TODO Auto-generated method stub
		return userRepository.getExpertList(id);
	}

	@Override
	public User findByEmail(String email) {
		// TODO Auto-generated method stub
		//User user = userRepository.findByEmail(email);
		//System.out.println("Email is : "+user.getEmail());
		
		
		System.out.println("param email is : "+email);
		return userRepository.findByEmail(email);
	}
	
	@Override
	public User findByEmail(EmailDto email) {
		// TODO Auto-generated method stub
		//User user = userRepository.findByEmail(email);
		//System.out.println("Email is : "+user.getEmail());
		
		
		System.out.println("param email is : "+email);
		return userRepository.findByEmail(email.getEmail());
	}

	@Override
	public User findByConfirmationToken(String confirmationToken) {
		
		return userRepository.findByConfirmationToken(confirmationToken);
	}

	@Override
	public User getUserByUsername(String username) {
		// TODO Auto-generated method stub
		System.out.println("param username is : "+username);
		return userRepository.getUserByUsername(username);
	}

	@Override
	public void SendConfirmationEmail(User user) throws Exception{
		
		
		
			 MimeMessage message = sender.createMimeMessage();
			 
			 MimeMessageHelper helper = new MimeMessageHelper(message);
			 
			 Map<String, Object> model = new HashMap();
			 
			 model.put("login", user.getUsername());
			 
			 model.put( "confirm" , user.getConfirmationToken());
			 
			 freemarkerConfig.setClassForTemplateLoading(this.getClass(), "/");

			 Template t = freemarkerConfig.getTemplate("Nouvel e-mail.html");
			 
			 String text = FreeMarkerTemplateUtils.processTemplateIntoString(t, model);
			 
			

			 helper.setTo(user.getEmail());
			 helper.setText(text, true);
			 helper.setSubject("FollowedFeet-Confirm your email");

			 /*ClassPathResource file = new ClassPathResource("hqdefault.jpg");
			 File f = new resource.getFile();
			 File f = new File("hqdefault.jpg");
			 System.out.println(f.getAbsolutePath());
			 System.out.println(f.exists());
			 String absolutePath = f.getAbsolutePath();
			 helper.addAttachment("hqdefault.jpg", file);*/

			 sender.send(message);
			 
		 

		
	}

	@Override
	  public void setIsPresent(User user, Boolean stat) {
	    user.setPresent(stat);

	    userRepository.save(user);
	  }

	@Override
	  public Boolean isPresent(User user) {
	    return user.isPresent(); 
	  }

	/*@Override
	  public void notifyUser(User recipientUser, NotificationDTO notification) {
	    if (this.isPresent(recipientUser)) {
	      simpMessagingTemplate
	        .convertAndSend("/topic/user.notification." + recipientUser.getId_user(), notification);
	    } else {
	      System.out.println("sending email notification to " + recipientUser.getLogin());
	      // TODO: send email
	    }
	  }*/

	

	

}
