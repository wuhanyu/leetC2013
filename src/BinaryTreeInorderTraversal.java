import java.util.ArrayList;
import java.util.Stack;

/**
 * 
 */

/**
 * @author Simon@itechs
 * @see http://leetcode.com/onlinejudge#question_93
 * @problem Given a binary tree, return the inorder traversal of its nodes'
 *          values.
 * 
 *          For example: Given binary tree {1,#,2,3},
 * 
 *          1 \ 2 / 3 return [1,3,2].
 * 
 *          Note: Recursive solution is trivial, could you do it iteratively?
 */
public class BinaryTreeInorderTraversal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ArrayList<Integer> inorderTraversal(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (root == null)
			return result;
		Stack<TreeNode> s = new Stack<TreeNode>();
		s.push(root);
		while (root.left != null) {
			root = root.left;
			s.push(root);
		}
		while (!s.isEmpty()) {
			TreeNode e = s.pop();
			result.add(e.val);
			if (e.right != null) {
				e = e.right;
				s.push(e);
				while (e.left != null) {
					e = e.left;
					s.push(e);
				}
			}

		}
		return result;
	}

}
