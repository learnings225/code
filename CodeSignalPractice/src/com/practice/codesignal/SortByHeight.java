package com.practice.codesignal;

/**
 * Some people are standing in a row in a park. There are trees between them
 * which cannot be moved. Your task is to rearrange the people by their heights
 * in a non-descending order without moving the trees. People can be very tall!
 * 
 * Example
 * 
 * For a = [-1, 150, 190, 170, -1, -1, 160, 180], the output should be
 * sortByHeight(a) = [-1, 150, 160, 170, -1, -1, 180, 190].
 * 
 * Input/Output
 * 
 * [execution time limit] 3 seconds (java)
 * 
 * [input] array.integer a
 * 
 * If a[i] = -1, then the ith position is occupied by a tree. Otherwise a[i] is
 * the height of a person standing in the ith position.
 * 
 * Guaranteed constraints: 1 ≤ a.length ≤ 1000, -1 ≤ a[i] ≤ 1000.
 * 
 * [output] array.integer
 * 
 * Sorted array a with all the trees untouched.
 * 
 * @author srimeda
 */
public class SortByHeight {
	int[] sortByHeight(int[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			for (int j = i + 1; j < a.length; j++) {
				if ((a[i] != -1 && a[j] != -1) && a[i] > a[j]) {
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
		return a;
	}

	public static void main(String[] args) {
		SortByHeight sh = new SortByHeight();
		int[] a1 = { -1, 150, 190, 170, -1, -1, 160, 180 };
		int[] result = sh.sortByHeight(a1);
		for (int i : result) {
			System.out.println(i);
		}
	}
}
