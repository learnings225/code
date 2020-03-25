package com.code.practice.sorting;

import java.util.Arrays;

public class SelectionSort {
	static int[] arr = new int[] {10, 4, 3, 5, 7, 9};
	
	public static void sort(int[] arr) {
		if(arr == null || arr.length == 0) {
			return;
		}
		
		System.out.println("Beginnning list :: " + Arrays.toString(arr));
		
		for(int i = 0; i < arr.length; i++) {
			int smallestItemIndex = i;
			for(int j = i; j < arr.length; j++) {
				if(arr[j] < arr[smallestItemIndex]) {
					smallestItemIndex = j;
				}
			}
			
			swap(arr, i, smallestItemIndex);
			System.out.println("After every Iteration " + Arrays.toString(arr));
		}
		
		System.out.println("Final result :: " + Arrays.toString(arr));
	}
	
	private static void swap(int arr[], int i, int j) {
		int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
	}
	
	public static void main(String[] args) {
		SelectionSort.sort(arr);
	}
}
