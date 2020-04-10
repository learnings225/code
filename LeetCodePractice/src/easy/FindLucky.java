package easy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindLucky {
	public static int findLucky(int[] arr) {
		if (arr == null || arr.length == 0) {
			return -1;
		}

		Map<Integer, Long> map = Arrays.stream(arr)
																	.mapToObj(x -> x)
																	.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		
		return map.entrySet().stream()
                .filter(e -> e.getKey() == Math.toIntExact(e.getValue()))
                .max(Comparator.comparingInt(e -> Math.toIntExact(e.getValue())))
                .map(Map.Entry :: getKey)
                .orElse(-1);
               
	}
	
	public static void main(String[] args) {
		int[] a =  {2,2,3,4};
		System.out.println(findLucky(a));
	}
}
