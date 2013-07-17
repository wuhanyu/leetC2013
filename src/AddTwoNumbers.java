/**
 * 
 */

/**
 * @author Simon
 * @see http://leetcode.com/onlinejudge#question_2
 * @problem You are given two linked lists representing two non-negative
 *          numbers. The digits are stored in reverse order and each of their
 *          nodes contain a single digit. Add the two numbers and return it as a
 *          linked list.
 * 
 *          Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8
 * 
 *          public class ListNode { int val; ListNode next; ListNode(int x) {
 *          val = x; next = null; } }
 */
public class AddTwoNumbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ListNode head = new ListNode((l1.val + l2.val) % 10);
		int plus = (l1.val + l2.val) / 10;
		ListNode ln = head;
		l1 = l1.next;
		l2 = l2.next;
		ListNode newnode;
		while (l1 != null && l2 != null){
			newnode = new ListNode((l1.val + l2.val + plus) % 10);
			plus = (l1.val + l2.val + plus) / 10;
			ln.next = newnode;
			ln = ln.next;
			l1 = l1.next;
			l2 = l2.next;
		}
		while (l1 != null && l2 == null){
			newnode = new ListNode((l1.val + plus) % 10);
			plus = (l1.val + plus) / 10;
			ln.next = newnode;
			ln = ln.next;
			l1 = l1.next;
		}
		
		while (l2 != null && l1 == null){
			newnode = new ListNode((l2.val + plus) % 10);
			plus = (l2.val + plus) / 10;
			ln.next = newnode;
			ln = ln.next;
			l2 = l2.next;
		}
		if (plus > 0){
			newnode = new ListNode(plus);
			ln.next = newnode;
		}
		return head;
	}

}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}
