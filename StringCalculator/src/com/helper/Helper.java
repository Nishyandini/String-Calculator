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

	public static int[] toIntArray(String[] array) {
		int[] intArray = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			intArray[i] = toInteger(array[i]);
		}
		return intArray;
	}

	public static int getTotalSum(int[] numbers) {
		int total = 0;
		for (int number : numbers) {
			total = total + number;
		}
		return total;
	}

	public static String encloseWithEscapeSequence(String delimiter) {
		return "\\Q" + delimiter + "\\E";
	}

}
