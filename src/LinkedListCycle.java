/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode p = head.next;
        while (p != null && p != head) {
            ListNode next = p.next;
            p.next = head;
            p = next;
        }
        if (p == head) return true;
        else return false;
    }
}
