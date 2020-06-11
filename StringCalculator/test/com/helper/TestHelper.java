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

}
