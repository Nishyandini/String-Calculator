package com.helper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Helper {

	public static Matcher getMatcher(String patternStr, String compareStr) {
		Pattern pattern = Pattern.compile(patternStr);
		Matcher match = pattern.matcher(compareStr);
		return match;
	}

	public static int toInteger(String str) {
		return Integer.parseInt(str);
	}

}
