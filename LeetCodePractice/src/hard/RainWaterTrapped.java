package hard;

/**
 * Given n non-negative integers representing an elevation map where the width
 * of each bar is 1, compute how much water it is able to trap after raining.
 * 
 * 
 * The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In
 * this case, 6 units of rain water (blue section) are being trapped.
 * 
 * Example:
 * 
 * Input: [0,1,0,2,1,0,1,3,2,1,2,1] Output: 6
 * 
 * https://leetcode.com/problems/trapping-rain-water/
 * 
 * @author srimeda
 *
 */
public class RainWaterTrapped {

	/**
	 * Function to find amount of water that can be trapped within given set of bars
	 * in linear time and extra space
	 * 
	 * The time complexity of this solution is O(n) and auxiliary space used by the program is O(n)
	 * 
	 * @param height
	 * @return
	 */
	public static int trap(int[] height) {

		int n = height.length;
		int water = 0;

		// left[i] stores the maximum height of a bar to the left
		// of current bar
		int[] left = new int[n-1];
		left[0] = Integer.MIN_VALUE;
		
		// process bars from left to right;
		for(int i = 1; i< n-1; i++) {
			left[i] = Integer.max(left[i-1], height[i-1]);
		}
		
		/*
		int[] right = new int[n];
		right[n - 1] = Integer.MIN_VALUE;
		for (int i = n - 2; i >= 0; i--) {
			right[i] = Integer.max(right[i + 1], bars[i + 1]);
		}

		for (int i = 1; i < n - 1; i++) {
			if (Integer.min(left[i], right[i]) > bars[i]) {
				water += Integer.min(left[i], right[i]) - bars[i];
			}
		}
		*/
		
		// right stores the maximum height of a bar to the right
		// of current bar
		int right = Integer.MIN_VALUE;

		// process bars from right to left
		for (int i = n - 2; i >= 1; i--) {
			right = Integer.max(right, height[i + 1]);

			// check if it is possible to store water in current bar
			if (Integer.min(left[i], right) > height[i]) {
				water += Integer.min(left[i], right) - height[i];
			}
		}

		return water;
	}
	
	
	/**
	 * O(1) space Solution
	 * O(n) time
	 * 
	 * @param args
	 */
	// Function to find amount of water that can be trapped within
	// given set of bars in linear time and constant space
	public static int trapWithLinearTimeAndConstantSpace(int[] heights) {
		// maintain two pointers left and right pointing to leftmost and
		// rightmost index of the input array
		int left = 0, right = heights.length - 1, water = 0;

		int maxLeft = heights[left];
		int maxRight = heights[right];

		while (left < right) {
			if (heights[left] <= heights[right]) {
				left++;
				maxLeft = Integer.max(maxLeft, heights[left]);
				water += (maxLeft - heights[left]);
			} else {
				right--;
				maxRight = Integer.max(maxRight, heights[right]);
				water += (maxRight - heights[right]);
			}
		}

		return water;
	}
	
	/**
	 * There is another linear time and constant space solution. Makes two passes.
	 * 
	 * Walk from left to right,keeping track of max as you go along. Any time the
	 * max changes, walk backward to the prior max, "filling with water" all the
	 * intermediate bars.
	 * 
	 * Repeat, but from right to left.
	 * 
	 * Each bar is touched a constant number of times during each pass, once to
	 * compare against the max and once more to "fill with water"
	 * 
	 */
	
	
	// Trapping Rain Water within given set of bars
	public static void main(String[] args) {
		int[] heights = { 7, 0, 4, 2, 5, 0, 6, 4, 0, 5 };

		System.out.println("Maximum amount of water that can be trapped is " + trap(heights));
		
		System.out.println("Maximum amount of water that can be trapped is " + trapWithLinearTimeAndConstantSpace(heights));
	}
}
