package com.boot.ws.config;

//keeping this for future testing purpose locally

/*import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.stomp.StompSessionHandler;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.boot.ws.model.Response;
import lombok.extern.slf4j.Slf4j;

@Configuration
@EnableScheduling
@Component
@Slf4j
public class SchedulingWebSocket implements SchedulingConfigurer {

	@Value("${websocket_listener_url}")
	private String webSocketUrl;

	@Autowired
	private SimpMessagingTemplate simpMessagingTemplate;

	@Autowired
	private RestTemplate restTemplate;

	int refreshTime;

	@Override
	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {

		taskRegistrar.addTriggerTask(new Runnable() {

			@Override
			public void run() {

				HttpHeaders requestHeaders = new HttpHeaders();
				requestHeaders.add("Accept", MediaType.APPLICATION_JSON_VALUE);
				HttpEntity<Void> requestEntity = new HttpEntity<>(requestHeaders);
				ResponseEntity<Response> response = restTemplate.exchange(Constant.API_URL + "name=medium-1",
						HttpMethod.GET, requestEntity, Response.class);

				if (response.getBody() != null) {
					Response res = response.getBody();
					log.info("API Response Testing for medium-1 =====> " + res + ", status : " + res.getStatus()
							+ ", HTTP Status: " + res.getHttpStatus());

					ObjectMapper objectMapper = new ObjectMapper();
					Message msg = objectMapper.convertValue(res.getResponseObj(), Message.class);
					setRefreshTime(msg != null ? msg.getRefreshTime() : 30);
					log.info("API Response, refreshTime medium-1 => " + msg.getRefreshTime());

					simpMessagingTemplate.convertAndSend("/topic/sibsankar-system", response);

					// consuming it
					webSocketListener(res);
				}
			}

			// Websocket message send/subscribe/listening purpose
			private void webSocketListener(Response response) {
				WebSocketClient client = new StandardWebSocketClient();

				WebSocketStompClient stompClient = new WebSocketStompClient(client);
				stompClient.setMessageConverter(new MappingJackson2MessageConverter());

				StompSessionHandler sessionHandler = new MyStompSessionHandler(response);
				stompClient.connect(webSocketUrl, sessionHandler);

			}

		}, new Trigger() {

			@Override
			public Date nextExecutionTime(TriggerContext triggerContext) {

				Calendar nextExecutionTime = new GregorianCalendar();
				Date lastActualExecutionTime = triggerContext.lastActualExecutionTime();

				nextExecutionTime.setTime(lastActualExecutionTime != null ? lastActualExecutionTime : new Date());
				nextExecutionTime.add(Calendar.SECOND, getRefreshTime());
				log.info("next Execution Time or Refresh Time :  " + nextExecutionTime.getTime());
				return nextExecutionTime.getTime();
			}
		});
	}

	private int getRefreshTime() {
		return refreshTime;
	}

	private void setRefreshTime(int refreshTime) {
		this.refreshTime = refreshTime;
	}

}*/ 
