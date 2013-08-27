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
        ListNode head = null;
        ListNode p = null;
        int carry = 0;
        while (l1 != null || l2 != null){
            int ln1 = (l1 != null)? l1.val : 0;
            int ln2 = (l2 != null)? l2.val : 0;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
            if (head == null){
                head = new ListNode((ln1 + ln2 + carry) % 10);
                p = head;
            } else {
                p.next = new ListNode((ln1 + ln2 + carry) % 10);
                p = p.next;
            }
            carry = (ln1 + ln2 + carry) / 10;
        }
        if (carry > 0) p.next = new ListNode(carry);
        return head;
    }
}
