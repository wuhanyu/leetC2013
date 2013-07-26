import java.util.ArrayList;

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
public class MergekSortedLists {
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        ListNode head = null;
        ListNode cur = null;
        while (true){
            ListNode min = null;
            int mini = -1;
            for (int i = 0; i < lists.size(); i++){            
                ListNode e = lists.get(i);
                if (e != null){
                    if (min == null){
                        min = e;
                        mini = i;
                    }
                    else if (e.val < min.val){
                        min = e;
                        mini = i;
                    }
                }
            }
            if (min != null){
                if (head == null){
                    head = min;
                    cur = min;
                } else {
                    cur.next = min;
                    cur = min;
                }
                lists.set(mini, min.next);
            } else {
                break;
            }
        }
        return head;
    }
}
