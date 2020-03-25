package easy;

/**
 * 944. Delete Columns to Make Sorted
 * 
 * https://leetcode.com/problems/delete-columns-to-make-sorted/
 * 
 * 
 * @author srimeda
 *
 */
public class DeleteColumnsToMakeItSorted {

	/**
	 * Approach 1: Greedy
	 * 
	 * Intuition:
	 * 
	 * If a column isn't sorted, it can't be part of the final answer.
	 * 
	 * Algorithm:
	 * 
	 * For each column, check if its sorted. If it isn't, it must be deleted, so we
	 * add 1 to the final answer.
	 * 
	 * 
	 * @param a
	 * @return
	 */
	public int minDeletionSize(String[] a) {
		int result = 0;

		for (int i = 0; i < a[0].length(); ++i) {
			for (int j = 0; j < a.length - 1; ++j) {
				if (a[j].charAt(i) > a[j + 1].charAt(i)) {
					result++;
					break;
				}
			}
		}

		return result;
	}
}
