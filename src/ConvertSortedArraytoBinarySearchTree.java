/**
 * 
 */

/**
 * @author Simon@itechs
 * @see http://leetcode.com/onlinejudge#question_108
 * @problem Given an array where elements are sorted in ascending order, convert
 *          it to a height balanced BST.
 */
public class ConvertSortedArraytoBinarySearchTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public TreeNode sortedArrayToBST(int[] num) {
        if (num.length == 0) return null;
        TreeNode root = constructTree(num, 0, num.length - 1);
        return root;
    }
    
    TreeNode constructTree(int[] num, int start, int end){
    	if (start > end) return null;
    	int m = (start + end) / 2;
    	TreeNode root = new TreeNode(num[m]);
    	root.left = constructTree(num, start, m - 1);
    	root.right = constructTree(num, m + 1, end);
    	return root;
    }

}
