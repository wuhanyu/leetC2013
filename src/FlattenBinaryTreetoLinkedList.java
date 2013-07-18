/**
 * 
 */

/**
 * @author Simon@itechs
 * @see http://leetcode.com/onlinejudge#question_114
 * @problem Given a binary tree, flatten it to a linked list in-place.
 * 
 *          For example, Given
 * 
 *          1 / \ 2 5 / \ \ 3 4 6 The flattened tree should look like: 1 \ 2 \ 3
 *          \ 4 \ 5 \ 6 Hints: If you notice carefully in the flattened tree,
 *          each node's right child points to the next node of a pre-order
 *          traversal.
 */
public class FlattenBinaryTreetoLinkedList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public void flatten(TreeNode root) {
        if (root == null) return;
        TreeNode left = root.left;
        TreeNode right = root.right;
        if (left != null){
        	root.right = root.left;
        	root.left = null;
        	TreeNode rightmost = left;
        	while(rightmost.right != null) rightmost = rightmost.right;
        	rightmost.right = right;
        }
        flatten(root.right);
    }
}
