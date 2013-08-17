/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> left = new Stack<TreeNode>();
        Stack<TreeNode> right = new Stack<TreeNode>();
        left.push(root.left);
        right.push(root.right);
        while (!left.isEmpty() && !right.isEmpty()){
            TreeNode l = left.pop();
            TreeNode r = right.pop();
            if (l == null && r == null) continue;
            if (l == null || r == null) return false;
            if (l.val == r.val) {
                left.push(l.left);
                right.push(r.right);
                left.push(l.right);
                right.push(r.left);
            } else {
                return false;
            }
        }
        return true;
    }
}
