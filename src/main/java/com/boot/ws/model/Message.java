package com.boot.ws.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public @Data @NoArgsConstructor @AllArgsConstructor @Builder class Message implements Serializable {

	private static final long serialVersionUID = 3555233828793095630L;

	private BigInteger id;

	private String code;

	private LocalDateTime createdDate;

	private String createUser;

	private String line;

	private String messageOne;

	private String messageTwo;

	private char textSize;

	private String textColor;

	private String backgroundColor;

	private String effect;

	private LocalDateTime displayFrom;

	private LocalDateTime displayUntil;

	private int refreshTime;

	private String status;

	private BigInteger priority;

	private boolean currentlyDisplayed;

	private LocalDateTime updatedOn;

	private String updatedBy;

	public int getRefreshTime() {
		return refreshTime;
	}

	public void setRefreshTime(int refreshTime) {
		this.refreshTime = refreshTime;
	}
	
	

}
