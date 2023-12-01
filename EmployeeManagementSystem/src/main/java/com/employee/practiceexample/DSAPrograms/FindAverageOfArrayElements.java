package com.employee.practiceexample.DSAPrograms;

public class FindAverageOfArrayElements {
	public static void main(String[] args) {
		int arr[] = { 5, 3, 6, 7, 5, 3 };

		System.out.println(FindAverageOfArrayElements(arr));
	}

	private static double FindAverageOfArrayElements(int arr[]) {

		int add = 0;
		double avg = 0;
		for (int i = 0; i < arr.length; i++) {
			add = add + arr[i];
		}
		return (double) add / arr.length;

	}
}
