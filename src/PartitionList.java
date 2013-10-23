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
    public ListNode partition(ListNode head, int x) {
        ListNode nhead = new ListNode(-1);
        ListNode ncur = nhead;
        ListNode pivot = new ListNode(x);
        ListNode pcur = pivot;
        while (head != null) {
            if (head.val < x) {
                ncur.next = head;
                ncur = head;
            } else {
                pcur.next = head;
                pcur = head;
            }
            head = head.next;
        }
        ncur.next = pivot.next;
        pcur.next = null;
        return nhead.next;
    }
}
