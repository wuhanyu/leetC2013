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
public class ReorderList {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode p = head;
        ListNode q = head.next;
        while (q != null && q.next != null) {
            p = p.next;
            q = q.next.next;
        }
        
        ListNode pivot = p;
        ListNode rhead = reverse(pivot.next);
        pivot.next = null;
        
        p = head;
        q = rhead;
        while (p != null && q != null) {
            ListNode qnext = q.next;
            q.next = p.next;
            p.next = q;
            p = q.next;
            q = qnext;
        }
    }
    
    ListNode reverse(ListNode head) {
        if (head == null) return null;
        ListNode p = head;
        ListNode cur = null;
        while (p != null) {
            ListNode next = p.next;
            p.next = cur;
            cur = p;
            p = next;
        }
        return cur;
    }
}
