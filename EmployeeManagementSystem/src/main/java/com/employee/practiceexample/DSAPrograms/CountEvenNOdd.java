package com.employee.practiceexample.DSAPrograms;

public class CountEvenNOdd {

	public static void countOfEvenOddElements(int arr[], int countOdd, int countEven) {

		for (int i = 0; i < arr.length; i++) {
			if ((arr[i] & 1) == 1) {
				countOdd++;
			} else {
				countEven++;
			}
		}

		System.out.println("Number of even elements = " + countEven);
		System.out.println("Number of odd elements = " + countOdd);

	}

	public static void main(String[] args) {

		int arr[] = { 2, 3, 4, 5, 6 };
		int countOdd = 0, countEven = 0;

		countOfEvenOddElements(arr, countOdd, countEven);
	}

}
