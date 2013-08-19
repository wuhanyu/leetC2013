/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class PathSumIteratively {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        root.val = sum - root.val;
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode e = stack.pop();
            if (e.left == null && e.right == null && e.val == 0) return true;
            if (e.left != null){
                e.left.val = e.val - e.left.val;
                stack.push(e.left);
            }
            if (e.right != null){
                e.right.val = e.val - e.right.val;
                stack.push(e.right);
            }
        }
        return false;
    }
}
