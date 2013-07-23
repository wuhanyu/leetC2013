/**
 * @author Simon@itechs
 * @see http://leetcode.com/onlinejudge#question_98
 * @problem Given a binary tree, determine if it is a valid binary search tree
 *          (BST).
 * 
 *          Assume a BST is defined as follows:
 * 
 *          The left subtree of a node contains only nodes with keys less than
 *          the node's key. The right subtree of a node contains only nodes with
 *          keys greater than the node's key. Both the left and right subtrees
 *          must also be binary search trees.
 */
public class ValidateBinarySearchTree {
	public static void main(String[] args){
		TreeNode root = new TreeNode(0);
		root.left = new TreeNode(-1);
		System.out.println(new ValidateBinarySearchTree().isValidBST(root));
	}
	static int last;
	public boolean isValidBST(TreeNode root) {
		last = Integer.MIN_VALUE;
		return isValid(root);
	}
	
    public boolean isValid(TreeNode root) {
    	if (root == null) return true;
    	if (!isValid(root.left)) return false;
    	if (root.val <= last) return false;
    	last = root.val;
    	if (!isValid(root.right)) return false;
    	return true;
    }
}
