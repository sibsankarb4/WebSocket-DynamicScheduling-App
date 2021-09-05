package com.boot.ws.config;

//keeping this for future testing purpose in local

/*import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;


@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

	private static Logger logger = LogManager.getLogger(WebSocketConfig.class);

	@Override
	public void configureMessageBroker(MessageBrokerRegistry config) {
		logger.info("WebSocketConfig:{}:{}", "configureMessageBroker()-->configuring websocket messagebroker->",
				DateTimeUtil.getCurrentDateInJapan());
		config.enableSimpleBroker("/topic");
		config.setApplicationDestinationPrefixes("/sibsankarSystem");
	}

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		logger.info("WebSocketConfig:{}:{}", "registerStompEndpoints()-->register end points->",
				DateTimeUtil.getCurrentDateInJapan());
		registry.addEndpoint("/sibsankarSystemWS").setAllowedOrigins("*");

	}

}*/
