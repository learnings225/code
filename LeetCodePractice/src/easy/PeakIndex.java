package easy;

/**
 * 852. Peak Index in a Mountain Array
 * 
 * https://leetcode.com/problems/peak-index-in-a-mountain-array/
 * 
 * @author srimeda
 */
public class PeakIndex {

	/**
	 * Approach 1: Linear Scan Intuition and Algorithm
	 * 
	 * The mountain increases until it doesn't. The point at which it stops
	 * increasing is the peak.
	 * 
	 * Complexity Analysis
	 * 
	 * Time Complexity: O(N), where N is the length of A.
	 * 
	 * Space Complexity: O(1)O(1).
	 * 
	 * @param A
	 * @return
	 */
//
//	public int peakIndexInMountainArray(int[] A) {
//		int i = 0;
//		while (A[i] < A[i + 1])
//			i++;
//		return i;
//	}

	public int peakIndexInMountainArrayLinearScan(int[] A) {
		if (A == null || A.length == 0) {
			return -1;
		}

		for (int i = 1; i < A.length; i++) {
			if (A[i - 1] > A[i]) {
				return i - 1;
			}
		}

		return -1;
	}

	/**
	 * 
	 * Approach 2: Binary Search Intuition and Algorithm
	 * 
	 * The comparison A[i] < A[i+1] in a mountain array looks like [True, True,
	 * True, ..., True, False, False, ..., False]: 1 or more boolean Trues, followed
	 * by 1 or more boolean False. For example, in the mountain array [1, 2, 3, 4,
	 * 1], the comparisons A[i] < A[i+1] would be True, True, True, False.
	 * 
	 * We can binary search over this array of comparisons, to find the largest
	 * index i such that A[i] < A[i+1].
	 * 
	 * Complexity Analysis
	 * 
	 * Time Complexity: O(logN), where N is the length of A.
	 * 
	 * Space Complexity: O(1)O(1).
	 * 
	 * @param A
	 * @return
	 */
	public int peakIndexInMountainArrayBinarySearch(int[] A) {
		int lo = 0, hi = A.length - 1;
		while (lo < hi) {
			int mi = lo + (hi - lo) / 2;
			if (A[mi] < A[mi + 1])
				lo = mi + 1;
			else
				hi = mi;
		}
		
		return lo;
	}

	public static void main(String[] args) {
		PeakIndex pi = new PeakIndex();

		int[] a1 = { 0, 1, 0 };
		System.out.println(pi.peakIndexInMountainArrayLinearScan(a1));
		
		int[] a2 = { 0, 2, 1, 0 };
		System.out.println(pi.peakIndexInMountainArrayLinearScan(a2));
		
		int[] a11 = { 0, 1, 0 };
		System.out.println(pi.peakIndexInMountainArrayBinarySearch(a11));

		int[] a21 = { 0, 2, 1, 0 };
		System.out.println(pi.peakIndexInMountainArrayBinarySearch(a21));
	}
}
