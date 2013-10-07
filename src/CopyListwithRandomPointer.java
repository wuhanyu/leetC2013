/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class CopyListwithRandomPointer {
    public RandomListNode copyRandomList(RandomListNode head) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        
        //O(1) extra space, O(n) time
        if (head == null) return null;
        //Create the copy of node 1 and insert it between node 1 & node 2 in original Linked List, create the copy of 2 and insert it between 2 & 3.. Continue in this fashion, add the copy of N afte the Nth node
        RandomListNode p = head;
        while (p != null) {
            RandomListNode copy = new RandomListNode(p.label);
            copy.next = p.next;
            p.next = copy;
            p = copy.next;
        }
        RandomListNode nhead = head.next;
        //add link: original->next->arbitrary = original->arbitrary->next;
        p = head;
        while (p != null) {
            if (p.random != null)
                p.next.random = p.random.next;
            p = p.next.next;
        }
        //resotre:original->next = original->next->next;copy->next = copy->next->next;
        p = head;
        RandomListNode np = nhead;
        while (np.next != null) {
            p.next = np.next;
            p = p.next;
            np.next = p.next;
            np = np.next;
        }
        p.next = null;
        return nhead;
    }
}
