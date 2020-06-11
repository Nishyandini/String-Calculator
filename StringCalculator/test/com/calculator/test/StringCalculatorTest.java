package com.calculator.test;

import org.testng.annotations.BeforeClass;
import com.calculator.StringCalculator;

public class StringCalculatorTest {

	private StringCalculator calculator;

	@BeforeClass
	public void BeforeClass() {
		calculator = new StringCalculator();
	}

}
