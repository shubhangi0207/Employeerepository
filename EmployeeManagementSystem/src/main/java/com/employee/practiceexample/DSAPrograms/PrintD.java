package com.employee.practiceexample.DSAPrograms;

public class PrintD {

	public static void main(String[] args) {
		String N = "1234";

		for (int i = 0; i < N.length(); i++) {
			printDigit(N.charAt(i));
		}
	}

	public static void printDigit(char digit) {
		switch (digit) {

		case '0':
			System.out.print("Zero ");
			break;

		case '1':
			System.out.print("One ");
			break;

		case '2':
			System.out.print("Two ");
			break;

		case '3':
			System.out.print("Three ");
			break;

		case '4':
			System.out.print("Four ");
			break;

		case '5':
			System.out.print("Five ");
			break;

		case '6':
			System.out.print("Six ");
			break;

		case '7':
			System.out.print("Seven ");
			break;

		case '8':
			System.out.print("Eigth ");
			break;

		case '9':
			System.out.print("Nine ");
			break;

		}

	}

}
