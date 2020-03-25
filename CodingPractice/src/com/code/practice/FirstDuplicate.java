package com.code.practice;

/**
 Given an arr a that contains only numbers in the range 1 and a.length, find
 the first duplicate number for which the second occurrence has the minimal
 index.
 
 In other words, if there are more than 1 duplicated numbers, return the
 number for which the second occurrence has a smaller index than the second
 occurrence of the other number does.
 
 If there are no duplicate elements, return -1
 
 @author srimeda
 *
 */
public class FirstDuplicate {
	int firstDuplicate(int[] a) {
		for (int i = 0; i < a.length; i++) {
			if (a[Math.abs(a[i]) - 1] < 0) {
				return Math.abs(a[i]);
			} else {
				a[Math.abs(a[i]) - 1] = -a[Math.abs(a[i]) - 1];
			}
		}

		return -1;
	}
	
	
	public static void main(String[] args) {
		FirstDuplicate fd = new FirstDuplicate();
		int[] a = {2, 1, 3, 5, 3, 2};
		System.out.println(fd.firstDuplicate(a));
	}	 
}
