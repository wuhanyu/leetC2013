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
public class RemoveDuplicatesfromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        ListNode lastPre = null;
        ListNode last = head;
        ListNode p = head.next;     
        while (p != null){
            if (last.val == p.val){
                while (p != null && last.val == p.val) {
                    ListNode next = p.next;
                    last.next = p.next;
                    p = next;
                }
                if (lastPre == null){
                    head = p;
                } else {
                    lastPre.next = p;
                }
                if (p != null){
                    last = p;
                    p = p.next;
                }
            } else {
                lastPre = last;
                last = p;
                p = p.next;
            }
        }
        return head;
    }
}
