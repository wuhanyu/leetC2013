import java.util.ArrayList;

/**
 * 
 */

/**
 * @author Simon@itechs
Given a binary tree, find the maximum path sum.

The path may start and end at any node in the tree.

For example:
Given the below binary tree,

       1
      / \
     2   3
Return 6.
 */
public class BinaryTreeMaximumPathSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	
    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        int left = getMP(root.left);
        int right = getMP(root.right);
        int result = root.val;
        result = Math.max(result, root.val + left + right);
        if (root.left != null) result = Math.max(result, left);
        if (root.right != null) result = Math.max(result, right);
        return result;
    }
    
    int getMP(TreeNode e){
        if (e == null) return 0;
    	return Math.max(getMP2(e.left), getMP2(e.right)) + e.val;
    }
    
    int getMP2(TreeNode e){
        if (e == null) return 0;
        return Math.max(0, Math.max(getMP2(e.left), getMP2(e.right)) + e.val);
    }

}

class TreeNode {
    int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
