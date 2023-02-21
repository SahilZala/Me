package com.pack.util;

import java.util.UUID;

public class UtilMethods {
	
	public static final String generateRandomeNumber() {
		return UUID.randomUUID().toString();
	}
}
