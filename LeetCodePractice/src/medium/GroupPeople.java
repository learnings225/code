package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupPeople {
    public static List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> results = new ArrayList<>();
        
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        
        for(int i = 0; i < groupSizes.length; i++) {
            if(map.get(groupSizes[i]) == null) {
                map.put(groupSizes[i], new ArrayList<>());
            }
            map.get(groupSizes[i]).add(i);
        }
        
        for(Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            List<Integer> valueList = entry.getValue();
            int partitionSize = entry.getKey();

            for (int i=0; i<valueList.size(); i += partitionSize) {
                results.add(valueList.subList(i, Math.min(i + partitionSize, valueList.size())));
            }
        }
        
        return results;
    }
    
    public static void main(String[] args) {
		int[] groupSizes = {3,3,3,3,3,1,3};
		System.out.println(groupThePeople(groupSizes));
	}
}