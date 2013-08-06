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
public class ReverseNodesinKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1) return head;
        //init
        ListNode p = head;
        ListNode last = null;
        ListNode next = null;
        int i = 0;
        while (i < k && p != null){
            last = p;
            p = p.next;
            i++;
        }

        ListNode tailnext = p;
        
        if (i == k){
            p = head;
            next = p.next;
            while (next != tailnext){
                last = p;
                p = next;
                next = next.next;
                p.next = last;
            }
            head.next = reverseKGroup(tailnext, k);
            head = p;
        }
        
        return head;
    }
}
