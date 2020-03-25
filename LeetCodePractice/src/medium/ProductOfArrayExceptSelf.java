package medium;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
	public static int[] productExceptSelf(int[] nums) {
        int N = nums.length;
        
        int[] left_array = new int[N];
        int[] right_array = new int[N];
        
        left_array[0] = 1;
        right_array[N-1] = 1;
        
        for(int i = 1 ; i < N; i++) {
            left_array[i] = nums[i-1] * left_array[i-1];
        }
        
        for(int i = N-2 ; i >= 0; i--) {
            right_array[i] = nums[i+1] * right_array[i+1];
        }
        
        for(int i = 0; i < nums.length; i++) {
            nums[i] = left_array[i] * right_array[i];
        }
        
        return nums;
    }
	
	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 4};
		System.out.println(Arrays.toString(productExceptSelf(nums)));
	}
}
