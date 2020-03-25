package com.code.practice;

import java.util.Arrays;

/**
 * Implement a Priority Queue with push and pop methods
 * 
 * @author srimeda
 *
 */
public class _1_PriorityQueue {
	
	int[] heap;
	int size;
	
	public _1_PriorityQueue(int maxSize) {
		heap = new int[maxSize];
		size = 0;
	}
	
	public void push(int value) {
		if(size == heap.length) throw new IllegalStateException();
		
		int pos = size;
		heap[pos] = value;
		
		//Bubble Up
		while(pos > 0) {
			int parent = (pos + 1) / 2 - 1;
			
			if(heap[parent] >= heap[pos]) {
				break; // do nothing because it is already in the correct spot
			} else {
				swapIndices(heap, parent, pos);
				pos = parent;
			}
		}
		
		size++;
	}
	
	public int pop() {
		if(size == 0) throw new IllegalStateException();
		int result = heap[0];
		
		heap[0] = heap[--size];
		
		// Bubble Down
		int pos = 0;
		while(pos < size/2) { // pos is representing the current node and that is going to be swapped with the children of that node.
								// we are starting with node 0 and checking if this node is less than its children, and if it is, we are gonna swap. 
								// 'size / 2' is because the children are multiple of 2 away from the parent. After that the parent will not have any children to check.
			int leftChildPosition = 2 * pos + 1;
			int rightChildPosition = 2 * pos + 2;
			
			if(rightChildPosition < size && heap[leftChildPosition] < heap[rightChildPosition]) {
				if(heap[pos] >= heap[rightChildPosition]) break;
				swapIndices(heap, pos, rightChildPosition);
				pos = rightChildPosition;
			} else {
				if(heap[pos] >= heap[leftChildPosition]) break;
				swapIndices(heap, pos, leftChildPosition);
				pos = leftChildPosition;
			}
		}
		
		return result;
	}
	
	private void swapIndices(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	private void print() {
		int[] print = new int[size];
		
		for(int i=0; i< size; i++) {
			print[i] = heap[i];
		}
		System.out.println(Arrays.toString(print));
	}
	
	public static void main(String[] args) {
		System.out.println("Implementing Priority Queue!!");
		
		_1_PriorityQueue pq = new _1_PriorityQueue(5);
		
		System.out.println("Push 3");
		pq.push(3);
		pq.print();
		
		System.out.println("Push 4");
		pq.push(4);
		pq.print();
		
		System.out.println("Push 5");
		pq.push(5);
		pq.print();
		
		System.out.println("Push 8");
		pq.push(8);
		pq.print();
		
		System.out.println("POP");
		System.out.println("Popped : " + pq.pop());
		pq.print();
		
		System.out.println("POP");
		System.out.println("Popped : " + pq.pop());
		pq.print();
		
		System.out.println("POP");
		System.out.println("Popped : " + pq.pop());
		pq.print();
	}
}
