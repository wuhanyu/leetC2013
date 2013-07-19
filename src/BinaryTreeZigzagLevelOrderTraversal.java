import java.util.ArrayList;

/**
 * 
 */

/**
 * @author Simon
 * @see http://leetcode.com/onlinejudge#question_103
 * @problem Given a binary tree, return the zigzag level order traversal of its
 *          nodes' values. (ie, from left to right, then right to left for the
 *          next level and alternate between).
 * 
 *          For example: Given binary tree {3,9,20,#,#,15,7},
 * 
 *          3 / \ 9 20 / \ 15 7 return its zigzag level order traversal as:
 * 
 *          [ [3], [20,9], [15,7] ]
 */
public class BinaryTreeZigzagLevelOrderTraversal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		traversal(root, 1, result);
		return result;
    }

	void traversal(TreeNode e, int level, ArrayList<ArrayList<Integer>> result) {
		if (e == null)
			return;
		while (result.size() < level)
			result.add(new ArrayList<Integer>());
		if (level % 2 == 1)
			result.get(level - 1).add(e.val);
		else
			result.get(level - 1).add(0, e.val);
		traversal(e.left, level + 1, result);
		traversal(e.right, level + 1, result);
	}

}
