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
        HashMap<RandomListNode, RandomListNode> dict = new HashMap<RandomListNode, RandomListNode>();
        return copyRandomList(head, dict);
    }
    
    public RandomListNode copyRandomList(RandomListNode head, HashMap<RandomListNode, RandomListNode> dict) {
        if (head == null) return null;
        if (dict.containsKey(head)) {
            return dict.get(head);
        } else {
            RandomListNode newnode = new RandomListNode(head.label);
            dict.put(head, newnode);
            newnode.next = copyRandomList(head.next, dict);
            newnode.random = copyRandomList(head.random, dict);
            return newnode;
        }
    }
}
