package com.boot.ws.util;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class DateTimeUtil {
	
	private DateTimeUtil() {
	}

	public static final DateTimeFormatter DATE_FORMATTER_M_D = DateTimeFormatter.ofPattern("yyyy-M-d");
	public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	public static final ZoneId zoneId = ZoneId.of(Constant.JAPAN);

	public static String getCurrentDateInJapan() {
		return LocalDateTime.now(zoneId).toLocalDate().format(DATE_FORMATTER);
	}

	public static String getCurrentDateTimeInJapan() {
		return LocalDateTime.now(zoneId).format(DATE_TIME_FORMATTER);
	}

	public static String getCurrentDateTimeLessThanGivenMinutesInJapan(int minutesLess) {
		return LocalDateTime.now(zoneId).minusMinutes(minutesLess).format(DATE_TIME_FORMATTER);
	}

	public static long getHoursDiffBetweenUtcAndJst() {
		ZonedDateTime zoneIdNow = ZonedDateTime.now(zoneId);
		ZonedDateTime utcNow = zoneIdNow.toLocalDateTime().atZone(ZoneOffset.UTC);
		Duration durationBetweenZoneIdAndUtc = Duration.between(zoneIdNow, utcNow);
		return durationBetweenZoneIdAndUtc.getSeconds() / (60 * 60);
	}

	public static String convertFromJstToUtc(String jstDateTime) {
		return LocalDate.parse(jstDateTime, DATE_FORMATTER_M_D).atStartOfDay().minusHours(getHoursDiffBetweenUtcAndJst()).format(DATE_TIME_FORMATTER);
	}

	public static String convertFromJstToUtcPlusDay(String jstDateTime) {
		return LocalDate.parse(jstDateTime, DATE_FORMATTER_M_D).atStartOfDay().plusHours(24 - getHoursDiffBetweenUtcAndJst())
				.format(DATE_TIME_FORMATTER);
	}
	
	public static List<LocalDate> getDatesBetween(LocalDate startDate, LocalDate endDate) { 			  
	    long numOfDaysBetween = ChronoUnit.DAYS.between(startDate, endDate); 
	    return IntStream.iterate(0, i -> i + 1)
	      .limit(numOfDaysBetween)
	      .mapToObj(i -> startDate.plusDays(i))
	      .collect(Collectors.toList()); 
	}
	
	public static LocalDate getTodayInJapan() {
		return LocalDate.now(ZoneId.of(Constant.JAPAN));
	}
	
}
