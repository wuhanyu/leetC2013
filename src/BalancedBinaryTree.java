/**
 * 
 */

/**
 * @author Simon
 * @see http://leetcode.com/onlinejudge#question_110
 * @problem Given a binary tree, determine if it is height-balanced.
 * 
 *          For this problem, a height-balanced binary tree is defined as a
 *          binary tree in which the depth of the two subtrees of every node
 *          never differ by more than 1.
 */
public class BalancedBinaryTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        if (isBalanced(root.left) && isBalanced(root.right)){
        	int left = 0;
        	int right = 0;
        	if (root.left != null) left = root.left.val;
        	if (root.right != null) right = root.right.val;
        	root.val = Math.max(left, right) + 1;
        	if (Math.abs(left - right) <= 1){
        		return true;
        	}
        }
        return false;
    }

}
