package com.employee.practiceexample;

public class Employee {
	public Integer salary;
	public String name;
	public Integer id;

	Employee(Integer salary, String name, Integer id) {
		this.salary = salary;
		this.name = name;
		this.id = id;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Employee [salary=" + salary + ", name=" + name + ", id=" + id + "]";
	}

}
