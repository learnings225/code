package thirtyday.leetcode.challenge;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * We can also solve this using maxHeap
 * 
 * @author srimeda
 *
 */
public class Day12LastStoneWeight {
	public int lastStoneWeight(int[] stones) {
        int result = 0;
        if(stones == null || stones.length == 0) {
            return result;
        }
        
        List<Integer> list = IntStream.of(stones)
                                    .boxed()
                                    .collect(Collectors.toList());
       
        while(list.size() > 1) {
            int n = list.size() - 1;
            Collections.sort(list);
            if(list.get(n) == list.get(n-1)) {
                list.remove(n);
                list.remove(n-1);
            } else {
            	list.set(n-1, list.get(n) - list.get(n-1));
            	list.remove(n);
            }
        }
        
        return list.size() > 0 ? list.get(0) : result;
    }
    
    public static void main(String[] args) {
		Day12LastStoneWeight day12 = new Day12LastStoneWeight();
		int[] stones = {2,7,4,1,8,1};
		System.out.println(day12.lastStoneWeight(stones));
	}
}