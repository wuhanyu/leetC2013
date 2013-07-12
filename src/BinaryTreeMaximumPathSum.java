import java.util.ArrayList;

/**
 * 
 */

/**
 * @author Simon@itechs 
 *         Given a binary tree, find the maximum path sum.
 * 
 *         The path may start and end at any node in the tree.
 * 
 *         For example: Given the below binary tree,
 * 
 *         1 / \ 2 3 Return 6.
 */
public class BinaryTreeMaximumPathSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	
	static int max;

	public int maxPathSum(TreeNode root) {
		if (root == null)
			return 0;
		max = root.val;
		int left = getMP(root.left);
		int right = getMP(root.right);
		max = Math.max(max, root.val + left + right);
		return max;
	}

	int getMP(TreeNode e) {
		if (e == null)
			return 0;
		max = Math.max(max, e.val);
		int left = getMP(e.left);
		int right = getMP(e.right);	
		max = Math.max(max, e.val + left + right);
		return Math.max(0, Math.max(left, right) + e.val);
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}
