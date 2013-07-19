import java.util.ArrayList;

/**
 * 
 */

/**
 * @author Simon@itechs
 * @see http://leetcode.com/onlinejudge#question_107
 * @problem Given a binary tree, return the bottom-up level order traversal of
 *          its nodes' values. (ie, from left to right, level by level from leaf
 *          to root).
 * 
 *          For example: Given binary tree {3,9,20,#,#,15,7},
 * 
 *          3 / \ 9 20 / \ 15 7 return its bottom-up level order traversal as:
 * 
 *          [ [15,7] [9,20], [3], ]
 * 
 *          OJ's Binary Tree Serialization: The serialization of a binary tree
 *          follows a level order traversal, where '#' signifies a path
 *          terminator where no node exists below.
 * 
 *          Here's an example:
 * 
 *          1 / \ 2 3 / 4 \ 5 The above binary tree is serialized as
 *          "{1,2,3,#,#,4,#,#,5}".
 */
public class BinaryTreeLevelOrderTraversalII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        traversal(root, 1, result);
        ArrayList<ArrayList<Integer>> newresult = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < result.size(); i++) newresult.add(0, result.get(i));
        return newresult;
    }
    
    void traversal(TreeNode e, int level, ArrayList<ArrayList<Integer>> result){
    	if (e == null) return;
    	while (result.size() < level) result.add(new ArrayList<Integer>());
    	result.get(level - 1).add(e.val);
    	traversal(e.left, level + 1, result);
    	traversal(e.right, level + 1, result);
    }
}
