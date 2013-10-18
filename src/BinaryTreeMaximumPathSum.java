/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BinaryTreeMaximumPathSum {
    static int max;
    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        maxPathSum2(root);
        return max;
    }
    
    public int maxPathSum2(TreeNode root) {
        if (root == null) return 0;
        int left = maxPathSum2(root.left);
        int right = maxPathSum2(root.right);
        if (left < 0) left = 0;
        if (right < 0) right = 0;
        if (max < root.val + left + right) max = root.val + left + right;
        return Math.max(left, right) + root.val;
    }
}
