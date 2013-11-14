/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BinaryTreePostorderTraversal {
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (root == null) return result;
        Stack<TreeNode> st = new Stack<TreeNode>();
        st.push(root);
        TreeNode last = null;
        while (!st.isEmpty()) {
            TreeNode e = st.peek();
            if (e.left != null && e.left != last && (e.right == null || e.right != last)) {
                st.push(e.left);
            } else if (e.right != null && e.right != last) {
                st.push(e.right);
            } else {
                st.pop();
                result.add(e.val);
                last = e;
            }
        }
        return result;
    }
}
