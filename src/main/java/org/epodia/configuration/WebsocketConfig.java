package org.epodia.configuration;

import org.epodia.component.UserPresenceService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.security.config.annotation.web.messaging.MessageSecurityMetadataSourceRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebsocketConfig implements WebSocketMessageBrokerConfigurer {
	
	
	
	 @Override
	    public void configureMessageBroker(MessageBrokerRegistry config) {
	        config.enableSimpleBroker("/topic");
		   // config.enableStompBrokerRelay("/topic/", "/queue/");
	        config.setApplicationDestinationPrefixes("/app");
	    }

	    @Override
	    public void registerStompEndpoints(StompEndpointRegistry registry) {
	        // registry.addEndpoint("/gs-guide-websocket").withSockJS();
	    	registry.addEndpoint("/gs-guide-websocket").setAllowedOrigins("*").withSockJS();
	    }
	
	
	    @Bean
	    public UserPresenceService presenceChannelInterceptor() {
	      return new UserPresenceService();
	    }

	 /*   @Override
	    public void configureClientInboundChannel(ChannelRegistration registration) {
	      registration.setInterceptors(presenceChannelInterceptor());
	    }
	    
	    @Override
	    public void configureClientOutboundChannel(ChannelRegistration registration) {
	      registration.taskExecutor().corePoolSize(OUTBOUND_CHANNEL_CORE_POOL_SIZE);
	      registration.setInterceptors(presenceChannelInterceptor());
	    }*/
	    
	/*    protected void configureInbound(MessageSecurityMetadataSourceRegistry messages) {
	        messages.simpDestMatchers("/*").authenticated();
	      }*/
}
