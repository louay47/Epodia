package org.epodia.metier;

import java.util.ArrayList;
import java.util.Collection;



import org.epodia.dao.ConversationRepository;
import org.epodia.dao.MessageRepository;
import org.epodia.dto.ChatChannelInitializationDTO;

import org.epodia.entities.Conversation;
import org.epodia.entities.Message;

import org.epodia.exception.IsSameUserException;
import org.epodia.exception.UserNotFoundException;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class MessageMetierImpl implements MessageMetier{

	
	  @Autowired
	  private ConversationRepository conversationRepository;

	  @Autowired
	  private MessageRepository messageRepository;

	  @Autowired
	  private UserMetier userMetier ;
	  

	
	  
	  private Long getExistingChannel(ChatChannelInitializationDTO chatChannelInitializationDTO) {
		    Collection<Conversation> channel = conversationRepository
		      .findExistingChannel(
		        chatChannelInitializationDTO.getUserIdOne(),
		        chatChannelInitializationDTO.getUserIdTwo()
		      );
		    ArrayList<Conversation> channelArrayList = new ArrayList<Conversation>(channel);
		    return (channel != null && !channel.isEmpty()) ? channelArrayList.get(0).getId_conv() : null;
		  }
	
	  private Long newChatSession(ChatChannelInitializationDTO chatChannelInitializationDTO) {
		     // throws BeansException, UserNotFoundException {
		      Conversation channel = new Conversation(
		      userMetier.GetUserById(chatChannelInitializationDTO.getUserIdOne()),
		      userMetier.GetUserById(chatChannelInitializationDTO.getUserIdTwo())
		    );
		    
		      conversationRepository.save(channel);

		    return channel.getId_conv();
		  }
	  
	@Override
	public Long establishChatSession(ChatChannelInitializationDTO chatChannelInitializationDTO) 
		 throws IsSameUserException, BeansException, UserNotFoundException {
			    if (chatChannelInitializationDTO.getUserIdOne() == chatChannelInitializationDTO.getUserIdTwo()) {
			      throw new IsSameUserException();
			    }

			   Long id_conv = getExistingChannel(chatChannelInitializationDTO);

			    // If channel doesn't already exist, create a new one
			    return (id_conv != null) ? id_conv : newChatSession(chatChannelInitializationDTO);
			  }
	@Override
	public void submitMessage(Message message) throws BeansException, UserNotFoundException {
	  //  Message message = ChatMessageMapper.mapChatDTOtoMessage(chatMessageDTO);

	    messageRepository.save(message);

/*	    User fromUser = userMetier.GetUserById(message.getUser1().getId_user());
	    User recipientUser = userMetier.GetUserById(message.getUser2().getId_user());
	      
	    userMetier.notifyUser(recipientUser,
	      new NotificationDTO(
	        "ChatMessageNotification",
	        fromUser.getLogin() + " has sent you a message",
	        message.getUser1().getId_user()
	      )
	    );*/
	  }
		
	
	
	@Override
	public Collection<Message> getExistingChatMessages(Long id) {
		 Conversation conversation = conversationRepository.getOne(id);

		   Collection<Message> chatMessages = 
		      messageRepository.getExistingChatMessages(
		    	conversation.getUser1().getId(),
		    	conversation.getUser2().getId()
		        )
		      ;

		    // TODO: fix this
		   // List<Message> messagesByLatest = Lists.reverse(chatMessages); 

		    //return ChatMessageMapper.mapMessagesToChatDTOs(messagesByLatest);
		   return chatMessages ;
		  
	}
	
	

}
