package easy;

import java.util.Arrays;

public class CreateTargetArray {
	public static int[] createTargetArray(int[] nums, int[] index) {
        int[] result = new int[index.length];
        Arrays.fill(result, -1);
        for(int i=0; i < index.length;i++) {
            if(result[index[i]] != -1) {
                // insert new element at given index. and move the later elements from this index to right
                for(int j = index.length - 1; j > index[i]; j--) {
                    result[j] = result[j-1];
                }
            }
            result[index[i]] = nums[i];
        }
        
        return result;
    }
	
	public static void main(String[] args) {
		int[] nums = {0,1,2,3,4}, index = {0,1,2,2,1};
		Arrays.stream(createTargetArray(nums, index)).forEach(System.out::println);
	}
}
