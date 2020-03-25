package easy;

public class LongestCommonPrefix {
	
	private String getLongestCommonPrefix(String[] strs) {
		String longestCommonPrefix = "";
		
		if(strs == null || strs.length == 0) {
			return longestCommonPrefix;
		}
		
		int index = 0;
		for(char c: strs[0].toCharArray()) {
			for(int i = 1; i < strs.length; i++) {
				if(index > strs[i].length() || c != strs[i].charAt(index)) {
					return longestCommonPrefix;
				}
			}
			
			longestCommonPrefix += c;
			index++;
		}
		
		return longestCommonPrefix;
	}
	
	public static void main(String[] args) {
		LongestCommonPrefix lcp = new LongestCommonPrefix();
		
		String[] strs1 = {"flower", "flow", "flight"};
		System.out.println("Longest Common Prefix :: " + lcp.getLongestCommonPrefix(strs1));
		
		String[] strs2 = {"dog", "racecar", "car"};
		System.out.println("Longest Common Prefix :: " + lcp.getLongestCommonPrefix(strs2));
	}
}
