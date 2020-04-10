package com.learn.java8.features.functionalinterfaces.consumer;

/**
 * 
 * @author srimeda
 *
 */
public class TestFunctionalInterface {
	public static void main(String[] args) {
		SampleFunctionalInterface sf = System.out::println;
		sf.test();
		sf.sample();
		SampleFunctionalInterface.print();
	}
}

@FunctionalInterface
interface SampleFunctionalInterface {
	
	/**
	 * only one abstract method
	 */
	public void test();
	
	/**
	 * default method. you can have as many default methods as needed.
	 */
	default void sample() {
		System.out.println("Invoking default method");
	}
	
	/**
	 * static method. you can have as many default methods as needed.
	 */
	static void print() {
		System.out.println("Static method invoked..");
	}
}
