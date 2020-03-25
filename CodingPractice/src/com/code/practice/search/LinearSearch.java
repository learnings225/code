package com.code.practice.search;

public class LinearSearch {
	static int[] arr = new int[] {10, 4, 3, 5, 7, 9};
	
	public static boolean isItemFound(int[] arr, int item) {
		
		if(arr == null || arr.length == 0) {
			return false;
		}
		
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == item) {
				return true;
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		System.out.println("Is item 5 found?? " + LinearSearch.isItemFound(arr, 5));
		System.out.println("Is item 2 found?? " + LinearSearch.isItemFound(arr, 2));
	}
}
