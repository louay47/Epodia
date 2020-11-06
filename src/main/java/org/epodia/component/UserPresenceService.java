package org.epodia.component;

import org.epodia.entities.User;
import org.epodia.exception.UserNotFoundException;
import org.epodia.metier.IUserPresenceService;
import org.epodia.metier.UserMetier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptorAdapter;
import org.springframework.stereotype.Component;


@Component
public class UserPresenceService extends ChannelInterceptorAdapter implements IUserPresenceService {
	
	 @Autowired 
	  private UserMetier userMetier;

	  @Override
	  public void postSend(Message<?> message, MessageChannel channel, boolean sent) {
	    StompHeaderAccessor stompDetails = StompHeaderAccessor.wrap(message);

	    if(stompDetails.getCommand() == null) { return; }

	    switch(stompDetails.getCommand()) {
	      case CONNECT:    
	      case CONNECTED:
	        toggleUserPresence(stompDetails.getUser().getName().toString(), true);
	        break;
	      case DISCONNECT:
	        toggleUserPresence(stompDetails.getUser().getName().toString(), false);
	        break;
	      default:
	        break;
	    }
	  }

	  private void toggleUserPresence(String userEmail, Boolean isPresent) {
	    try {
	      User user = userMetier.findByEmail(userEmail);
	      userMetier.setIsPresent(user, isPresent);
	    } catch (UserNotFoundException e) {
	      e.printStackTrace();
	    }
	  }
	

}
