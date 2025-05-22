package com.thalyshenrique7.rabbitguard.utils;

public class StringUtils {

	public static String safeString(String value) {

		return value == null ? "" : value;
	}

	public static boolean isNotBlank(String value) {

		return value != null && !value.isBlank();
	}

	public static boolean isBlank(String value) {

		return value == null || value.isBlank();
	}
}
