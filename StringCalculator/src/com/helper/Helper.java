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

	public static int getSumOfNosLessThan1001(int[] numbers) {
		int total = 0;
		for (int number : numbers) {
			if(number <= 1000)
				total = total + number;
		}
		return total;
	}

	public static String encloseWithEscapeSequence(String delimiter) {
		return "\\Q" + delimiter + "\\E";
	}
	
	public static void throwNegativeNumException(String negativeNumbers) throws Exception {
		throw new Exception("\"negatives not allowed-\"" + negativeNumbers);
	}
	
	public static void checkForNegativeNumbers(int arr[]) throws Exception {
		String negativeValues = "";
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < 0) {
				negativeValues = negativeValues + arr[i] + " ";
			}
		}
		if (negativeValues != "") {
			throwNegativeNumException(negativeValues);
		}
	}

}
