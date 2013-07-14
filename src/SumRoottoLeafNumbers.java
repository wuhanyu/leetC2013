/**
 * 
 */

/**
 * @author Simon@itechs
 * @see http://leetcode.com/onlinejudge#question_129
 * @problem Given a binary tree containing digits from 0-9 only, each
 *          root-to-leaf path could represent a number.
 * 
 *          An example is the root-to-leaf path 1->2->3 which represents the
 *          number 123.
 * 
 *          Find the total sum of all root-to-leaf numbers.
 * 
 *          For example,
 * 
 *          1 / \ 2 3 The root-to-leaf path 1->2 represents the number 12. The
 *          root-to-leaf path 1->3 represents the number 13.
 * 
 *          Return the sum = 12 + 13 = 25.
 * 
 */
public class SumRoottoLeafNumbers {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static int sum = 0;
	
    public int sumNumbers(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        sum = 0;
        if (root == null) return 0;
        traversal(root, 0);
        return sum;
    }
    
    void traversal(TreeNode e, int parent){
    	int val = parent * 10 + e.val;
    	if (e.left == null && e.right == null){
    		sum += val;
    	} else {
    		if (e.left != null) traversal(e.left, val);
    		else traversal(e.right, val);
    	}
    }
}
