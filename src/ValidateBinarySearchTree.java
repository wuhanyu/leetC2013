/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> st = new Stack<TreeNode>();
        int val = Integer.MIN_VALUE;
        while (true) {
            if (root != null) {
                st.push(root);
                root = root.left;
            } else {
                root = st.pop();
                if (root.val <= val) return false;
                val = root.val;
                root = root.right;
            }
            if (root == null && st.isEmpty()) break;
        }
        return true;
    }
}
