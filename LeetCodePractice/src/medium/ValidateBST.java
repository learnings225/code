package medium;

/**
 * https://leetcode.com/problems/validate-binary-search-tree/
 * 
 * 98. Validate Binary Search Tree
 * 
 * @author srimeda
 *
 */
public class ValidateBST {
//	public boolean isValidBST(TreeNode root) {
//        if(root == null) {
//        	return true;
//        }
//        
//        int val = root.val;
//        
//        if(root.left != null && val <= root.left.val) {
//        	return false;
//        }
//        
//        if(root.right != null && val >= root.right.val) {
//        	return false;
//        }
//        
//        if(!isValidBST(root.left)) return false;
//        if(!isValidBST(root.right)) return false;
//		
//        return true;
//    }
	
	public boolean helper(TreeNode node, Integer lower, Integer upper) {
		if (node == null) {
			return true;
		}

		int val = node.val;
		
		if (lower != null && val <= lower) {
			return false;
		}
		
		if (upper != null && val >= upper) {
			return false;
		}

		if (!helper(node.right, val, upper)) {
			return false;
		}
		
		if (!helper(node.left, lower, val)) {
			return false;
		}
		
		return true;
	}

	public boolean isValidBST(TreeNode root) {
		return helper(root, null, null);
	}

	public static void main(String[] args) {
		ValidateBST main = new ValidateBST();
        TreeNode node = new TreeNode(10);
        TreeNode left = new TreeNode(5);
        TreeNode right = new TreeNode(15);
        node.left = left;
        node.right = right;
        right.left = new TreeNode(6);
        right.right = new TreeNode(20);
        
        System.out.println(main.isValidBST(node));
    }
}