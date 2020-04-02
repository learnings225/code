package com.learn.java8.features.functionalinterfaces.consumer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * JDK has pre-defined interfaces for Functional Interfaces. Consumer is one of them.
 * 
 * Runnable - no args, no return
 * Consumer - 1 arg, no return
 * Supplier - no arg, return
 * Function - 1 arg, return
 * Predicate - 1 arg, boolean
 * @author srimeda
 *
 */
public class ConsumerExample {
	public static void main(String[] args) {
		// Consumer<String> consumer = (String t) -> System.out.println(t);
		// OR
		Consumer<String> consumer = System.out::println;
		consumer.accept("Hello");
		
		consumer1();
		
		consumer2();
	}
	
	
	public static void consumer1() {
		// Consumer<List<String>> consumer = strings -> strings.clear();
		// OR
		Consumer<List<String>> consumer = List::clear;
		
		List<String> l = new ArrayList<>(Arrays.asList("1", "2"));
		consumer.accept(l);
		
		System.out.println(l.isEmpty());
	}
	
	/**
	 * Consumer chaining.
	 * 
	 * A Consumer that calls two other consumers
	 */
	public static void consumer2() {
		Consumer<List<String>> c1 = list -> list.add("first");
		Consumer<List<String>> c2 = list -> list.add("two");
		
		Consumer<List<String>> consumer = c1.andThen(c2);
		
		List<String> list = new ArrayList<>(Arrays.asList("a", "b", "c"));
		consumer.accept(list);
		
		list.forEach(System.out::println);
	}
}
