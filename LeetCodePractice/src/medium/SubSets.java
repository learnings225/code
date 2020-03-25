package medium;

import java.util.ArrayList;
import java.util.List;

public class SubSets {
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> subsets = new ArrayList<>();
		generateSubsets(0, nums, new ArrayList<Integer>(), subsets);
		return subsets;
	}

	private void generateSubsets(int index, int[] nums, ArrayList<Integer> current, List<List<Integer>> subsets) {
		subsets.add(new ArrayList<Integer>(current));
		
		for(int i = index; i< nums.length; i++) {
			current.add(nums[i]);
			generateSubsets(i + 1, nums, current, subsets);
			current.remove(current.size() - 1);
		}
	}
	
	
	public static void main(String[] args) {
		SubSets ss = new SubSets();
		int[] nums = {1,2,3};
		System.out.println("Sub Sets :: " + ss.subsets(nums));
	}
}
