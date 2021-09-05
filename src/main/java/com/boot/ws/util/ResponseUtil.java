package com.boot.ws.util;

import java.util.Date;

import org.springframework.http.HttpStatus;

import com.boot.ws.model.Response;
import com.boot.ws.model.Status;

public interface ResponseUtil {

	public static Response getResponse(Object obj) {
		return Response.builder().responseObj(obj).build();
	}

	public static Status getStatus(int statusCode) {

		return statusCode > Constant.ZERO
				? Status.builder().statusCode(Constant.SUCCESS).statusMessage(Constant.SUCCESS_MSG).build()
				: statusCode == Constant.DUPLICATE
						? Status.builder().statusCode(Constant.DUPLICATE).statusMessage(Constant.DUPLICATE_MSG).build()
						: Status.builder().statusCode(Constant.FAILED).statusMessage(Constant.FAILED_MSG).build();
	}

	public static Response getResponse(Object obj, int statusCode, String statusMsg, String displayMsg,
			long startTime) {
		return Response.builder().responseObj(obj).status(getStatus(statusCode, statusMsg, displayMsg, startTime))
				.build();
	}

	public static Response getResponse(Object obj, long startTime) {
		return Response.builder().responseObj(obj)
				.status(getStatus(Constant.SUCCESS, Constant.SUCCESS_MSG, null, startTime)).httpStatus(HttpStatus.OK)
				.build();
	}

	public static Response getResponse(long startTime) {
		return Response.builder().responseObj(null)
				.status(getStatus(Constant.SUCCESS, Constant.SUCCESS_MSG, null, startTime)).httpStatus(HttpStatus.OK)
				.build();
	}

	public static Status getStatus(int statusCode, String statusMsg, String displayMsg, long startTime) {
		return Status.builder().statusCode(statusCode).statusMessage(statusMsg).displayMessage(displayMsg)
				.timeConsumed((System.currentTimeMillis() - startTime) + " millisecond(s)").build();
	}

	public static Response getResponse(int statusCode, String statusMsg, String displayMsg, long startTime) {
		return Response.builder().responseObj(null).status(getStatus(statusCode, statusMsg, displayMsg, startTime))
				.build();
	}

	public static Status getStatus(int statusCode, String statusMsg, String displayMsg) {
		return Status.builder().statusCode(statusCode).statusMessage(statusMsg).displayMessage(displayMsg).build();
	}

	public static Response getResponse(int statusCode, String statusMsg, String displayMsg) {
		return Response.builder().responseObj(null).status(getStatus(statusCode, statusMsg, displayMsg)).build();
	}

	public static Response getResponse(long startTime, String updatedBy, Date updatedDate) {
		return Response.builder().responseObj(null)
				.status(getStatus(Constant.SUCCESS, Constant.SUCCESS_MSG, null, startTime, updatedBy, updatedDate))
				.build();
	}

	public static Status getStatus(int statusCode, String statusMsg, String displayMsg, long startTime,
			String updatedBy, Date updatedDate) {

		return Status.builder().statusCode(statusCode).statusMessage(statusMsg).displayMessage(displayMsg)
				.updatedBy(updatedBy).updatedDate(updatedDate)
				.timeConsumed((System.currentTimeMillis() - startTime) + " millisecond(s)").build();

	}

}
