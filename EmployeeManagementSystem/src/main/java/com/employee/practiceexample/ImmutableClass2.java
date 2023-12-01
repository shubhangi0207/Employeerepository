package com.employee.practiceexample;

import java.util.Map;

public final class ImmutableClass2 {
	private final int rollNo;
	private final String name;
	private final Map<String, String> a;

	private ImmutableClass2(int rollNo, String name, Map<String, String> a) {
		this.rollNo = rollNo;
		this.name = name;
		this.a = a;
	}

	public int getRollNo() {
		return rollNo;
	}

	public String getName() {
		return name;
	}

	public Map<String, String> getA() {
		return a;
	}

}
