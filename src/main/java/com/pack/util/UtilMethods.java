package com.pack.util;

import java.util.UUID;

public class UtilMethods {
	
	public static final String generateRandomeNumber() {
		
		return String.valueOf(Math.abs(UUID.randomUUID().getMostSignificantBits())).substring(0,11);
	}
}
