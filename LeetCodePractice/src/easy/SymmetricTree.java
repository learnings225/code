package easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 101. Symmetric Tree
 * 
 * https://leetcode.com/problems/symmetric-tree/
 * 
 * @author srimeda
 *
 */
public class SymmetricTree {
	
	/**
	 *  Recursive implementation
	 *  
	 * @param root
	 * @return
	 */
	public static boolean isSymmetricRecursive(TreeNode root) {
		return isMirror(root, root);
	}
	
	private static boolean isMirror(TreeNode r1, TreeNode r2) {
		if(r1 == null && r2 == null) return true;
		if(r1 == null || r2 == null) return false;
		
		return r1.val == r2.val
						&& isMirror(r1.left, r2.right)
						&& isMirror(r1.right, r2.left);
	}
	
	/**
	 * Iterative Implementation
	 * 
	 * @param root
	 * @return
	 */
	public static boolean isSymmetricIterative(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		queue.add(root);
		
		while(!queue.isEmpty()) {
			TreeNode r1 = queue.poll();
			TreeNode r2 = queue.poll();
			
			if(r1 == null && r2 == null) return true;
			if(r1 == null || r2 == null) return false;
			if(r1.val != r2.val) return false;
			queue.add(r1.left);
			queue.add(r2.right);
			queue.add(r1.right);
			queue.add(r2.left);
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode leftRoot = new TreeNode(2);
		TreeNode rightRoot = new TreeNode(2);
		
		TreeNode leftLeftRoot = new TreeNode(3);
		TreeNode leftRightRoot = new TreeNode(4);
		leftRoot.setLeft(leftLeftRoot);
		leftRoot.setRight(leftRightRoot);

		TreeNode rightLeftRoot = new TreeNode(4);
		TreeNode rightRightRoot = new TreeNode(3);
		rightRoot.setLeft(rightLeftRoot);
		rightRoot.setRight(rightRightRoot);
		
		root.setLeft(leftRoot);
		root.setRight(rightRoot);
		
		System.out.println("Recursive :: " + isSymmetricRecursive(root));
		System.out.println("Iterative :: " + isSymmetricIterative(root));
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}

	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
	}

	public TreeNode getLeft() {
		return left;
	}

	public void setLeft(TreeNode left) {
		this.left = left;
	}

	public TreeNode getRight() {
		return right;
	}

	public void setRight(TreeNode right) {
		this.right = right;
	}

}
