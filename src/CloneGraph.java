/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class CloneGraph {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        HashMap<Integer, UndirectedGraphNode> dict = new HashMap<Integer, UndirectedGraphNode>();
        return cloneGraph(node, dict);
    }
    
    UndirectedGraphNode cloneGraph(UndirectedGraphNode node, HashMap<Integer, UndirectedGraphNode> dict) {
        if (node == null) return null;
        if (dict.containsKey(node.label)) {
            return dict.get(node.label);
        } else {
            UndirectedGraphNode newnode = new UndirectedGraphNode(node.label);
            dict.put(node.label, newnode);
            for (int i = 0; i < node.neighbors.size(); i++) {
                newnode.neighbors.add(cloneGraph(node.neighbors.get(i), dict));
            }
            return newnode;
        }
    }
}
