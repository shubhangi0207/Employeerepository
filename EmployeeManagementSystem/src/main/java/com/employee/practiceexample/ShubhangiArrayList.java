package com.employee.practiceexample;

public class ShubhangiArrayList<T> {
	private int length = 0;
	private int index = 0;
	private Object[] objarr = {};

	public ShubhangiArrayList() {
		objarr = new Object[10];
	}

	public void add(T obj) {
		objarr[index] = obj;
		index++;
	}

	public int size() {

		return index;
	}

	public void remove(int index) {

		int[] arr = new int[10];
		int[] copyingIntoarr = new int[arr.length];

		for (int i = 0; i < arr.length; i++) {
			copyingIntoarr[i] = arr[i];
		}

	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < index; i++) {
			sb.append(objarr[i]);
			sb.append(",");
		}

		return "ShubhangiArrayList [" + sb.substring(0, sb.length() - 1) + "]";
	}

}
