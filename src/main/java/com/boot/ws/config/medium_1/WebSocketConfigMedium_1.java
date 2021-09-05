package com.boot.ws.config.medium_1;


import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.boot.ws.util.DateTimeUtil;


@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfigMedium_1 implements WebSocketMessageBrokerConfigurer {
	
	private static Logger logger = LogManager.getLogger(WebSocketConfigMedium_1.class);

	
 	@Override
 	public void configureMessageBroker(MessageBrokerRegistry config) {
 		logger.info("WebSocketConfig:{}:{}",
 				"configureMessageBroker()-->configuring websocket messagebroker for medium-1 ->",
 				DateTimeUtil.getCurrentDateInJapan());
 		config.enableSimpleBroker("/topic");
 		config.setApplicationDestinationPrefixes("/sibsankar-system-medium-1");
 	}
 
 	@Override
 	public void registerStompEndpoints(StompEndpointRegistry registry) {
 		logger.info("WebSocketConfig:{}:{}", "registerStompEndpoints()-->register end points for medium-1 ->",
 				DateTimeUtil.getCurrentDateInJapan());
 		registry.addEndpoint("/sibsankar-system").setAllowedOrigins("*");
 
 	}
 
 }
