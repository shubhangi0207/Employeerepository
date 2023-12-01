package com.employee.practiceexample;

import java.util.ArrayList;
import java.util.Collections;

public class SecondHighestSalaryOfEmployee {
	public static void main(String[] args) {

		ArrayList<Employee> list = new ArrayList<>();

		list.add(new Employee(3000, "bunny", 1));
		list.add(new Employee(1000, "munny", 1));
		list.add(new Employee(5000, "rekha", 1));
		list.add(new Employee(23000, "Sunny", 1));

		System.out.println(list);

		Collections.sort(list,
				(e1, e2) -> (e1.getSalary() > e2.getSalary()) ? -1 : (e1.getSalary() < e2.getSalary()) ? 1 : 0);

		System.out.println("Second hightest salary is :" + list.get(1));

	}

}