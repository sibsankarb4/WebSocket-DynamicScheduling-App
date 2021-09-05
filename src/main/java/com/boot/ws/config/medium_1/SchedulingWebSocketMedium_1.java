package com.boot.ws.config.medium_1;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.boot.ws.model.Message;
import com.boot.ws.model.Response;
import com.boot.ws.util.Constant;
import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
@EnableScheduling
@Component
public class SchedulingWebSocketMedium_1 implements SchedulingConfigurer {

	private static Logger logger = LogManager.getLogger(SchedulingWebSocketMedium_1.class);
	
	@Autowired
	private SimpMessagingTemplate simpMessagingTemplate;

	int refreshTime;

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {

		Runnable runnable = () -> {

			HttpHeaders requestHeaders = new HttpHeaders();
			requestHeaders.add("Accept", MediaType.APPLICATION_JSON_VALUE);
			HttpEntity<Void> requestEntity = new HttpEntity<>(requestHeaders);
			ResponseEntity<Response> response = restTemplate.exchange(Constant.API_URL + "name=medium-1",
					HttpMethod.GET, requestEntity, Response.class);
			if (response.getBody() != null) {
				Response res = response.getBody();
				logger.info("API Response for medium-1 =====> " + res + ", status : " + res.getStatus()
						+ ", HTTP Status: " + res.getHttpStatus());

				ObjectMapper objectMapper = new ObjectMapper();
				Message msg = objectMapper.convertValue(res.getResponseObj(), Message.class);

				setRefreshTime(msg != null ? msg.getRefreshTime() : 30);

				simpMessagingTemplate.convertAndSend("/topic/sibsankar-system-medium-1", response);
			}
		};

		Trigger trigger = triggerContext -> {

			Calendar nextExecutionTime = new GregorianCalendar();
			Date lastActualExecutionTime = triggerContext.lastActualExecutionTime();
			nextExecutionTime.setTime(lastActualExecutionTime != null ? lastActualExecutionTime : new Date());
			nextExecutionTime.add(Calendar.MILLISECOND, getRefreshTime());
			return nextExecutionTime.getTime();
		};

		taskRegistrar.addTriggerTask(runnable, trigger);
	}

	private int getRefreshTime() {
		return refreshTime;
	}

	private void setRefreshTime(int refreshTime) {
		this.refreshTime = refreshTime;
	}

}