package com.code.practice.search;

public class BinarySearch {
	static int[] arr = new int[] { 10, 4, 3, 5, 7, 9 };

	public boolean isItemFound(int[] arr, int item) {

		if (arr == null || arr.length == 0) {
			return false;
		}

		return search(arr, 0, arr.length-1, item);
	}
	
	
	private boolean search(int arr[], int left, int right, int value) {
		if(left <= right) {
			int mid = (left + right) /2;
			
			if(arr[mid] == value) {
				return true;
			} else if(arr[mid] > value) {
				return search(arr, left, mid-1, value);
			} else {
				return search(arr, mid+1, right, value);
			}
		}
		
		return false;
	}

	public static void main(String[] args) {
		BinarySearch bs = new BinarySearch();
		System.out.println("Is item 5 found?? " + bs.isItemFound(arr, 5));
		System.out.println("Is item 2 found?? " + bs.isItemFound(arr, 2));
	}
}
