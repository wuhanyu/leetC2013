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
        
        //O(n) space, O(n) time
        if (head == null) return null;
        //create
        RandomListNode nhead = new RandomListNode(head.label);
        RandomListNode p = head;
        RandomListNode np = nhead;
        RandomListNode next;
        ArrayList<RandomListNode> ori = new ArrayList<RandomListNode>();
        while (p.next != null) {
            ori.add(p);
            np.next = new RandomListNode(p.next.label);
            next = p.next;
            p.next = np;
            np.random = p;
            p = next;
            np = np.next;
        } 
        ori.add(p);
        p.next = np;
        np.random = p;
        //create link
        np = nhead;
        while (np != null) {
            if (np.random.random != null)
                np.random = np.random.random.next;
            else
                np.random = null;
            np = np.next;
        }
        //restore
        for (int i = 0; i < ori.size() - 1; i++){
            ori.get(i).next = ori.get(i + 1);
        }
        ori.get(ori.size() - 1).next = null;
        return nhead;
    }
}
