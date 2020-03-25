package com.practice.codesignal;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CommonDistinctCharCount {
	public static void main(String[] args) {
		CommonDistinctCharCount cdc = new CommonDistinctCharCount();
		System.out.println("Common char count : " + cdc.commonDistinctCharacterCount("hello", "hola"));
	}

	/**
	 * Intersection of two arrays
	 * 
	 * @param s1
	 * @param s2
	 * @return
	 */
	int commonDistinctCharacterCount(String s1, String s2) {
		Set<Character> set = new HashSet<Character>();
		List<Character> s1CharList = new ArrayList<>();

		for (char c : s1.toCharArray()) {
			s1CharList.add(c);
		}

		set.addAll(s1CharList);

		List<Character> s2CharList = new ArrayList<>();

		for (char c : s2.toCharArray()) {
			s2CharList.add(c);
		}
		set.retainAll(s2CharList);

		return set.size();
	}
}
