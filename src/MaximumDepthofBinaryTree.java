/**
 * 
 */

/**
 * @author Simon
 * @see http://leetcode.com/onlinejudge#question_104
 * @problem Given a binary tree, find its maximum depth.
 * 
 *          The maximum depth is the number of nodes along the longest path from
 *          the root node down to the farthest leaf node.
 */
public class MaximumDepthofBinaryTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

}
