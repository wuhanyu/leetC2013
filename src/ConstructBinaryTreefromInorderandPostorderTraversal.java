/**
 * 
 */

/**
 * @author Simon
 * @see http://leetcode.com/onlinejudge#question_106
 * @problem Given inorder and postorder traversal of a tree, construct the
 *          binary tree.
 * 
 *          Note: You may assume that duplicates do not exist in the tree.
 */
public class ConstructBinaryTreefromInorderandPostorderTraversal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] inorder = {1, 2};
		int[] postorder = {2, 1};
		new ConstructBinaryTreefromInorderandPostorderTraversal().buildTree(inorder, postorder);
	}
	
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        if (n == 0) return null;
        TreeNode root = new TreeNode(postorder[n-1]);
        int p = 0;
        while (inorder[p] != root.val){
        	p++;
        }
        int[] leftio = new int[p];
        int[] leftpo = new int[p];
        int[] rightio = new int[n - p - 1];
        int[] rightpo = new int[n - p - 1];
        for (int i = 0; i < p; i++){
        	leftio[i] = inorder[i];
        	leftpo[i] = postorder[i];
        }
        for (int i = p + 1; i < n; i++){
        	rightio[i - p - 1] = inorder[i];
        	rightpo[i - p - 1] = postorder[i - 1];
        }
        root.left = buildTree(leftio, leftpo);
        root.right = buildTree(rightio, rightpo);
        return root;
    }

}
