import java.util.ArrayList;

/**
 * @author Simon@itechs
 * @see http://leetcode.com/onlinejudge#question_113
 * @problem Given a binary tree and a sum, find all root-to-leaf paths where
 *          each path's sum equals the given sum.
 * 
 *          For example: Given the below binary tree and sum = 22, 5 / \ 4 8 / /
 *          \ 11 13 4 / \ / \ 7 2 5 1 return
 * 
 *          [ [5,4,11,2], [5,8,4,5] ]
 */
public class PathSumII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    	findPathSum(root, sum, new ArrayList(), result);
    	return result;
    }

	public void findPathSum(TreeNode root, int sum, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> result) {
		if (root == null) return;
		if (root.left == null && root.right == null) {
			if (root.val == sum){
				list.add(root.val);
				result.add((ArrayList<Integer>) list.clone());
				list.remove(list.size() - 1);
			}
		} else {
			list.add(root.val);
			findPathSum(root.left, sum - root.val, list, result);
			findPathSum(root.right, sum - root.val, list, result);
			list.remove(list.size() - 1);
		}
	}

}
