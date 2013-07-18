import java.util.ArrayList;

/**
 * 
 */

/**
 * @author Simon@itechs
 * @see http://leetcode.com/onlinejudge#question_117
 * @problem Follow up for problem "Populating Next Right Pointers in Each Node".
 * 
 *          What if the given tree could be any binary tree? Would your previous
 *          solution still work?
 * 
 *          Note:
 * 
 *          You may only use constant extra space. For example, Given the
 *          following binary tree,
 * 
 *          1 / \ 2 3 / \ \ 4 5 7 After calling your function, the tree should
 *          look like:
 * 
 *          1 -> NULL / \ 2 -> 3 -> NULL / \ \ 4-> 5 -> 7 -> NULL
 */
public class PopulatingNextRightPointersinEachNodeII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeLinkNode root = new TreeLinkNode(1);
		TreeLinkNode left = new TreeLinkNode(2);
		TreeLinkNode ll = new TreeLinkNode(3);
		TreeLinkNode lr = new TreeLinkNode(3);
		root.left = left;
		left.left = ll;
		left.right = lr;
		new PopulatingNextRightPointersinEachNodeII().connect(root);
	}

	public void connect(TreeLinkNode root) {
		if (root == null || (root.left == null && root.right == null))
			return;
		
		TreeLinkNode t = null;
		TreeLinkNode next = null;
		if (root.left != null && root.right != null){
			root.left.next = root.right;
			t = root.right;
		} else if (root.left != null){
			t = root.left;
		} else {
			t = root.right;
		}
		next = root.next;
		while (next != null && next.left == null && next.right == null) next = next.next;
		if (next != null){
			if (next.left != null) t.next = next.left;
			else t.next = next.right;
		}
		connect(root.right);
		connect(root.left);
		
	}
}
