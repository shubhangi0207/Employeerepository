package com.employee.practiceexample;

public class RemoveSpacesFromString {
	public static void main(String[] args) {
		String s = "Shubhangi Gopichand Mali";

		RemoveSpacesFromString(s);
	}

	private static void RemoveSpacesFromString(String s) {
		// TODO Auto-generated method stub
		char[] charArray = s.toCharArray();
		StringBuilder sb = new StringBuilder();

		for (char c : charArray) {
			if (!Character.isWhitespace(c)) {
				sb.append(c);
			}
		}
		System.out.println(sb.toString());
	}
}
