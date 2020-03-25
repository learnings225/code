package medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).
 * 
 * Note: The solution set must not contain duplicate subsets.
 * 
 * 
 * @author srimeda
 *
 */
public class SubSetsWithDuplicates {
	public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        generateSubsets(0, nums, new ArrayList<Integer>(), subsets);
        return subsets;
    }
    
    private void generateSubsets(int index, int[] nums, List<Integer> tempList, List<List<Integer>> subsets) {
        subsets.add(new ArrayList<Integer>(tempList));
        
        Set<Integer> set = new HashSet<Integer>();
        for(int i = index; i < nums.length; i++) {
            if(set.add(nums[i])) {
                tempList.add(nums[i]);
                generateSubsets(i+1, nums, tempList, subsets);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
    
    public static void main(String[] args) {
		SubSets ss = new SubSets();
		int[] nums = {1,2,2};
		System.out.println("Sub Sets :: " + ss.subsets(nums));
	}
}
