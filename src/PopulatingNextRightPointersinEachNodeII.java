/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class PopulatingNextRightPointersinEachNodeII {
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        if (root.left != null && root.right != null) {
            root.left.next = root.right;
        }
        TreeLinkNode cur = root.left;
        if (root.right != null) cur = root.right;
        if (cur != null) {
            TreeLinkNode p = root.next;
            while (p != null) {
                if (p.left != null) {
                    cur.next = p.left;
                    break;
                } else if (p.right != null) {
                    cur.next = p.right;
                    break;
                }
                p = p.next;
            }
        }
        connect(root.right);
        connect(root.left);
    }
}
