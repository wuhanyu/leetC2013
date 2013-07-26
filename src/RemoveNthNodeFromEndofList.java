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
        ListNode[] tmp = new ListNode[n + 1];
        ListNode p = head;
        for (int i = 0; i < n; i++){
            tmp[i] = p;
            p = p.next;
        }
        if (p == null) {
            head = head.next;
        } else {
            tmp[n] = p;
            p = p.next;
            while (p != null){
                for (int i = 0; i <= n; i++){
                    tmp[i] = tmp[i].next;
                }
                p = p.next;
            }
            tmp[0].next = tmp[1].next;
        }
        return head;
    }
}
