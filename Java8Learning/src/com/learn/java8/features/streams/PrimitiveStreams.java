package com.learn.java8.features.streams;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Example to instruct on how to use streams with primitive types
 * 
 * @author srimeda
 *
 */
public class PrimitiveStreams {
	int min(int[] integers) {
		return Arrays.stream(integers).min().getAsInt();
	}

	int max(int... integers) {
		return IntStream.of(integers).max().getAsInt();
	}

	int sum(int... integers) {
		return IntStream.of(integers).sum();
	}

	double avg(int... integers) {
		return IntStream.of(integers).average().getAsDouble();
	}
	
	public static void main(String[] args) {
		PrimitiveStreams ps = new PrimitiveStreams();
		int[] data = {2, 3, 5, 1, 6};
		
		System.out.println("Content of data: ");
		IntStream.of(data).forEach(System.out::println);
		
		System.out.println("Min. of data: " + ps.min(data));
		System.out.println("Max. of data: " + ps.max(data));
		System.out.println("Sum of data: " + ps.sum(data));
		System.out.println("Avg. of data: " + ps.avg(data));
		
	}
}
