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
    static int pi;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        pi = 0;
        return buildTree(preorder, inorder, 0, inorder.length - 1);
    }
    
    public TreeNode buildTree(int[] preorder, int[] inorder, int is, int ie){
        if (is <= ie){
            TreeNode root = new TreeNode(preorder[pi]);
            int mid = getIndex(inorder, preorder[pi]);
            pi++;                       
            root.left = buildTree(preorder, inorder, is, mid - 1);
            root.right = buildTree(preorder, inorder, mid + 1, ie);
            return root;
        }
        return null;
    }
    
    int getIndex(int[] array, int num){
        for (int i = 0; i < array.length; i++){
            if (array[i] == num) return i;
        }
        return -1;
    }
}
