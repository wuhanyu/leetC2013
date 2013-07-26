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
public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) return head;
        if (m == n) return head;
        ListNode start = head;
        ListNode p = head;
        for (int i = 0; i < m - 1; i++){
            start = p;
            p = p.next;
        }
        ListNode tail = p;
        ListNode pre = p;
        p = p.next;
        for (int i = m; i < n; i++){
            ListNode next = p.next;
            p.next = pre;
            pre = p;
            p = next;
        }    
        tail.next = p;
        if (m > 1){
            start.next = pre;
            return head;
        } else {
            return pre;
        }
    }
}
