/**
 * 
 */

/**
 * @author Simon@itechs
 * @see http://leetcode.com/onlinejudge#question_112
 * @problem Given a binary tree and a sum, determine if the tree has a
 *          root-to-leaf path such that adding up all the values along the path
 *          equals the given sum.
 * 
 *          For example: Given the below binary tree and sum = 22, 5 / \ 4 8 / /
 *          \ 11 13 4 / \ \ 7 2 1 return true, as there exist a root-to-leaf
 *          path 5->4->11->2 which sum is 22.
 */
public class PathSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.left == null && root.right == null){
        	if (root.val == sum) return true;
        } else {
        	if (hasPathSum(root.left, sum - root.val)) return true;
        	if (hasPathSum(root.right, sum - root.val)) return true;
        }
        return false;
    }

}
