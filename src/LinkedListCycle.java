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
 //Floyd's cycle-finding algorithm
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode p = head;
        ListNode q = head.next;
        while (q != null && q.next != null) {
            if (p == q) return true;
            p = p.next;
            q = q.next.next;
        }
        return false;
    }
}
