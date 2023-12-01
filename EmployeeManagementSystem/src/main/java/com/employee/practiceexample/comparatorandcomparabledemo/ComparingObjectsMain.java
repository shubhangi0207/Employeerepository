package com.employee.practiceexample.comparatorandcomparabledemo;

import java.util.ArrayList;

public class ComparingObjectsMain {
	public static void main(String[] args) {
		ArrayList<Students> al = new ArrayList<>();
		al.add(new Students(1, "Shubhangi", 30));
		al.add(new Students(3, "kirti", 31));
		al.add(new Students(2, "Kajal", 29));
		al.add(new Students(13, "kavita", 32));
		al.add(new Students(4, "Sanju", 28));
		al.add(new Students(5, "neha", 2));

		System.out.println(al);

	}
}
