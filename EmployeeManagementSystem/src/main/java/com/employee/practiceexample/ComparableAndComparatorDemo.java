package com.employee.practiceexample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparableAndComparatorDemo {
	public static void main(String[] args) {
		/*
		 * EmployeeComparableAndComparator[] emp = new
		 * EmployeeComparableAndComparator[4];
		 * 
		 * emp[0] = new EmployeeComparableAndComparator(1, "Shubhangi", 30, 1390000);
		 * emp[1] = new EmployeeComparableAndComparator(4, "Vijay", 32, 139000); emp[2]
		 * = new EmployeeComparableAndComparator(3, "krishna", 30, 13900000); emp[3] =
		 * new EmployeeComparableAndComparator(2, "ABC", 30, 10000);
		 * 
		 * Arrays.sort(emp);
		 * 
		 * System.out.println("Default Natural sorting order :" + Arrays.toString(emp));
		 */

		List<EmployeeComparableAndComparator> l = new ArrayList<>();
		l.add(new EmployeeComparableAndComparator(1, "Shubhangi", 30, 1390000));
		l.add(new EmployeeComparableAndComparator(4, "Vijay", 32, 139000));
		l.add(new EmployeeComparableAndComparator(3, "krishna", 30, 13900000));
		l.add(new EmployeeComparableAndComparator(2, "ABC", 25, 10000));

		// Collections.sort(l);
		// System.out.println(l.toString());

		Comparator<EmployeeComparableAndComparator> c = new Comparator<>() {

			@Override
			public int compare(EmployeeComparableAndComparator o1, EmployeeComparableAndComparator o2) {
				// TODO Auto-generated method stub
				return o1.getAge() - o2.getAge();
			}

		};

		Comparator<EmployeeComparableAndComparator> c1 = new Comparator<>() {

			@Override
			public int compare(EmployeeComparableAndComparator o1, EmployeeComparableAndComparator o2) {
				// TODO Auto-generated method stub
				return (int) (o1.getSalary() - o2.getSalary());
			}

		};

		Collections.sort(l);
		System.out.println(l.toString());

		Collections.sort(l, c);
		System.out.println(l.toString());

		Collections.sort(l, c1);
		System.out.println(l.toString());

	}
}
