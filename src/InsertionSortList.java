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
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) return head;
        ListNode minhead = getMin(head);
        if (head == minhead) head = head.next;
        ListNode p = minhead;
        while (head != null) {
            p.next= getMin(head);
            p = p.next;
            if (head == p) head = head.next;
        }
        return minhead;
    }
    
    ListNode getMin(ListNode head) {
        if (head == null) return head;
        ListNode min = head;
        ListNode minpre = null;
        ListNode p = head.next;
        ListNode pre = head;
        while (p != null){
            if (p.val < min.val){
                minpre = pre;
                min = p;
            }
            pre = p;
            p = p.next;
        }
        if (minpre != null) minpre.next = min.next;
        return min;
    }
}
