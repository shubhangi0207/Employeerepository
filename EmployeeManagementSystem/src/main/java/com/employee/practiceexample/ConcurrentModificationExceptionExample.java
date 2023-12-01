package com.employee.practiceexample;

import java.util.ArrayList;
import java.util.HashMap;

public class ConcurrentModificationExceptionExample extends Thread {
	static ArrayList<String> l = new ArrayList<>();

	@Override
	public void run() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
		}
		System.out.println("Child thread updating the list");
		l.add("d");
	}

	public static void main(String[] args) {
		HashMap<Integer, String> h = new HashMap<>();
		String h1 = h.put(100, "Krishna");
		System.out.println(h1);
		h.put(102, "Shubhangi");
		String oldValue = h.put(100, "Ravi");
		System.out.println(oldValue);

		System.out.println(h.toString());

	}
}
