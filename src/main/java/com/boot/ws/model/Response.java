package com.boot.ws.model;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public @JsonInclude(Include.NON_NULL) @Data @NoArgsConstructor @AllArgsConstructor @Builder class Response {
	private Object responseObj;
	private Status status;
	private HttpStatus httpStatus;
	
	
	public Object getResponseObj() {
		return responseObj;
	}
	public void setResponseObj(Object responseObj) {
		this.responseObj = responseObj;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}	
}
