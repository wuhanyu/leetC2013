/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode head = null;
        ListNode pre = null;
        int plus = 0;
        while (p1 != null || p2 != null){
            int i1 = (p1 != null) ? p1.val : 0;
            int i2 = (p2 != null) ? p2.val : 0;
            int val = (i1 + i2 + plus) % 10;
            plus = (i1 + i2 + plus) / 10;
            if (head == null) {
                head = new ListNode(val);
                pre = head;
            } else {
                pre.next = new ListNode(val);
                pre = pre.next;
            }
            if (p1 != null) p1 = p1.next;
            if (p2 != null) p2 = p2.next;
        }
        if (plus > 0) pre.next = new ListNode(plus);
        return head;
    }
}
