import java.util.ArrayList;
import java.util.Stack;

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
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(1);
		System.out.println(new PathSumII().pathSum(root, 4));
	}
	
	public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    	if (root == null) return result;
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	Stack<TreeNode> st = new Stack<TreeNode>();
    	Stack<Integer> slevel = new Stack<Integer>();
    	st.push(root);
    	slevel.add(0);
    	while (!st.isEmpty()){
    		TreeNode nt = st.pop();
    		int level = slevel.pop();
    		while (list.size() > level){
    			sum += list.get(list.size() - 1);
    			list.remove(list.size() - 1);
    		}
    		list.add(nt.val);
    		sum -= nt.val;
    		if (nt.left == null && nt.right == null){
    			if (sum == 0) result.add((ArrayList<Integer>) list.clone());
    		}
    		if (nt.left != null){
    			st.push(nt.left);
    			slevel.push(level + 1);
    		}
    		if (nt.right != null){
    			st.push(nt.right);
    			slevel.push(level + 1);
    		}	
    	}
    	return result;
    }

}
