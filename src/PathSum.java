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
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        Stack<TreeNode> st = new Stack<TreeNode>();
        Stack<Integer> sumst = new Stack<Integer>();
        st.push(root);
        sumst.push(sum);
        while (!st.isEmpty()) {
            TreeNode e = st.pop();
            int esum = sumst.pop();
            if (e.left == null && e.right == null && e.val == esum) return true;
            if (e.left != null) {
                st.push(e.left);
                sumst.push(esum - e.val);
            }
            if (e.right != null) {
                st.push(e.right);
                sumst.push(esum - e.val);
            }
        }
        return false;
    }
}
