import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 */

/**
 * @author Simon
 * @see http://leetcode.com/onlinejudge#question_111
 * @problem Given a binary tree, find its minimum depth.
 * 
 *          The minimum depth is the number of nodes along the shortest path
 *          from the root node down to the nearest leaf node.
 */
public class MinimumDepthofBinaryTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public int minDepth(TreeNode root) {
    	if (root == null) return 0;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        Queue<Integer> ql = new LinkedList<Integer>();
        q.add(root);
        ql.add(0);
        while (!q.isEmpty()){
        	TreeNode tn = q.poll();
        	int level = ql.poll();
        	if (tn.left == null && tn.right == null) return level;
        	if (tn.left != null){
        		q.add(tn.left);
        		ql.add(level + 1);
        	}
        	if (tn.right != null){
        		q.add(tn.right);
        		ql.add(level + 1);
        	}
        }
        return 0;
    }
}
