package com.learn.java8.features.streams;

import java.util.stream.Stream;

public class StreamExample {
	public static void main(String[] args) {
		Stream.of("cat", "dog", "elephant", "fox", "rabbit", "duck")
				.filter(data -> data.length() % 2 != 0)
				.forEach(System.out::println);
	}
}
