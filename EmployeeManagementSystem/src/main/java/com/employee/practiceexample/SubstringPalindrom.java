package com.employee.practiceexample;

public class SubstringPalindrom {

	public static void main(String[] args) {
		String s = "babbabdad";
		Integer windowLength = 2;
		for (int i = 0; i <= s.length() - 2; i++) {

			Integer startIndex = 0;

			recursiveFOrSubString(s, windowLength, startIndex);
			windowLength++;
		}
	}

	private static void recursiveFOrSubString(String s, Integer windowLength, Integer startIndex) {

		while (startIndex + windowLength <= s.length()) {
			String subString = s.substring(startIndex, startIndex + windowLength);
			if (checkForPalindrome(subString)) {
				System.out.println(subString);
			}
			startIndex++;
		}

	}

	private static boolean checkForPalindrome(String subString) {
		// TODO Auto-generated method stub
		return subString.equals(new StringBuffer(subString).reverse().toString());
	}

}
