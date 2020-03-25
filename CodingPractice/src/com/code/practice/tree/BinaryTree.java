package com.code.practice.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {

	private TreeNode root;

	public void add(int val) {
		root = addRecursive(root, val);
	}

	public TreeNode addRecursive(TreeNode currentNode, int val) {
		if (currentNode == null) {
			return new TreeNode(val);
		}

		if (val < currentNode.val) {
			currentNode.left = addRecursive(currentNode.left, val);
		} else if (val > currentNode.val) {
			currentNode.right = addRecursive(currentNode.right, val);
		} else {
			return currentNode; // the value already exists
		}

		return currentNode;
	}

	public boolean isEmpty() {
		return root == null;
	}

	public int getSize() {
		return getSizeRecursive(root);
	}

	private int getSizeRecursive(TreeNode current) {
		return current == null ? 0 : getSizeRecursive(current.left) + 1 + getSizeRecursive(current.right);
	}

	public boolean containsNodeIterative(int value) {
		TreeNode current = root;

		while (current != null) {
			if (current.val == value) {
				return true;
			} else if (value < current.val) {
				current = current.left;
			} else {
				current = current.right;
			}
		}

		return false;
	}
	
	public boolean containsNode(int value) {
		return containsNodeRecursive(root, value);
	}

	private boolean containsNodeRecursive(TreeNode current, int value) {
		if(current == null) {
			return false;
		}
		
		if(value == current.val) {
			return true;
		} else if(value < current.val) {
			return containsNodeRecursive(current.left, value);
		} else if(value > current.val) {
			return containsNodeRecursive(current.right, value);
		}
			
		return false;
	}

	public void delete(int value) {
		deleteRecursive(root, value);
	}

	private TreeNode deleteRecursive(TreeNode current, int value) {
		if(current == null) {
			return null;
		}
		
		if(value == current.val) {
			// Case 1: No children
			if(current.left == null && current.right == null) {
				return null;
			}
			
			// Case 2: only one child
			if(current.left == null) {
				return current.right;
			}
			
			if(current.right == null) {
				return current.left;
			}
			
			//Case 3: both children
			int smallestValue = findSmallestValue(current.right);
			current.val = smallestValue;
			current.right = deleteRecursive(current, smallestValue);
			return current;
		}
		
		if(value < current.val) {
			current.left = deleteRecursive(current.left, value);
			return current;
		}
		
		current.right = deleteRecursive(current.right, value);
		return current;
	}

	private int findSmallestValue(TreeNode root) {
		return root.left == null ? root.val : findSmallestValue(root.left); 
	}

	public void traverseInOrder(TreeNode node) {
		if(node != null) {
			traverseInOrder(node.left);
			visit(node.val);
			traverseInOrder(node.right);
		}
	}

	public void traversePreOrder(TreeNode node) {
		if(node != null) {
			visit(node.val);
			traversePreOrder(node.left);
			traversePreOrder(node.right);
		}
	}

	public void traversePostOrder(TreeNode node) {
		if(node != null) {
			traversePostOrder(node.left);
			traversePostOrder(node.right);
			visit(node.val);
		}
	}

	public void traverseLevelOrder() {
		if(root == null) {
			return;
		}

		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		
		while(!queue.isEmpty()) {
			TreeNode node = queue.remove();
			
			System.out.println(node.val);
			
			if(node.left != null) queue.add(node.left);
			if(node.right != null) queue.add(node.right);
		}
	}

	public void traverseInOrderWithoutRecursion() {
		TreeNode current = root;
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		
		while(!stack.isEmpty()) {
			while(current.left != null) {
				current = current.left;
				stack.push(current);
			}
			
			current = stack.pop();
			visit(current.val);
			if(current.right != null) {
				current = current.right;
				stack.push(current);
			}
		}
		
	}

	public void traversePreOrderWithoutRecursion() {
		TreeNode current = root;
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		
		while(!stack.isEmpty()) {
			current = stack.pop();
			visit(current.val);
			
			if(current.right != null) {
				stack.push(current.right);
			}
			
			if(current.left != null) {
				stack.push(current.left);
			}
		}

	}

	public void traversePostOrderWithoutRecursion() {
		// TODO implement
	}

	private void visit(int value) {
		System.out.println(" " + value);
	}

	/**
	 * TreeNode class
	 * 
	 * @author srimeda
	 *
	 */
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode(int val) {
			this.val = val;
			this.left = null;
			this.right = null;
		}

		public TreeNode(TreeNode root) {
			if(root != null) {
				this.val = root.val;
				this.left = new TreeNode(root.left);
				this.right = new TreeNode(root.right);
			}
		}
	}

	public TreeNode getRoot() {
		return new TreeNode(root);
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
		
		
		System.out.println("Contains Node 3 :: " + bt.containsNode(3));
		System.out.println("Contains Node 2 :: " + bt.containsNode(2));
		System.out.println("Contains Node 5 :: " + bt.containsNode(5));
		System.out.println("Contains Node 6 :: " + bt.containsNode(6));
		System.out.println("Contains Node 7 :: " + bt.containsNode(7));
		System.out.println("Contains Node 8 :: " + bt.containsNode(8));
		
		System.out.println("*** In Order ***");
		bt.traverseInOrder(bt.root);
		
		System.out.println("*** Pre Order ***");
		bt.traversePreOrder(bt.root);
		
		System.out.println("*** Post Order ***");
		bt.traversePostOrder(bt.root);
		
		System.out.println("*** Level Order ***");
		bt.traverseLevelOrder();
		
		System.out.println("*** In Order without Recursion ***");
		bt.traverseInOrderWithoutRecursion();
		
		System.out.println("*** Pre Order without Recursion ***");
		bt.traversePreOrderWithoutRecursion();
	}
}
