package easy;

/**
 * 
 * https://leetcode.com/problems/valid-palindrome/
 * 
 * 125. Valid Palindrome
 * 
 * @author srimeda
 *
 */
public class ValidPalindromeString {
	public static boolean isPalindrome(String s) {
		if (s.isEmpty()) {
			return true;
		}

		String temp = s.toLowerCase();

		int i = 0, n = s.length() - 1;
		while (i < n) {
			if (!Character.isLetterOrDigit(temp.charAt(i))) {
				i++;
				continue;
			}
			
			if(!Character.isLetterOrDigit(temp.charAt(n))) {
				n--;
				continue;
			}
			
			System.out.println(temp.charAt(i));
			System.out.println(temp.charAt(n));
			
			if(temp.charAt(i) != temp.charAt(n)) {
				return false;
			}
			
			i++;
			n--;
		}

		return true;
	}
	
	public static void main(String[] args) {
		System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
	}
}
