package thirtyday.leetcode.challenge;

import java.util.Arrays;

/**
 * Given a non-empty array of integers, every element appears twice except for
 * one. Find that single one.
 * 
 * Note:
 * 
 * Your algorithm should have a linear runtime complexity. Could you implement
 * it without using extra memory?
 * 
 * Example 1:
 * 
 * Input: [2,2,1] Output: 1 Example 2:
 * 
 * Input: [4,1,2,1,2] Output: 4
 * 
 * @author srimeda
 *
 */
public class Day1SingleNumber {
	 public static int singleNumber(int[] nums) {
		 if(nums == null || nums.length == 0) {
			 return -1;
		 }
		 
		 if(nums.length == 1) {
			 return nums[0];
		 }
		 
		 Arrays.sort(nums);
		 
		 for(int i = 1; i < nums.length; i+=2) {
			 if(nums[i] != nums[i-1]) {
				 return nums[i-1];
			 }
		 }

		 // This is to cover the last element in the case the input is of odd number length
		 if(nums[nums.length-1] != nums[nums.length -2]) {
			 return nums[nums.length-1];
		 }
		 
		 return -1;
	 }
	 
	 public static void main(String[] args) {
		 int[] nums = {4,1,2,1,2};
		System.out.println(singleNumber(nums));
	}
}
