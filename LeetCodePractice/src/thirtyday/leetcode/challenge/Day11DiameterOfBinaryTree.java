package thirtyday.leetcode.challenge;

import medium.TreeNode;

public class Day11DiameterOfBinaryTree {
	public int diameterOfBinaryTree(TreeNode node) {
		if (node == null) {
			return 0;
		}

		return Math.max(height(node.left) + height(node.right),
				Math.max(diameterOfBinaryTree(node.left), diameterOfBinaryTree(node.right)));
	}

	private int height(TreeNode root) {
		return root == null ? 0 : 1 + Math.max(height(root.left), height(root.right));
	}
	
	
	/**
	 * Depth First Search Solution
	 * @param node
	 * @return
	 */
	int ans;
	public int diameterOfBinaryTreeDFS(TreeNode root) {
		ans = 1;
		
		depth(root);
		
		return ans -1;
	}
	
	private int depth(TreeNode root) {
		if(root == null) {
			return 0;
		}
		
		int l = depth(root.left);
		int r = depth(root.right);
		
		ans = Math.max(ans, l+r+1);
		
		return Math.max(l, r) + 1;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		
		Day11DiameterOfBinaryTree dbt = new Day11DiameterOfBinaryTree();
		System.out.println(dbt.diameterOfBinaryTree(root));
		
		System.out.println(dbt.diameterOfBinaryTreeDFS(root));
	}
}
