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

	@DataProvider
	public Object[][] datainput() {

		int arrLength = TestHelper.getRandomNumber(1000) + 3, arr[] = new int[arrLength]; // Generates array length with
																							// range(3,1000)
		for (int i = 0; i < arrLength; i++) {
			arr[i] = TestHelper.getRandomNumber(10000);
		}

		String[] delimiters = { ",", "\n", "%" };
		String twoNumbers = TestHelper.toString(arr[0]).concat(",").concat(TestHelper.toString(arr[1]));

		Object[][] data = { { "", 0 }, { TestHelper.toString(arr[0]), arr[0] }, { twoNumbers, arr[0] + arr[1] },
				{ TestHelper.generateString(arr, Arrays.copyOfRange(delimiters, 0, 2)), TestHelper.getSum(arr) },
				{ TestHelper.getCustomDelimiterString(arr, Arrays.copyOfRange(delimiters, 2, 3)),
						TestHelper.getSum(arr) } };
		return data;
	}

}