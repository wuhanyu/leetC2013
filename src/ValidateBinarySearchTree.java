/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> st = new Stack<TreeNode>();
        int val = Integer.MIN_VALUE;
        while (!st.isEmpty() || root != null) {
            if (root != null) {
                st.push(root);
                root = root.left;
            } else {
                root = st.pop();
                if (root.val <= val) return false;
                val = root.val;
                root = root.right;
            }
        }
        return true;
    }
}
