package easy;

/**
 * https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/
 * 
 * 1351. Count Negative Numbers in a Sorted Matrix
 * 
 * @author srimeda
 *
 */
public class CountNegativeNumsInSortedMatrix {
	public static int countNegatives(int[][] grid) {
		int n = grid.length - 1;
		int m = grid[0].length - 1;

		int count = 0;

		int temp_n = n;

		while (temp_n >= 0) {
			int temp_m = m;
			while (temp_m >= 0) {
				if (grid[temp_n][temp_m] < 0) {
					count++;
				} else {
					break;
				}
				temp_m--;
			}
			temp_n--;
		}

		return count;
	}
	
	public static void main(String[] args) {
		int[][] grid = {{4,3,2,-1},{3,2,1,-1},{1,1,-1,-2},{-1,-1,-2,-3}};
		
		System.out.println(countNegatives(grid));
	}
}
