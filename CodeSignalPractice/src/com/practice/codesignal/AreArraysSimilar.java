package com.practice.codesignal;

import java.util.ArrayList;
import java.util.List;

/**
 * Two arrays are called similar if one can be obtained from another by swapping
 * at most one pair of elements in one of the arrays.
 * 
 * Given two arrays a and b, check whether they are similar.
 * 
 * Example
 * 
 * For a = [1, 2, 3] and b = [1, 2, 3], the output should be areSimilar(a, b) =
 * true.
 * 
 * The arrays are equal, no need to swap any elements.
 * 
 * For a = [1, 2, 3] and b = [2, 1, 3], the output should be areSimilar(a, b) =
 * true.
 * 
 * We can obtain b from a by swapping 2 and 1 in b.
 * 
 * For a = [1, 2, 2] and b = [2, 1, 1], the output should be areSimilar(a, b) =
 * false.
 * 
 * Any swap of any two elements either in a or in b won't make a and b equal.
 * 
 * Input/Output
 * 
 * [execution time limit] 3 seconds (java)
 * 
 * [input] array.integer a
 * 
 * Array of integers.
 * 
 * Guaranteed constraints: 3 ≤ a.length ≤ 105, 1 ≤ a[i] ≤ 1000.
 * 
 * [input] array.integer b
 * 
 * Array of integers of the same length as a.
 * 
 * Guaranteed constraints: b.length = a.length, 1 ≤ b[i] ≤ 1000.
 * 
 * [output] boolean
 * 
 * true if a and b are similar, false otherwise.
 * 
 * @author srimeda
 */
public class AreArraysSimilar {
	boolean areSimilar(int[] a, int[] b) {
		if (a.length != b.length) {
			return false;
		}

		List<Integer> tempList = new ArrayList<>();
		for (int i = 0; i < b.length; i++) {
			if (a[i] != b[i]) {
				tempList.add(i);
			}
		}

		if (tempList.size() == 0) {
			return true;
		}

		if (tempList.size() == 1 || tempList.size() > 2) {
			return false;
		} else {
			return a[tempList.get(0)] == b[tempList.get(1)] && a[tempList.get(1)] == b[tempList.get(0)];
		}
	}

	public static void main(String[] args) {
		AreArraysSimilar aas = new AreArraysSimilar();
		int a2[] = { 1, 2, 3 }, b2[] = { 2, 1, 3 };
		System.out.println(aas.areSimilar(a2, b2));
	}
}
