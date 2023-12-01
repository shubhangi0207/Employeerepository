package com.employee.practiceexample;

class A {
	void myMethod() throws NullPointerException {
		String s = null;
		System.out.println("Super Class" + s.length());
	}
}

class B extends A {
	@Override
	void myMethod() throws ArithmeticException {

		System.out.println("Sub Class");
	}
}
