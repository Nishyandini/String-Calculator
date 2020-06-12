package com.calculator.test;

import java.util.Arrays;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.calculator.StringCalculator;
import com.helper.TestHelper;

public class StringCalculatorTest {

	private StringCalculator calculator;

	@BeforeClass
	public void BeforeClass() {
		calculator = new StringCalculator();
	}

	@Test(dataProvider = "datainput")
	public void testAdd(String actual, int expected) throws Exception {
		Assert.assertEquals(calculator.add(actual), expected);
	}

	@Test(dataProvider = "dataInputNegativeNumbers", expectedExceptions = Exception.class, expectedExceptionsMessageRegExp = "\"negatives not allowed-\".*")
	public void testAddWithNegativeNumber(String input) throws Exception {
		calculator.add(input);
	}

	@DataProvider
	public Object[][] datainput() {

		int arrLength = TestHelper.getRandomNumber(1000) + 3, arr[] = new int[arrLength]; // Generates array length with
																							// range(3,1000)
		for (int i = 0; i < arrLength; i++) {
			arr[i] = TestHelper.getRandomNumber(10000);
		}

		String[] delimiters = { ",", "\n", "%", "***@#%", "***", "&" , "!!!" };
		String twoNumbers = TestHelper.toString(arr[0]).concat(",").concat(TestHelper.toString(arr[1]));

		Object[][] data = { { "", 0 }, { TestHelper.toString(arr[0]), arr[0] },
				{ twoNumbers, TestHelper.getSumOfNosLessThan1001(Arrays.copyOfRange(arr, 0, 2)) },
				{ TestHelper.generateString(arr, Arrays.copyOfRange(delimiters, 0, 2)),
						TestHelper.getSumOfNosLessThan1001(arr) },
				{ TestHelper.getCustomDelimiterString(arr, Arrays.copyOfRange(delimiters, 2, 3), false),
						TestHelper.getSumOfNosLessThan1001(arr) },
				{ TestHelper.getCustomDelimiterString(arr, Arrays.copyOfRange(delimiters, 3, 4), false),
						TestHelper.getSumOfNosLessThan1001(arr) },
				{ TestHelper.getCustomDelimiterString(arr, Arrays.copyOfRange(delimiters, 2, 7), true),
						TestHelper.getSumOfNosLessThan1001(arr) } };
		return data;
	}

	@DataProvider
	public Object[] dataInputNegativeNumbers() {

		int randomNegNo = TestHelper.getRandomNumber(100) - 10000; // generating negative number

		String oneNegNo = TestHelper.toString(randomNegNo);
		String multipleNegNos = TestHelper.toString(randomNegNo);
		for (int i = 1; i < TestHelper.getRandomNumber(10) + 3; i++) {
			multipleNegNos = multipleNegNos.concat(",")
					.concat(TestHelper.toString(TestHelper.getRandomNumber(100) - 10000));
		}

		String posAndNegNos = TestHelper.toString(TestHelper.getRandomNumber(100));
		for (int i = 1; i < TestHelper.getRandomNumber(10) + 3; i++) {
			posAndNegNos = posAndNegNos.concat(",").concat(TestHelper.toString(TestHelper.getRandomNumber(1000)))
					.concat(",").concat(TestHelper.toString(TestHelper.getRandomNumber(100) - 10000));
		}

		Object[] data = { oneNegNo, multipleNegNos, posAndNegNos };
		return data;
	}

}