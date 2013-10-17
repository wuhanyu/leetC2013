/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BinaryTreeLevelOrderTraversal {
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (root == null) return result;
        ArrayList<TreeNode> cur = new ArrayList<TreeNode>();
        cur.add(root);
        while (cur.size() > 0) {
            ArrayList<Integer> line = new ArrayList<Integer>();
            ArrayList<TreeNode> children = new ArrayList<TreeNode>();
            for (int i = 0; i < cur.size(); i++) {
                TreeNode e = cur.get(i);
                line.add(e.val);
                if (e.left != null) children.add(e.left);
                if (e.right != null) children.add(e.right);
            }
            result.add(line);
            cur = children;
        }
        return result;
    }
}
