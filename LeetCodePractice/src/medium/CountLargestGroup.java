package medium;

/**
 * 1399. Count Largest Group
 * https://leetcode.com/contest/biweekly-contest-23/problems/count-largest-group/
 * 
 * @author srimeda
 *
 */
public class CountLargestGroup {
	public static void main(String[] args) {
		System.out.println(countLargestGroup(13));
	}

	public static int countLargestGroup(int n) {
		int[] buckets = new int[10];
		int maxCount = 0;
		for (int i = 1; i <= n; i++) {
			int bucket = getBucketNumber(i);
//			System.out.println(i + " : " + bucket);
			maxCount = Math.max(maxCount, ++buckets[bucket]);
		}

		int result = 0;
		for (int i : buckets) {
			if (i == maxCount) {
				result++;
			}
		}
		return result;
	}

	private static int getBucketNumber(int n) {
		int bucket = n % 9;
		return bucket == 0 ? 9 : bucket;
	}
}
