package org.epodia.services;

import java.security.Principal;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageRestController {

    @GetMapping("/api/messages")
    public List<String> getMessages(Principal principal) {
        // handle request
    	return null;
    }
}