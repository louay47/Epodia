package org.epodia.services;


import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationController {

	 @SendTo("/topic/user.notification.{id}")
	  public String notifications(@PathVariable("id") long id, String message) {
	    return message;
	  }
	
}
