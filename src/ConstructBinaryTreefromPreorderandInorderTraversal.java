/**
 * 
 */

/**
 * @author Simon
 * @see http://leetcode.com/onlinejudge#question_105
 * @problem Given preorder and inorder traversal of a tree, construct the binary
 *          tree.
 * 
 *          Note: You may assume that duplicates do not exist in the tree.
 */
public class ConstructBinaryTreefromPreorderandInorderTraversal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] inorder = {1, 2};
		int[] preorder = {2, 1};
		new ConstructBinaryTreefromPreorderandInorderTraversal().buildTree(preorder, inorder);

	}

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = inorder.length;
        if (n == 0) return null;
        TreeNode root = new TreeNode(preorder[0]);
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
        	leftpo[i] = preorder[i + 1];
        }
        for (int i = p + 1; i < n; i++){
        	rightio[i - p - 1] = inorder[i];
        	rightpo[i - p - 1] = preorder[i];
        }
        root.left = buildTree(leftpo, leftio);
        root.right = buildTree(rightpo, rightio);
        return root; 
    }
}
