package com.employee.practiceexample.DSAPrograms;

public class DivisibleBy6 {
	public static void main(String[] args) {
		String n = "363588395960667043875487";
		DivisibleBy6 d = new DivisibleBy6();
		if (d.divisibleBy6(n))
			System.out.println("Yes");
		else
			System.out.println("No");
	}

	private boolean divisibleBy6(String n) {
		// TODO Auto-generated method stub
		// 1. Check if last digit divisible by 2
		if (n.charAt(n.length() - 1) % 2 == 0)
			return true;

		// Check if addition of the digits are divisible by 3 or not
		int addDigit = 0;
		for (int i = 0; i < n.length(); i++) {
			addDigit = addDigit + n.charAt(i) - '0';
		}

		return (addDigit % 3 == 0);
	}
}
