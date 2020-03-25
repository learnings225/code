package com.code.practice.sorting;

import java.util.Arrays;

public class BubbleSort {
	static int[] arr = new int[] { 10, 4, 3, 5, 7, 9 };

	/**
	 * My implementation of bubble sort
	 * 
	 * @param arr
	 */
	public static void sort(int[] arr) {
		if(arr == null || arr.length == 0) {
			return;
		}
		
		for(int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length - i - 1; j++) {
				if(arr[j] > arr[j+1]) {
					swap(arr, j+1, j);
					System.out.println("After every Iteration " + Arrays.toString(arr));
				}
			}
		}
		
		System.out.println("Final result :: " + Arrays.toString(arr));
	}
	
	/**
	 * Another way of implementing bubble sort
	 * 
	 * @param lst
	 */
	static void bubbleSort(int[] lst) {
		int n = lst.length;
		boolean swapped;
		do 
		{
			swapped = false;
			for (int i = 0; i < n-1; i++) {
				if (lst[i] > lst[i+1]) {
					int temp = lst[i];
					lst[i] = lst[i+1];
					lst[i+1] = temp;
					swapped = true;
				}
			}
		} while (swapped == true);
		
		System.out.println(Arrays.toString(lst));
	}
	
	private static void swap(int arr[], int i, int j) {
		int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
	}
	
	public static void main(String[] args) {
		BubbleSort.sort(arr);
		
		System.out.println("Another way ::: ");
		
		BubbleSort.bubbleSort(arr);
	}
}
