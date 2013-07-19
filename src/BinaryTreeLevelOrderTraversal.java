import java.util.ArrayList;

/**
 * 
 */

/**
 * @author Simon@itechs
 * @see http://leetcode.com/onlinejudge#question_102
 * @problem Given a binary tree, return the level order traversal of its nodes'
 *          values. (ie, from left to right, level by level).
 * 
 *          For example: Given binary tree {3,9,20,#,#,15,7},
 * 
 *          3 / \ 9 20 / \ 15 7 return its level order traversal as:
 * 
 *          [ [3], [9,20], [15,7] ]
 */
public class BinaryTreeLevelOrderTraversal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		traversal(root, 1, result);
		return result;
	}

	void traversal(TreeNode e, int level, ArrayList<ArrayList<Integer>> result) {
		if (e == null)
			return;
		while (result.size() < level)
			result.add(new ArrayList<Integer>());
		result.get(level - 1).add(e.val);
		traversal(e.left, level + 1, result);
		traversal(e.right, level + 1, result);
	}
}
