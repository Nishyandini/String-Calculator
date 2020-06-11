package com.calculator;

import java.util.regex.Matcher;

import com.helper.Helper;

public class StringCalculator {

	private static final String EMPTY_STRING_PATTERN = "^$";
	private static final String NUMBER_PATTERN = "\\d+";

	public int add(String numbers) {

		Matcher match = null;

		// Below block of code returns 0 if input string is empty.
		match = Helper.getMatcher(EMPTY_STRING_PATTERN, numbers);
		if (match.matches())
			return 0;

		// Below block of code checks if the input string has only one number or set of
		// numbers separated by commas and returns the number or sum of the number
		// respectively.
		match = Helper.getMatcher(NUMBER_PATTERN, numbers);
		if (match.matches()) {
			return Helper.toInteger(numbers);
		} else if (match.lookingAt()) {
			int numberArr[] = Helper.toIntArray(numbers.split(","));
			return Helper.getTotalSum(numberArr);
		}

		return -1;
	}

}
