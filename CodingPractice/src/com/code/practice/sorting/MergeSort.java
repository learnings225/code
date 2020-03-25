package com.code.practice.sorting;

import java.util.Arrays;

public class MergeSort {
	static int[] arr = new int[] { 10, 4, 3, 5, 7, 9 };

	/**
	 * My implementation of bubble sort
	 * 
	 * @param arr
	 */
	public void sort(int[] arr, int left, int right) {
		if(left < right) {
			int mid = (left + right)/2;
			
			sort(arr, left, mid);
			sort(arr, mid+1, right);
			
			merge(arr, left, mid, right);
		}
		
		System.out.println("Final result :: " + Arrays.toString(arr));
		
	}
	
	private void merge(int[] arr, int left, int mid, int right) {
		// Find sizes of two subarrays to be merged 
        int n1 = mid - left + 1; 
        int n2 = right - mid; 
  
        /* Create temp arrays */
        int L[] = new int [n1]; 
        int R[] = new int [n2]; 
  
        /*Copy data to temp arrays*/
		for (int i = 0; i < n1; ++i) {
			L[i] = arr[left + i];
		}

		for (int j = 0; j < n2; ++j) {
			R[j] = arr[mid + 1 + j];
		}

		int i = 0, j = 0, 
				
		k = left;
		
		while(i < n1 && j < n2) {
			if(L[i] <= R[j]) {
				arr[k] = L[i];
				k++; i++;
			} else {
				arr[k] = R[j];
				k++; j++;
			}
		}
		
		while(i < n1) {
			arr[k] = L[i];
			k++; i++;
		}
		
		while(j < n2) {
			arr[k] = R[j];
			k++; j++;
		}
	}
	
	public static void main(String[] args) {
		MergeSort ms = new MergeSort();
		ms.sort(arr, 0, arr.length-1);
	}
}