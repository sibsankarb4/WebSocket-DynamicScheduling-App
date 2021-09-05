package com.boot.ws.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude(Include.NON_NULL)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Status {
	private int statusCode;
	private String statusMessage;
	private String displayMessage;
	private String timeConsumed;
	private String updatedBy;
	private Date updatedDate;

}
