package org.epodia.metier;

import org.epodia.dto.ChatChannelInitializationDTO;
import org.epodia.entities.Message;
import org.epodia.exception.IsSameUserException;
import org.epodia.exception.UserNotFoundException;
import org.springframework.http.ResponseEntity;



public interface ConversationMetier {
	
	public Message chatMessage( Long id, Message message) ;
	
	public ResponseEntity<String> establishChatChannel( ChatChannelInitializationDTO chatChannelInitialization)
			 throws IsSameUserException, UserNotFoundException; 
	
	public ResponseEntity<String> getExistingChatMessages( Long id);

}
