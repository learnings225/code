package com.learn.java8.features.foreach;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class ForEachExample {
	public static void main(String[] args) {
		Map<String, String> countryMap = new HashMap<>();
		countryMap.put("India", "Delhi");
		countryMap.put("USA", "Washington, D.C.");
		countryMap.put("Japan", "Tokyo");
		countryMap.put("Canada", "Ottawa");

		// iterate through Map normal way
		ForEachExample.iterateMap(countryMap);

		// iterate through Map using forEach method
		ForEachExample.iterateMapUsingForEach(countryMap);
		
		
		List<String> countryList = new ArrayList<>();
        countryList.add("India");
        countryList.add("USA");
        countryList.add("Japan");
        countryList.add("Canada");
 
        // iterate through List normal way
        ForEachExample.iterateList(countryList);
 
        // iterate through List using forEach method
        ForEachExample.iterateListUsingForEach(countryList);
	}

	private static void iterateList(List<String> countryList) {
		for(String country:countryList) {
            System.out.println(country);
        }
	}

	private static void iterateListUsingForEach(List<String> countryList) {
		countryList.forEach(System.out::println);
	}

	private static void iterateMap(Map<String, String> countryMap) {
		for (Entry<String, String> entry : countryMap.entrySet()) {
			System.out.println("Country: " + entry.getKey() + " : Capital: " + entry.getValue());
		}
	}

	private static void iterateMapUsingForEach(Map<String, String> countryMap) {
		countryMap.forEach((k, v) -> System.out.println("Country: " + k + " : Capital: " + v));
	}
}
