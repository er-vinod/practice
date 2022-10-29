package com.restapiexample.utility;

import org.apache.commons.lang3.RandomStringUtils;

public class RestUtils {

	public static String empName() {
		String generatedString = RandomStringUtils.randomAlphabetic(1);
		return ("vinod" + generatedString);
	}

	public static String empSal() {
		String generatedNum = RandomStringUtils.randomNumeric(5);
		return generatedNum;
	}

	public static String empAge() {
		String generatedNum = RandomStringUtils.randomNumeric(2);
		return generatedNum;
	}
}
