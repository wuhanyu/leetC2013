/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 // Morris Traversal!!
public class Solution {
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        TreeNode p = root;
        TreeNode pre = null;
        while (p != null){
            if (p.left == null) {
                result.add(p.val);
                p = p.right;
            }
            else {
                pre = getPreNode(p);
                if (pre.right == null){
                    pre.right = p;
                    p = p.left;
                } else {
                    result.add(p.val);
                    pre.right = null;
                    p = p.right;
                }
            }
        }
        return result;
    }
    
    TreeNode getPreNode(TreeNode e){
        TreeNode pre = e.left;
        while (pre.right != null && pre.right != e) pre = pre.right;
        return pre;
    }
}
