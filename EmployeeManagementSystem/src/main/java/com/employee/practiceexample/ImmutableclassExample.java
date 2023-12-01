package com.employee.practiceexample;

import java.util.HashMap;
import java.util.Map;

final class ImmutableclassExample {
	private final String name;
	private final Map<String, String> map;
	private final int rollNo;

	ImmutableclassExample(String name, Map<String, String> map, int rollNo) {
		this.name = name;
		this.rollNo = rollNo;

		Map<String, String> tempMap = new HashMap<>();

		for (Map.Entry<String, String> entry : map.entrySet()) {
			tempMap.put(entry.getKey(), entry.getValue());
		}

		this.map = tempMap;
	}

	public String getName() {
		return name;
	}

	public int getRollNo() {
		return rollNo;
	}

	public Map<String, String> getMap() {

		Map<String, String> tempMap = new HashMap<>(this.map);

//		for (Map.Entry<String, String> entry : this.map.entrySet()) {
//			tempMap.put(entry.getKey(), entry.getValue());
//		}
		return tempMap;

	}

	public static void main(String[] args) {

		Map<String, String> tempMap = new HashMap<>();
		tempMap.put("1", "Katrap vidyalaya");
		tempMap.put("2", "Saraswati vidyalaya");

		ImmutableclassExample ice = new ImmutableclassExample("Shubhangi", tempMap, 11);

		System.out.println(ice.getName());
		System.out.println(ice.getMap());
		System.out.println(ice.getRollNo());

		tempMap.put("3", "asj");
		System.out.println(ice.getMap());

	}
}
