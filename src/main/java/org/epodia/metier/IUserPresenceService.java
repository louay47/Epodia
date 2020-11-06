package org.epodia.metier;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;

public interface IUserPresenceService {
	
	void postSend(Message<?> message, MessageChannel channel, boolean sent);

}
