public class LRUCache {
    int size, capacity;
    HashMap<Integer, CNode> dict;
    CNode head, tail;
    public LRUCache(int capacity) {
        dict = new HashMap<Integer, CNode>();
        this.capacity = capacity;
        size = 0;
        head = new CNode(-1, -1);
        tail = new CNode(-1, -2);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (dict.containsKey(key)) {
            CNode e = dict.get(key);
            remove(e);
            addFirst(e);
            return e.val;
        }
        else return -1;
    }
    
    public void set(int key, int value) {
        if (dict.containsKey(key)) {
            CNode e = dict.get(key);
            e.val = value;
            remove(e);
            addFirst(e);
        } else {
            if (size >= capacity) {
                CNode t = getTail();
                remove(t);
                dict.remove(t.key);
            } else {
                size++;
            }
            CNode newnode = new CNode(key, value);
            addFirst(newnode);
            dict.put(key, newnode);
        }
    }
    
    void remove(CNode e) {
        e.next.prev = e.prev;
        e.prev.next = e.next;        
    }
    
    void addFirst(CNode e) {
        e.next = head.next;
        e.next.prev = e;
        head.next = e;
        e.prev = head;
    }
    
    CNode getTail() {
        return tail.prev;
    }
}

class CNode {
    int val, key;
    CNode prev, next;
    public CNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
}
