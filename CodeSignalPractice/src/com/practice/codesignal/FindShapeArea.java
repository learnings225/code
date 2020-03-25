package com.practice.codesignal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class FindShapeArea {

	public static void main(String[] args) {
		FindShapeArea fs = new FindShapeArea();
		System.out.println(fs.shapeArea(5));

		int[] inputArray = { -1000, 0, -2, 0 };
		System.out.println(fs.arrayChange(inputArray));

		int[] as = { 4, 0, 1, -2, 3 };
		System.out.println(fs.mutateTheArray(5, as));

		int[] x = { 16, 1, 4, 2, 14 }, y = { 7, 11, 2, 0, 15 };
		System.out.println(fs.countTinyPairs(x, y, 743));

//		System.out.println(fs.mergeStrings("enbvszyppzyiydnc", "ousswsbeljamma"));

		String[] emails = { "test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com",
				"testemail+david@lee.tcode.com" };

		System.out.println(fs.numUniqueEmails(emails));
		
		System.out.println(fs.selfDividingNumbers(1, 22));
		
		System.out.println(fs.checkPerfectNumber(28));
	}

	int shapeArea(int n) {
		if (n == 0) {
			return 0;
		}

		if (n == 1) {
			return 1;
		}

		int result = ((n - 1) * 4) + shapeArea(n - 1);
		System.out.println("Result: " + n + " is: " + result);
		return result;
	}

	


	

	

	

	/**
	 * Write a function that reverses characters in (possibly nested) parentheses in
	 * the input string.
	 * 
	 * Input strings will always be well-formed with matching ()s.
	 * 
	 * Example
	 * 
	 * For inputString = "(bar)", the output should be
	 * reverseInParentheses(inputString) = "rab"; For inputString = "foo(bar)baz",
	 * the output should be reverseInParentheses(inputString) = "foorabbaz"; For
	 * inputString = "foo(bar)baz(blim)", the output should be
	 * reverseInParentheses(inputString) = "foorabbazmilb"; For inputString =
	 * "foo(bar(baz))blim", the output should be reverseInParentheses(inputString) =
	 * "foobazrabblim". Because "foo(bar(baz))blim" becomes "foo(barzab)blim" and
	 * then "foobazrabblim". Input/Output
	 * 
	 * [execution time limit] 3 seconds (java)
	 * 
	 * [input] string inputString
	 * 
	 * A string consisting of lowercase English letters and the characters ( and ).
	 * It is guaranteed that all parentheses in inputString form a regular bracket
	 * sequence.
	 * 
	 * Guaranteed constraints: 0 ≤ inputString.length ≤ 50.
	 * 
	 * [output] string
	 * 
	 * Return inputString, with all the characters that were in parentheses
	 * reversed.
	 * 
	 * @param inputString
	 * @return
	 */
	String reverseInParentheses(String inputString) {
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<Character>();

		for (char c : inputString.toCharArray()) {
			if (stack.isEmpty() && c != '(') {
				sb.append(c);
			} else if (c == '(' || c != ')') {
				stack.push(c);
			} else {
				String temp = "";
				while (!stack.empty()) {
					if (stack.peek() != '(') {
						char letter = stack.peek();
						temp += letter;
						stack.pop();
					} else {
						stack.pop();
						break;
					}
				}

				if (!stack.empty()) {
					for (int j = 0; j < temp.length(); j++) {
						stack.push(temp.charAt(j));
					}
				} else {
					sb.append(temp);
				}
			}
		}

		return sb.toString();
	}

	

	/**
	 * You are given an array of integers. On each move you are allowed to increase
	 * exactly one of its element by one. Find the minimal number of moves required
	 * to obtain a strictly increasing sequence from the input.
	 * 
	 * Example
	 * 
	 * For inputArray = [1, 1, 1], the output should be arrayChange(inputArray) = 3.
	 * 
	 * Input/Output
	 * 
	 * [execution time limit] 3 seconds (java)
	 * 
	 * [input] array.integer inputArray
	 * 
	 * Guaranteed constraints: 3 ≤ inputArray.length ≤ 105, -105 ≤ inputArray[i] ≤
	 * 105.
	 * 
	 * [output] integer
	 * 
	 * The minimal number of moves needed to obtain a strictly increasing sequence
	 * from inputArray. It's guaranteed that for the given test cases the answer
	 * always fits signed 32-bit integer type.
	 * 
	 * @param inputArray
	 * @return
	 */
	int arrayChange(int[] inputArray) {
		int count = 0;

		// iterate over all but the 1st element
		// 1st element starts the increasing pattern
		// so can start at index 1.
		// Use while loop toCount how many
		// times it would take current element
		// to be at least 1 more than previous
		// element. Once it's greater move to next element
		for (int i = 1; i < inputArray.length; i++) {
			while (inputArray[i] <= inputArray[i - 1]) {
				inputArray[i] = inputArray[i] + 1;
				count++;
			}
		}

		return count;
	}

	/**
	 * Given a string, find out if its characters can be rearranged to form a
	 * palindrome.
	 * 
	 * Example
	 * 
	 * For inputString = "aabb", the output should be
	 * palindromeRearranging(inputString) = true.
	 * 
	 * We can rearrange "aabb" to make "abba", which is a palindrome.
	 * 
	 * Input/Output
	 * 
	 * [execution time limit] 3 seconds (java)
	 * 
	 * [input] string inputString
	 * 
	 * A string consisting of lowercase English letters.
	 * 
	 * Guaranteed constraints: 1 ≤ inputString.length ≤ 50.
	 * 
	 * [output] boolean
	 * 
	 * true if the characters of the inputString can be rearranged to form a
	 * palindrome, false otherwise.
	 * 
	 * @param inputString
	 * @return
	 */
	boolean palindromeRearranging(String inputString) { // The solution is map with count of letters.
		Map<Character, Integer> charCount = new HashMap<>();
		for (char c : inputString.toCharArray()) {
			if (!charCount.containsKey(c)) {
				charCount.put(c, 1);
			} else {
				charCount.put(c, charCount.get(c) + 1);
			}
		}

		int singleCharCount = 0;
		for (Map.Entry<Character, Integer> e : charCount.entrySet()) {
			if (inputString.length() % 2 == 0 && e.getValue() % 2 != 0) {
				return false;
			} else if (inputString.length() % 2 != 0 && e.getValue() % 2 != 0) {
				singleCharCount++;
			}
			if (singleCharCount > 1) {
				return false;
			}
		}

		return true;
	}

	int[] mutateTheArray(int n, int[] a) {
		int[] b = new int[a.length];

		for (int i = 0; i < a.length; i++) {
			int value = 0;
			if (i - 1 < 0) {
				value = 0;
			} else {
				value = a[i - 1];
			}

			int nextVal = 0;
			if (i + 1 >= a.length) {
				nextVal = 0;
			} else {
				nextVal = a[i + 1];
			}

			b[i] = value + a[i] + nextVal;
		}

		return b;
	}

	int countTinyPairs(int[] a, int[] b, int k) {
		int i = 0;
		int j = b.length - 1;

		int tinycount = 0;

		while (i < a.length && j >= 0) {
			StringBuilder sb = new StringBuilder();
			if (Integer.parseInt(sb.append(a[i]).append(b[j]).toString()) < k) {
				tinycount++;
			}
			i++;
			j--;
		}

		return tinycount;
	}

	// Singly-linked lists are already defined with this interface:
	public static class ListNode<T> {
		ListNode(T x) {
			value = x;
		}

		T value;
		ListNode<T> next;
	}

	public int numUniqueEmails(String[] emails) {
		Set<String> emailSet = new HashSet<String>();

		int count = 0;
		for (String email : emails) {
			String formattedEmail = formattedEmail(email);
			if (!emailSet.contains(formattedEmail)) {
				count++;
				emailSet.add(formattedEmail);
			}
		}

		return count;
	}

	private String formattedEmail(String emailAddress) {
		int atIndex = emailAddress.indexOf('@');
		String localName = emailAddress.substring(0, atIndex);
		String domain = emailAddress.substring(atIndex + 1);

		System.out.println("localName : " + localName);
		localName = localName.replace(".", "");
		System.out.println("localName : " + localName);

		localName = localName.substring(0, localName.indexOf('+'));
		System.out.println("localName : " + localName);

		String fmtEmail = localName + "@" + domain;
		System.out.println(fmtEmail);

		return fmtEmail;
	}

	/**
	 * https://leetcode.com/problems/self-dividing-numbers/
	 * 
	 * @param left
	 * @param right
	 * @return
	 */
	public List<Integer> selfDividingNumbers(int left, int right) {
		if (left > right) {
			return null;
		}

		List<Integer> result = new ArrayList<Integer>();
		for (int i = left; i <= right; i++) {
			if (isSelfDividingNumber(i)) {
				result.add(i);
			}
		}

		return result;
	}

	private boolean isSelfDividingNumber(int i) {
		if (i > 0 && i < 10) {
			return true;
		}

		int temp = i;
		while (temp > 0) {
			int q = temp % 10;
			if (q == 0 || i % q != 0) {
				return false;
			}

			temp = temp / 10;
		}

		return true;
	}

	/**
	 * Perfect Number: https://leetcode.com/problems/perfect-number/
	 * 
	 * @param num
	 * @return
	 */
	public boolean checkPerfectNumber(int num) {
        if(num <= 0) {
            return false;
        }
        
        int total = 0;
        for(int i=1; i <= num/2; i++) {
        	int q = num%i;
            if(q == 0) {
                total+=i;
            }
        }
        
        return total == num;
    }
}
