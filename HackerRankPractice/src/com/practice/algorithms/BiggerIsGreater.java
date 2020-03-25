package com.practice.algorithms;

import java.util.Arrays;

/**
 * https://www.hackerrank.com/challenges/bigger-is-greater/problem
 * 
 * https://www.nayuki.io/page/next-lexicographical-permutation-algorithm
 * 
 * @author srimeda
 *
 */
public class BiggerIsGreater {

	/**
	 * The Algorithm:
	 * 
	 * 1. Identify the longest suffix that is non-increasing. The suffix is already
	 * the highest permutation, so we can't make a next permutation by just
	 * modifying it. We need to modify some elements left of it. (Note that we can
	 * identify this suffix in O(n) time by scanning the sequence from right to
	 * left. Also note that such a suffix has at least one element, because a single
	 * element substring is trivially non-increasing.)
	 * 
	 * 2. Look at the element immediately to the left of the suffix (in the example
	 * it’s 2) and call it the pivot. (If there is no such element – i.e. the entire
	 * sequence is non-increasing – then this is already the last permutation.) The
	 * pivot is necessarily less than the head of the suffix (in the example it’s
	 * 5). So some element in the suffix is greater than the pivot. If we swap the
	 * pivot with the smallest element in the suffix that is greater than the pivot,
	 * then the prefix is minimized. (The prefix is everything in the sequence
	 * except the suffix.) In the example, we end up with the new prefix (0, 1, 3)
	 * and new suffix (5, 3, 2, 0). (Note that if the suffix has multiple copies of
	 * the new pivot, we should take the rightmost copy – this plays into the next
	 * step.)
	 * 
	 * 3. Finally, we sort the suffix in non-decreasing (i.e. weakly increasing)
	 * order because we increased the prefix, so we want to make the new suffix as
	 * low as possible. In fact, we can avoid sorting and simply reverse the suffix,
	 * because the replaced element respects the weakly decreasing order. Thus we
	 * obtain the sequence (0, 1, 3, 0, 2, 3, 5), which is the next permutation that
	 * we wanted to compute.
	 * 
	 * Condensed mathematical description:
	 * 
	 * 1. Find largest index i such that array[i − 1] < array[i]. (If no such i
	 * exists, then this is already the last permutation.)
	 * 
	 * 2. Find largest index j such that j ≥ i and array[j] > array[i − 1].
	 * 
	 * 3. Swap array[j] and array[i − 1].
	 * 
	 * 4. Reverse the suffix starting at array[i].
	 */
	
	static boolean nextPermutation(int[] a) {
		
		// Find longest non-increasing suffix
		int i = a.length - 1;
		while(i > 0 && a[i-1] >= a[i]) {
			i--;
		}
		// Now i is the head of the suffix
		
		if(i <= 0) { // we are already at the last index and hence the last permutation already
			return false;
		}
		
		// let a[i-1] be the pivot
		
		// find the right most element that exceeds the pivot
		int j = a.length - 1;
		while(a[j] <= a[i-1]) {
			j--;
		} // now the value of a[j] will be the new pivot
		// Assert j >= i
		
		// swap the pivot with a[j]
		int temp = a[i-1];
		a[i-1] = a[j];
		a[j] = temp;
		
		// Reverse the suffix
		
		j = a.length - 1;
		
		while(i < j) {
			temp = a[i];
			a[i] = a[j];
			a[j] = temp;
			i++;
			j--;
		}
		
		// Successfully computed the next permutation
		return true;
	}
	
	static String biggerIsGreater(String w) {
        char[] c = w.toCharArray();

        int i = c.length - 1;
        while(i > 0 && c[i-1] >= c[i]) {
            i--;
        }

        if(i <= 0) {
            return "no answer";
        }

        int j = c.length - 1;
        while(c[j] <= c[i-1]) {
        	j--;
        }
        
        char temp = c[i-1];
        c[i-1] = c[j];
        c[j] = temp;
                
        j = c.length - 1;
        while(i < j) {
            temp = c[i];
            c[i] = c[j];
            c[j] = temp;
            i++;
            j--;
        }

        return new String(c);
    }
	
	public static void main(String[] args) {
//		int[] array = {0, 1, 1, 1, 4};
//		do {  // Must start at lowest permutation
//		    System.out.println(Arrays.toString(array));
//		} while (nextPermutation(array));
		
		System.out.println(biggerIsGreater("ab"));
		System.out.println(biggerIsGreater("bb"));
		System.out.println(biggerIsGreater("hefg"));
		System.out.println(biggerIsGreater("dhck"));
		System.out.println(biggerIsGreater("dkhc"));
	}
}
