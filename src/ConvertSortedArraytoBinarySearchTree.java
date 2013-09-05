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
    int pi;
    public TreeNode sortedArrayToBST(int[] num) {
        pi = 0;
        return buildTree(num, 0, num.length - 1);
    }
    
    TreeNode buildTree(int[] num, int start, int end){
        if (start > end) return null;
        int mid = start + (end - start) / 2;
        TreeNode left = buildTree(num, start, mid - 1);
        TreeNode root = new TreeNode(num[pi]);
        pi++;
        root.left = left;
        root.right = buildTree(num, mid + 1, end);
        return root;
    }
}
