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
        //build heap
        int p = 0;
        while (p < lists.size()){
            if (lists.get(p) == null) lists.remove(p);
            else p++;
        }
        for (int i = lists.size() - 1; i >= 0; i--){
            heapify(lists, lists.size(), i);
        }
        
        //merge
        ListNode pre = null;
        while (lists.size() > 0){
            if (pre == null) {
                head = lists.get(0);
                pre = head;
            } else {
                pre.next = lists.get(0);
                pre = pre.next;
            }
            
            if (pre.next == null){
                swap(lists, 0, lists.size() - 1);
                lists.remove(lists.size() - 1);
            } else lists.set(0, pre.next);
            heapify(lists, lists.size(), 0);
        }
        return head;
    }
    
    void swap(ArrayList<ListNode> lists, int i, int j){
        ListNode tmp = lists.get(i);
        lists.set(i, lists.get(j));
        lists.set(j, tmp);        
    }
    
    void heapify(ArrayList<ListNode> lists, int size, int index){
        int larger = index;
        if (2 * index + 1 < size && lists.get(2 * index + 1).val < lists.get(larger).val) larger = 2 * index + 1;
        if (2 * index + 2 < size && lists.get(2 * index + 2).val < lists.get(larger).val) larger = 2 * index + 2;
        if (larger != index){
            swap(lists, index, larger);
            heapify(lists, size, larger);
        }
    }
}
