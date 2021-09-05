package com.boot.ws.config;

//keeping this for future testing purpose locally

/*import java.lang.reflect.Type;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter;

import com.boot.ws.model.Response;
public class MyStompSessionHandler extends StompSessionHandlerAdapter {

	private static final Logger logger = LoggerFactory.getLogger(MyStompSessionHandler.class);

	private Response response;

	public Response getResponse() {
		return response;
	}

	public void setResponse(Response response) {
		this.response = response;
	}

	public MyStompSessionHandler() {
		super();
	}

	public MyStompSessionHandler(Response response) {
		super();
		this.response = response;
	}

	@Override
	public void afterConnected(StompSession session, StompHeaders connectedHeaders) {

		logger.info("New session established : " + session.getSessionId());

		session.subscribe("/topic/sibsankar-system", this);
		logger.info("Subscribed to /topic/sibsankar-system");
		session.send("/topic/sibsankar-system", getResponse());

		logger.info("Message sent to websocket server => /topic/sibsankar-system");
	}

	@Override
	public void handleException(StompSession session, StompCommand command, StompHeaders headers, byte[] payload,
			Throwable exception) {
		logger.error("Got an exception", exception);
	}

	@Override
	public Type getPayloadType(StompHeaders headers) {
		return Response.class;
	}

	@Override
	public void handleFrame(StompHeaders headers, Object payload) {
		logger.info("Received: {} ", payload);
	}

}*/
