package easy;

/**
 * https://leetcode.com/problems/repeated-string-match/
 * 
 * 686. Repeated String Match
 * 
 * @author srimeda
 *
 */
public class RepeatedStringMatch {
//	public static int repeatedStringMatch(String A, String B) {
//		int count = 1;
//		String temp = A;
//		while (!temp.contains(B)) {
//			count++;
//			temp = temp.concat(A);
//			if (temp.length() > B.length() + A.length()) {
//				break;
//			}
//		}
//
//		return temp.contains(B) ? count : -1;
//	}

	public static int repeatedStringMatch(String A, String B) {
		int q = 1;
		StringBuilder S = new StringBuilder(A);
		for (; S.length() < B.length(); q++) {
			S.append(A);
		}
		
		if (S.indexOf(B) >= 0) {
			return q;
		}
		
		if (S.append(A).indexOf(B) >= 0) {
			return q + 1;
		}
		
		return -1;
	}

	public static void main(String[] args) {
		System.out.println(repeatedStringMatch("aaaaaaaaaaaaaaaaaaaaaab", "ba"));
		System.out.println(repeatedStringMatch("abcabcabcabc", "abac"));
		System.out.println(repeatedStringMatch("abcd", "cdabcdab"));
	}
}
