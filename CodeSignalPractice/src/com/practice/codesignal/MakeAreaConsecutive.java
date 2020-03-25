package com.practice.codesignal;

public class MakeAreaConsecutive {

	int makeArrayConsecutive2(int[] statues) {
		int smallest = Integer.MAX_VALUE;
		int largest = Integer.MIN_VALUE;

		for (int i = 0; i < statues.length; i++) {
			if (statues[i] < smallest) {
				smallest = statues[i];
			}

			if (statues[i] >= largest) {
				largest = statues[i];
			}
		}

		System.out.println(largest);
		System.out.println(smallest);
		System.out.println(largest - smallest);
		return (largest - smallest) - statues.length + 1;
	}

	public static void main(String[] args) {
		MakeAreaConsecutive mac = new MakeAreaConsecutive();
		int[] a = { 6, 3 };
		System.out.println(mac.makeArrayConsecutive2(a));
	}
}
