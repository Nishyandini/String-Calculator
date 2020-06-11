package com.calculator.test;

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

		int num1 = TestHelper.getRandomNumber(100);
		int num2 = TestHelper.getRandomNumber(10000);

		String twoNumbers = TestHelper.toString(num1).concat(",").concat(TestHelper.toString(num2));

		Object[][] data = { { "", 0 }, { TestHelper.toString(num1), num1 }, { twoNumbers, num1 + num2 } };
		return data;
	}

}