/**
 * 
 */

/**
 * @author Simon
 * @see http://leetcode.com/onlinejudge#question_99
 * @problem Two elements of a binary search tree (BST) are swapped by mistake.
 * 
 *          Recover the tree without changing its structure.
 */
public class RecoverBinarySearchTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode root = new TreeNode(0);
		root.left = new TreeNode(1);
		new RecoverBinarySearchTree().recoverTree(root);
	}
	
    static TreeNode left, right;
    public void recoverTree(TreeNode root) {
        left = null;
        right = null;
        traversalL(root);
        traversalR(root);
        int t = left.val;
        left.val = right.val;
        right.val = t;
    }
    
    boolean traversalL(TreeNode e){
        if (e == null) return true;
        if (!traversalL(e.left)) return false;
        if (left == null) left = e;
        else {
            if (left.val >= e.val){
                return false;
            }
            left = e;
        }
        return traversalL(e.right);
    }
    
    boolean traversalR(TreeNode e){
        if (e == null) return true;
        if (!traversalR(e.right)) return false;
        if (right == null) right = e;
        else {
            if (right.val <= e.val){
                return false;
            }
            right = e;
        }
        return traversalR(e.left);
    }
}
