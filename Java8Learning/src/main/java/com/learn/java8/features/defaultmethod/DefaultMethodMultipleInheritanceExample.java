package com.learn.java8.features.defaultmethod;

public class DefaultMethodMultipleInheritanceExample {
	public static void main(String[] args) {
		Son s = new Son();
		System.out.println(s.inherit());
	}
}

class Son implements Dad, Mom {
	@Override
	public double inherit() {
		return Dad.super.inherit() + Mom.super.inherit();
	}
}

interface Dad {
	default double inherit() {
		return 1.0;
	}
}

interface Mom {
	default double inherit() {
		return 2.0;
	}
}