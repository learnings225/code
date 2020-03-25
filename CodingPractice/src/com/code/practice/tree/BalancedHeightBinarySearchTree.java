package com.code.practice.tree;

/**
 * Time Complexity (O(n))
 * 
 * @author srimeda
 *
 */
public class BalancedHeightBinarySearchTree {
	
	public static boolean isBalanced(BinaryTree.TreeNode root) {
		return isBalancedRecursive(root) != -1;
	}

	private static int isBalancedRecursive(BinaryTree.TreeNode node) {
		if (node == null) {
			return 0;
		}

		int leftTreeDepth = isBalancedRecursive(node.left);
		int rightTreeDepth = isBalancedRecursive(node.right);
		
		if(Math.abs(leftTreeDepth - rightTreeDepth) > 1 || leftTreeDepth == -1 || rightTreeDepth == -1) {
			return -1;
		} else {
			return Math.abs(leftTreeDepth - rightTreeDepth) + 1;
		}
	}
	
	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();

		bt.add(6);
		bt.add(4);
		bt.add(8);
		bt.add(3);
		bt.add(5);
		bt.add(7);
		bt.add(9);
		
		System.out.println("Is tree balanced ?? " + BalancedHeightBinarySearchTree.isBalanced(bt.getRoot()));
	}
}
