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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        pi = postorder.length - 1;
        return buildTree(inorder, postorder, 0, inorder.length - 1);
    }
    
    public TreeNode buildTree(int[] inorder, int[] postorder, int is, int ie){
        if (is <= ie){
            TreeNode root = new TreeNode(postorder[pi]);
            int mid = getIndex(inorder, postorder[pi]);
            pi--;            
            root.right = buildTree(inorder, postorder, mid + 1, ie);
            root.left = buildTree(inorder, postorder, is, mid - 1);
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
