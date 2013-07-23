public class RotateList {
    public ListNode rotateRight(ListNode head, int n) {
        if (head == null) return head;
        int length = 0;
        ListNode e = head;
        ListNode tail = head;
        while (e != null){
            length++;
            tail = e;
            e = e.next;
        }        
        n %= length;  
        if (n == 0) return head;
        n = length - n;
        e = head;
        ListNode last = head;
        for (int i = 0; i < n; i++){
            last = e;
            e = e.next;
        }
        tail.next = head;
        head = e;
        last.next = null;
        return head;
    }
}
