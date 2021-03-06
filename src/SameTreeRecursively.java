/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class SameTreeRecursively {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Stack<TreeNode> ps = new Stack<TreeNode>();
        Stack<TreeNode> qs = new Stack<TreeNode>();
        ps.push(p);
        qs.push(q);
        while (!ps.isEmpty() && !qs.isEmpty()){
            TreeNode pt = ps.pop();
            TreeNode qt = qs.pop();
            if (pt == null && qt == null) continue;
            if (pt == null || qt == null) return false;
            if (pt.val == qt.val){
                ps.push(pt.left);
                ps.push(pt.right);
                qs.push(qt.left);
                qs.push(qt.right);
            } else {
                return false;
            }
        }
        return true;
    }
}
