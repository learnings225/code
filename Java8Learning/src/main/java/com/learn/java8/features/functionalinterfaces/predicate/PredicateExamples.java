package com.learn.java8.features.functionalinterfaces.predicate;

import java.util.Objects;
import java.util.function.Predicate;

public class PredicateExamples {
	public static void main(String[] args) {
//		predicate1();
		
		predicate2();
	}

	/**
	 * A Predicate negating another predicate
	 * 
	 */
	public static void predicate1() {
//		Predicate<String> p = s -> s.isEmpty();
		// Or using Method references
		Predicate<String> p = String::isEmpty;

		System.out.println("For Hello : " + p.test("Hello"));
		System.out.println("For empty string: " + p.test(""));
		
		Predicate<String> negP = p.negate();
		
		System.out.println("After Negating..");
		System.out.println("For Hello : " + negP.test("Hello"));
		System.out.println("For empty string: " + negP.test(""));
	}
	
	/**
	 * Implement a predicate that returns true if a string is non null and not empty
	 */
	public static void predicate2() {
//		Predicate<String> p1 = string -> string != null;
//		OR
		Predicate<String> p1 = Objects::nonNull;
		Predicate<String> p2 = String::isEmpty;
		
		Predicate<String> p3 = p1.and(p2.negate());
		System.out.println(p3.test(""));
		System.out.println(p3.test(null));
		System.out.println(p3.test("srini"));
		
	}
}
