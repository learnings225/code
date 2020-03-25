package com.practice.codesignal;

/**
 * Given a sequence of integers as an array, determine whether it is possible to
 * obtain a strictly increasing sequence by removing no more than one element
 * from the array.
 * 
 * Note: sequence a0, a1, ..., an is considered to be a strictly increasing if
 * a0 < a1 < ... < an. Sequence containing only one element is also considered
 * to be strictly increasing.
 * 
 * Example
 * 
 * For sequence = [1, 3, 2, 1], the output should be
 * almostIncreasingSequence(sequence) = false.
 * 
 * There is no one element in this array that can be removed in order to get a
 * strictly increasing sequence.
 * 
 * For sequence = [1, 3, 2], the output should be
 * almostIncreasingSequence(sequence) = true.
 * 
 * You can remove 3 from the array to get the strictly increasing sequence [1,
 * 2]. Alternately, you can remove 2 to get the strictly increasing sequence [1,
 * 3].
 * 
 * Input/Output
 * 
 * [execution time limit] 3 seconds (java)
 * 
 * [input] array.integer sequence
 * 
 * Guaranteed constraints: 2 ≤ sequence.length ≤ 105, -105 ≤ sequence[i] ≤ 105.
 * 
 * [output] boolean
 * 
 * Return true if it is possible to remove one element from the array in order
 * to get a strictly increasing sequence, otherwise return false.
 * 
 * @author srimeda
 *
 */
public class AlmostIncreasingSequence {
	/**
	 * 
	 * @param sequence
	 * @return
	 */
	boolean almostIncreasingSequence(int[] sequence) {
		int flag = 0;
		int i = 0;
		while (i < sequence.length - 1) {
			if (sequence[i] < sequence[i + 1]) {
				i = i + 1;
				continue;
			} else {
				flag = flag + 1;
				if (i > 0 && i + 2 < sequence.length && sequence[i + 1] <= sequence[i - 1]
						&& sequence[i + 2] <= sequence[i]) {
					flag = flag + 1;
				} else {
					i = i + 1;
				}
				if (flag > 1) {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		AlmostIncreasingSequence ais = new AlmostIncreasingSequence();
		int[] b = { 1, 3, 2 };
		System.out.println(ais.almostIncreasingSequence(b));

	}
}
