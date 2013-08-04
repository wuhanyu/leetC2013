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
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        if (head == null) return head;
        ListNode p = head;
        ListNode last = null;
        if (head.val < x){      
            while (p != null && p.val < x){
                last = p;
                p = p.next;
            }
            if (p != null){
                ListNode bh = p;
                last.next = p.next;
                ListNode bp = bh;
                p = p.next;
                while (p != null){
                    if (p.val < x){
                        last = p;
                    } else {
                        bp.next = p;
                        bp = p;
                        last.next = p.next;
                    }
                    p = p.next;
                }
                bp.next = null;
                last.next = bh;
            }
        } else {
             while (p != null && p.val >= x){
                last = p;
                p = p.next;
            }
            if (p != null){
                ListNode sh = p;
                last.next = p.next;
                ListNode sp = sh;
                p = p.next;
                while (p != null){
                    if (p.val >= x){
                        last = p;
                    } else {
                        sp.next = p;
                        sp = p;
                        last.next = p.next;
                    }
                    p = p.next;
                }
                sp.next = head;
                head = sh;
            }        
        }
        return head;
    }
}
