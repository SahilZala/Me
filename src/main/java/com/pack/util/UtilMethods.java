package com.pack.util;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

public class UtilMethods {
	
	public static final String generateRandomeNumber() {
		
		return String.valueOf(Math.abs(UUID.randomUUID().getMostSignificantBits())).substring(0,11);
	}
	
	public static final String getCurrentDate() {
		return LocalDate.now().toString();
	}
	
	public static final String getCurrentTime()
	{
		return LocalTime.now().toString();
	}
	
}
