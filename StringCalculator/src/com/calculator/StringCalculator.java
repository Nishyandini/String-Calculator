package com.calculator;

import java.util.regex.Matcher;

import com.helper.Helper;

public class StringCalculator {

	private static final String EMPTY_STRING_PATTERN = "^$";
	private static final String NUMBER_PATTERN = "\\d+";
	private static final String DELIMITER_WITHOUT_BRACKETS_PATTERN = "//(.*?)\\n";
	private static final String STARTS_WITH_NEG_NUM_PATTERN = "-\\d+";
	private static final String DELIMITER_WITH_BRACKET_PATTERN = "//(\\[(.*?)\\]+)\\n";

	public int add(String numbers) throws Exception {

		Matcher match = null;

		/* Below block of code returns 0 if input string is empty. */
		match = Helper.getMatcher(EMPTY_STRING_PATTERN, numbers);
		if (match.matches())
			return 0;

		/*
		 * Below block of code checks if the input string has only one number or set of
		 * numbers separated by commas or newline and returns the number or sum of the
		 * number respectively. Throws exception if any one of the number is negative.
		 */
		match = Helper.getMatcher(NUMBER_PATTERN, numbers);
		if (match.matches()) {
			return Helper.toInteger(numbers);
		} else if (match.lookingAt()) {
			int numberArr[] = Helper.toIntArray(numbers.split("[,\n]"));
			Helper.checkForNegativeNumbers(numberArr);
			return Helper.getSumOfNosLessThan1001(numberArr);
		}

		/*
		 * Below block of code checks if the input has custom delimiter of any length
		 * along with numbers. Splits numbers by custom delimiter and returns their sum.
		 * Throws exception if any one of the number is negative.
		 */
		match = Helper.getMatcher(DELIMITER_WITH_BRACKET_PATTERN, numbers);
		if (match.lookingAt())
			return getCustomDelimiterPatternSum(match, numbers, DELIMITER_WITH_BRACKET_PATTERN);

		/*
		 * Below block of checks checks if the input string has a custom delimiter along
		 * with numbers. Splits numbers by custom delimiter and return their sum. Throws
		 * exception if any one of the number is negative.
		 */
		match = Helper.getMatcher(DELIMITER_WITHOUT_BRACKETS_PATTERN, numbers);
		if (match.lookingAt()) {
			return getCustomDelimiterPatternSum(match, numbers, DELIMITER_WITHOUT_BRACKETS_PATTERN);
		}

		/*
		 * Below block of code throws custom exception if the string starts with a
		 * negative number.
		 */
		match = Helper.getMatcher(STARTS_WITH_NEG_NUM_PATTERN, numbers);
		if (match.matches()) { 
			Helper.throwNegativeNumException(numbers); 
		} else if (match.lookingAt()) { 
			int numberArr[] = Helper.toIntArray(numbers.split("[,\n]"));
			Helper.checkForNegativeNumbers(numberArr);
		}

		return -1;
	}

	private int getCustomDelimiterPatternSum(Matcher match, String numbers, String pattern) throws Exception {
		/*
		 * Inorder to handle delimiters which have a special meaning in regex,
		 * delimiters are enclosed with escape sequence
		 */
		String delimiter = Helper.encloseWithEscapeSequence(match.group(1));
		String replaced = numbers.replaceAll(pattern, "");
		int numArr[] = Helper.toIntArray(replaced.split(delimiter));
		Helper.checkForNegativeNumbers(numArr);
		return Helper.getSumOfNosLessThan1001(numArr);

	}

}
