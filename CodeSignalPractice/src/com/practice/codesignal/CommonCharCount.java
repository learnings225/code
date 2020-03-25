package com.practice.codesignal;

/**
 * Given two strings, find the number of common characters between them.
 * 
 * Example
 * 
 * For s1 = "aabcc" and s2 = "adcaa", the output should be
 * commonCharacterCount(s1, s2) = 3.
 * 
 * Strings have 3 common characters - 2 "a"s and 1 "c".
 * 
 * Input/Output
 * 
 * [execution time limit] 3 seconds (java)
 * 
 * [input] string s1
 * 
 * A string consisting of lowercase English letters.
 * 
 * Guaranteed constraints: 1 ≤ s1.length < 15.
 * 
 * [input] string s2
 * 
 * A string consisting of lowercase English letters.
 * 
 * Guaranteed constraints: 1 ≤ s2.length < 15.
 * 
 * [output] integer
 * 
 * @author srimeda
 */
public class CommonCharCount {

	public int commonCharacterCount(String s1, String s2) {
		int[] a = new int[26], b = new int[26];
		for (char c : s1.toCharArray())
			a[c - 'a']++;
		for (char c : s2.toCharArray())
			b[c - 'a']++;
		int s = 0;
		for (int i = 0; i < 26; ++i)
			s += Math.min(a[i], b[i]);
		return s;
	}

	public static void main(String[] args) {
		CommonCharCount ccc = new CommonCharCount();
		String s1 = "aa";
		String s2 = "ad";
		System.out.println(ccc.commonCharacterCount(s1, s2));

	}
}
