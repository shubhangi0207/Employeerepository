package com.employee.practiceexample;

public class SubStringAndRotateWindow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "dsasfdsafssa";
		// Iterate and print
		// ds
		// sa
		// as
		// dsa
		// sa3
		int windowLength = 2;

		for (int i = 0; i <= s.length() - 2; i++) {
			Integer startIndex = 0;

			printWindows(s, windowLength, startIndex);

			windowLength++;
		}

	}

	private static void printWindows(String s, int windowLength, Integer startIndex) {
		// TODO Auto-generated method stub
//		for (int i = 0; i < s.length(); i++) {
		while (windowLength + startIndex <= s.length()) {
			String s1 = s.substring(startIndex, windowLength + startIndex);
			System.out.println(s1);
			startIndex++;
		}

	}
//	}

}
