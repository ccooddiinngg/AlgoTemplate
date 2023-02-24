package Leetcode.Coding_Interview_6.C17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class S07 {
    public String[] trulyMostPopular(String[] names, String[] synonyms) {
        Map<String, Node> map = new HashMap<>();
        for (String str : synonyms) {
            String[] t = str.substring(1, str.length() - 1).split(",");
            for (String s : t) {
                if (!map.containsKey(s)) {
                    map.put(s, new Node(s));
                }
            }
            union(map.get(t[0]), map.get(t[1]));
        }
        List<String> list = new ArrayList<>();
        Map<String, Integer> countMap = new HashMap<>();
        for (String str : names) {
            String[] t = str.substring(0, str.length() - 1).split("\\(");
            String name = t[0];
            int count = Integer.parseInt(t[1]);
            if (!map.containsKey(name)) {
                list.add(str);
            } else {
                Node node = map.get(name);
                //! don't forget use find() to find p , not just use node.p
                Node p = find(node);
                countMap.put(p.name, countMap.getOrDefault(p.name, 0) + count);
            }
        }
        for (String key : countMap.keySet()) {
            String str = key + "(" + countMap.get(key) + ")";
            list.add(str);
        }
        String[] res = new String[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    class Node {
        String name;
        Node p;

        public Node(String name) {
            this.name = name;
            p = this;
        }
    }

    Node find(Node node) {
        if (node.p != node) {
            node.p = find(node.p);
        }
        return node.p;
    }

    void union(Node node1, Node node2) {
        Node p1 = find(node1);
        Node p2 = find(node2);
        if (p1 != p2) {
            if (p1.name.compareTo(p2.name) < 0) {
                p2.p = p1;
            } else {
                p1.p = p2;
            }
        }
    }

    boolean sameSet(Node node1, Node node2) {
        Node p1 = find(node1);
        Node p2 = find(node2);
        return p1 == p2;
    }
}
