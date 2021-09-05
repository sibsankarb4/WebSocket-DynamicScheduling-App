package com.boot.ws.util;

public class Constant {

	private Constant() {
	}

	public static final String API_URL="http://localhost:8080/getMessage?";
	
	public static final String ANY = "Any";
	public static final char COMMA = ',';

	public static final int SUCCESS = 1;
	public static final int FAILED = -1;
	public static final int DUPLICATE = -2;
	public static final int NO_CONTENT = -3;
	public static final int ZERO = 0;

	public static final String SUCCESS_MSG = "SUCCESS";
	public static final String FAILED_MSG = "FAILURE";
	public static final String DUPLICATE_MSG = "DUPLICATE";
	public static final String NO_CONTENT_MSG = "NO_CONTENT";

	public static final String WEB_ACCESS_POINT = "Web";
	public static final String APP_ACCESS_POINT = "App";

	public static final String JAPAN = "Japan";

	public static final String CURRENTTIMELINE_STRING = "current";

	public static final String PREVIOUSTIMELINE_STRING = "previous";
	public static final boolean FALSE = false;
	public static final boolean TRUE = true;

	public static final String AUTHORIZATION_STRING = "Authorization";

	public static final String DATE_FORMAT = "dd/MM/yyyy";
	public static final String TIME_FORMAT = "HH:mm";

}
