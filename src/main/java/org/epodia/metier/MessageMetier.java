package org.epodia.metier;

import java.util.Collection;

import org.epodia.dto.ChatChannelInitializationDTO;

import org.epodia.entities.Message;
import org.epodia.exception.IsSameUserException;
import org.epodia.exception.UserNotFoundException;
import org.springframework.beans.BeansException;

public interface MessageMetier {
		public Long establishChatSession(ChatChannelInitializationDTO chatChannelInitializationDTO)
				throws IsSameUserException, BeansException, UserNotFoundException;
		     // throws IsSameUserException, BeansException, UserNotFoundException;

		public  void submitMessage(Message message)
				throws BeansException, UserNotFoundException;
		     // throws BeansException, UserNotFoundException;
		  
		 public  Collection<Message> getExistingChatMessages(Long id);

}
