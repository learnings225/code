package com.learn.java8.features.streams;

import java.time.Duration;
import java.time.LocalTime;
import java.util.stream.Stream;

public class StreamExample {
	public static void main(String[] args) {
		
		/**
		 * Prints all animals with odd length names.
		 */
		LocalTime now = LocalTime.now();
		Stream.of("cat", "dog", "elephant", "fox", "rabbit", "duck")
				.filter(data -> data.length() % 2 != 0)
				.forEach(System.out::println);
		System.out.println("Sequential: " + Duration.between(now, LocalTime.now()).toMillis());
		
		now = LocalTime.now();
		Stream.of("cat", "dog", "elephant", "fox", "rabbit", "duck")
				.parallel()
				.filter(data -> data.length() % 2 != 0)
				.forEach(System.out::println);
		System.out.println("Parallel: " + Duration.between(now, LocalTime.now()).toMillis());
		
		
	}
}
