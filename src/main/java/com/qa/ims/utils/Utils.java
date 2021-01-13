package com.qa.ims.utils;

import java.math.BigDecimal;
import java.util.Scanner;

public class Utils {
	
	private Utils () {
		
	}

	public static String getInput() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}
	public static BigDecimal getBigdecimalInput() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		return scanner.nextBigDecimal();
	}
	public static Long getLongInput() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLong();
	}

}
