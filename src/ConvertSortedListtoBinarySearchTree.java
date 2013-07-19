/**
 * 
 */

/**
 * @author Simon@itechs
 * @see http://leetcode.com/onlinejudge#question_109
 * @problem Given a singly linked list where elements are sorted in ascending
 *          order, convert it to a height balanced BST.
 * @hint http://leetcode.com/2010/11/convert-sorted-list-to-balanced-binary.html
 */
public class ConvertSortedListtoBinarySearchTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	static ListNode list;
	
    public TreeNode sortedListToBST(ListNode head) {
    	int n = 0;
    	ListNode p = head;
    	while (p != null){
    		n++;
    		p = p.next;
    	}
    	list = head;
        return constructTree(0, n - 1);
    }
    
    TreeNode constructTree(int start, int end){
    	if (start > end) return null;
    	int mid = (start + end) / 2;
    	TreeNode left = constructTree(start, mid - 1);
    	TreeNode root = new TreeNode(list.val);
    	list = list.next;
    	root.left = left;
    	root.right = constructTree(mid + 1, end);
    	return root;
    }

}
