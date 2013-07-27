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
public class SwapNodesinPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null) return head;
        ListNode last = head;
        ListNode cur = head.next;
        ListNode next = null;
        if (cur != null){
            next = cur.next;
            head = cur;
            cur.next = last;
            last.next = next;
        }
        while (next != null){
            cur = next;
            next = next.next;
            if (next != null){
                last.next = next;
                cur.next = next.next;
                last = cur;
                next.next = cur;
                next = last.next;
            }
        }
        return head;
    }
}
