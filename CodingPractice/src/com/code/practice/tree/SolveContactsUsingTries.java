package com.code.practice.tree;

/**
 * The below solution fails for CAPITAL LETTERS. So we have to convert all the
 * alphabets to lowercase before inserting and getting. Also SPACES are not allowed
 * 
 * @author srimeda
 *
 */
public class SolveContactsUsingTries {
	public static class TrieNode {
		public static int NO_OF_CHARACTERS = 26;
		TrieNode[] children = new TrieNode[NO_OF_CHARACTERS];

		int size = 0;

		private static int getCharIndex(char c) {
			return c - 'a';
		}

		private TrieNode getNode(char c) {
			return children[getCharIndex(c)];
		}

		private void setNode(char c, TrieNode node) {
			children[getCharIndex(c)] = node;
		}

		private void add(String s) {
			add(s, 0);
		}

		public void add(String s, int index) {
			size++;
			if (index == s.length())
				return;
			char current = s.charAt(index);
			TrieNode child = getNode(current);
			if (child == null) {
				child = new TrieNode();
				setNode(current, child);
			}
			child.add(s, index + 1);
		}

		public int findCount(String s, int index) {
			if (index == s.length())
				return size;

			TrieNode child = getNode(s.charAt(index));
			if (child == null) {
				return 0;
			}

			return child.findCount(s, index + 1);
		}
	}

	public static void main(String[] args) {
		TrieNode trie = new TrieNode();
		String[] names = { "gayle", "gary", "geena", "alex", "andy","hack","hackerrank", "h" };

		for (String s : names) {
			trie.add(s);
		}

		System.out.println("Find Count of names starting with prefix 'g' : " + trie.findCount("g", 0));
		System.out.println("Find Count of names starting with prefix 'ga' : " + trie.findCount("ga", 0));
		System.out.println("Find Count of names starting with prefix 'a' : " + trie.findCount("a", 0));
		System.out.println("Find Count of names starting with prefix 'hac' : " + trie.findCount("hac", 0));
	}
}
