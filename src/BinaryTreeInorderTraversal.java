/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BinaryTreeInorderTraversal{
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (root == null) return result;
        TreeNode cur = root;
        TreeNode pre = null;
        while (cur != null) {
            if (cur.right == null) {
                result.add(cur.val);
                cur = cur.left;
            } else {
                pre = cur.right;
                while (pre.left != null && pre.left != cur) pre = pre.left;
                if (pre.left == cur) {
                    result.add(cur.val);
                    pre.left = null;
                    cur = cur.left;
                } else {
                    pre.left = cur;
                    cur = cur.right;
                }
            }
        }
        Collections.reverse(result);
        return result;
    }
}
