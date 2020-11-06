package org.epodia.controller;

import java.util.Collection;

import org.epodia.dao.UserRepository;
import org.epodia.dto.ChatChannelInitializationDTO;
import org.epodia.dto.EstablishedChatChannelDTO;
import org.epodia.entities.Message;
import org.epodia.entities.User;
import org.epodia.exception.IsSameUserException;
import org.epodia.exception.UserNotFoundException;
import org.epodia.http.JSONResponseHelper;
import org.epodia.metier.ConversationMetier;
import org.epodia.metier.MessageMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/api/v1")
public class ConversationController implements ConversationMetier {

	@Autowired
	  private MessageMetier messageMetier;
	
	@Autowired
	private UserRepository userRepository ;
	

	@MessageMapping("/private/chat/{id_conv}")
	@SendTo("/topic/private/chat/{id_conv}")
	public Message chatMessage(@PathVariable("id_conv") Long id, Message message) {
		
		messageMetier.submitMessage(message);
		
		return message ;
	}

	@RequestMapping(value="/api/private-chat/channel", method=RequestMethod.PUT)
    public ResponseEntity<String> establishChatChannel(@RequestBody ChatChannelInitializationDTO chatChannelInitialization) 
        throws IsSameUserException, UserNotFoundException { 
      Long id = messageMetier.establishChatSession(chatChannelInitialization);
      User userOne = userRepository.getOne(chatChannelInitialization.getUserIdOne());
      User userTwo = userRepository.getOne(chatChannelInitialization.getUserIdTwo());

      EstablishedChatChannelDTO establishedChatChannel = new EstablishedChatChannelDTO(
    	id,
        userOne.getUsername(),
        userTwo.getUsername()
      );
    
      return JSONResponseHelper.createResponse(establishedChatChannel, HttpStatus.OK);
      
	}
    

	@RequestMapping(value="/api/private-chat/channel/{id}", method=RequestMethod.GET)
	public ResponseEntity<String> getExistingChatMessages(Long id) {
		
		 Collection<Message> messages = messageMetier.getExistingChatMessages(id);
		
		return JSONResponseHelper.createResponse(messages, HttpStatus.OK);
	}

}
