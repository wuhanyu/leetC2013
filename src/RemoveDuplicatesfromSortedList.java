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
public class RemoveDuplicatesfromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        ListNode last = head;
        ListNode p = head.next;       
        while (p != null){
            if (last.val == p.val){
                ListNode next = p.next;
                last.next = p.next;
                p = next;
            } else {
                last = p;
                p = p.next;
            }
        }
        return head;
    }
}
