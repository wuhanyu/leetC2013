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
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode p = null;
        while (l1 != null || l2 != null) {
            int n1 = (l1 == null ? Integer.MAX_VALUE : l1.val);
            int n2 = (l2 == null ? Integer.MAX_VALUE : l2.val);
            if (n1 < n2) {
                if (head == null) {
                    head = l1;
                    p = l1;
                    l1 = l1.next;
                } else {
                    p.next = l1;
                    p = p.next;
                    l1 = l1.next;
                }
            } else {
                if (head == null) {
                    head = l2;
                    p = l2;
                    l2 = l2.next;
                } else {
                    p.next = l2;
                    p = p.next;
                    l2 = l2.next;
                }
            }
        }
        
        return head;
    }
    
}
