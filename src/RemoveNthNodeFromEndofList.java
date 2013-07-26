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
public class RemoveNthNodeFromEndofList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p = head;
        ListNode last = head;
        for (int i = 0; i < n; i++) p = p.next;
        if (p == null){
            head = head.next;
        } else {
            p = p.next;
            while (p != null){
                last = last.next;
                p = p.next;
            }
            last.next = last.next.next;
        }
        return head;
    }
}
