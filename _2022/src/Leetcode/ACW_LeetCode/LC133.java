package Leetcode.ACW_LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC133 {
    Map<Node, Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        Node copy = new Node(node.val);
        map.put(node, copy);
        for (Node nei: node.neighbors) {
            if (!map.containsKey(nei)) {
                cloneGraph(nei);
            }
            copy.neighbors.add(map.get(nei));
        }
        return map.get(node);
    }

    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
