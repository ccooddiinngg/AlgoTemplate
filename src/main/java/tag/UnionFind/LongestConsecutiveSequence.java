package tag.UnionFind;

import java.util.HashMap;
import java.util.Map;

public class LongestConsecutiveSequence {
    Map<Integer, Node> map = new HashMap<>();

    public int longestConsecutive(int[] nums) {
        for (int num : nums) {
            if (map.containsKey(num)) continue;
            map.put(num, new Node());
            if (map.containsKey(num - 1)) {
                Node p1 = find(map.get(num - 1));
                Node p2 = find(map.get(num));
                if (p1 != p2) {
                    p1.p = p2;
                    p2.size += p1.size;
                }
            }
            if (map.containsKey(num + 1)) {
                Node p1 = find(map.get(num + 1));
                Node p2 = find(map.get(num));
                if (p1 != p2) {
                    p1.p = p2;
                    p2.size += p1.size;
                }
            }
        }
        int max = 0;
        for (Node node : map.values()) {
            max = Math.max(max, find(node).size);
        }
        return max;
    }

    Node find(Node n) {
        if (n.p != n) {
            n.p = find(n.p);
        }
        return n.p;
    }

    class Node {
        Node p;
        int size = 1;

        public Node() {
            this.p = this;
        }
    }
}
