package medium;

public class DiameterOfBinaryTree {
	public int diameterOfBinaryTree(TreeNode root) {
		TreeNode temp = root;
		if (temp == null) {
			return 0;
		}

		int maxLeftLength = nodeLength(root.left);
		int maxRightLength = nodeLength(root.right);

		return maxLeftLength + maxRightLength;
	}

	private int nodeLength(TreeNode node) {
		int length = 0;
		if (node == null) {
			return 0;
		}

		int leftLength = 0;
		if (node.left != null) {
			leftLength += nodeLength(node.left);
		}

		int rightLength = 0;
		if (node.right != null) {
			rightLength += nodeLength(node.right);
		}

		length = Math.max(leftLength, rightLength);

		return length;
	}
	
	public static void main(String[] args) {
		DiameterOfBinaryTree main = new DiameterOfBinaryTree();
        TreeNode node = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        node.left = left;
        node.right = right;
        left.left = new TreeNode(4);
        left.right = new TreeNode(5);
        
        System.out.println(main.diameterOfBinaryTree(node));
    }
}