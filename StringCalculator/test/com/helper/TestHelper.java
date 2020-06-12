package com.helper;

import java.util.Random;

public class TestHelper {

	public static int getRandomNumber(int range) {
		Random random = new Random();
		return random.nextInt(range);
	}

	public static String toString(int value) {
		return Integer.toString(value);
	}
	
	public static String generateString(int arr[], String[] delimiters) {
		StringBuilder result = new StringBuilder("");
		for (int i = 0; i < arr.length - 1; i++) {
			result = result.append(arr[i]).append(delimiters[i % delimiters.length]);
		}
		result.append(arr[arr.length - 1]);
		return result.toString();
	}
	
	public static int getSumOfNosLessThan1001(int arr[]) {
		int total = 0;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] <= 1000) // number greater than 1000 is ignored
				total = total + arr[i];
		}	
		return total;
	}
	
	public static String getCustomDelimiterString(int arr[], String[] delimiters) {
		String startString = "//", endString = "" + "\n" + generateString(arr, delimiters);
		return new StringBuilder().append(startString).append(delimiters[0]).append(endString).toString();
	}

}
