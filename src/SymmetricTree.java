/**
 * 
 */

/**
 * @author Simon
 * @see http://leetcode.com/onlinejudge#question_101
 * @problem Given a binary tree, check whether it is a mirror of itself (ie,
 *          symmetric around its center).
 * 
 *          For example, this binary tree is symmetric:
 * 
 *          1 / \ 2 2 / \ / \ 3 4 4 3 But the following is not:
 * 
 *          1 / \ 2 2 \ \ 3 3 Note: Bonus points if you could solve it both
 *          recursively and iteratively.
 */
public class SymmetricTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public boolean isSymmetric(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (root == null) return true;
        String[] left = getTree(root.left).split(":");
        String[] right = getTree(root.right).split(":");
        if (left.length != right.length) return false;
        for (int i = 0; i < left.length; i++){
        	if (!left[i].equals(right[right.length - i - 1])) return false;
        }
        return true;
    }
    
    public String getTree(TreeNode root){
    	if (root == null) return "#";
    	return getTree(root.left) + ":" + root.val + ":" +getTree(root.right);
    }

}
