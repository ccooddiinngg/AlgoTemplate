package tag.UnionFind;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//面试题 17.07. Baby Names LCCI
public class BabyNames {
    public String[] trulyMostPopular(String[] names, String[] synonyms) {
        Map<String, Integer> map = new HashMap<>();
        Map<String, Node> uf = new HashMap<>();
        for (String str : names) {
            int i1 = str.indexOf("(");
            int i2 = str.indexOf(")");
            String a = str.substring(0, i1);
            int b = Integer.parseInt(str.substring(i1 + 1, i2));
            map.put(a, map.getOrDefault(a, 0) + b);
            uf.put(a, new Node(a));
        }

        for (String str : synonyms) {
            String[] s = str.substring(1, str.length() - 1).split(",");
            uf.putIfAbsent(s[0], new Node(s[0]));
            uf.putIfAbsent(s[1], new Node(s[1]));
            Node p0 = find(uf.get(s[0]));
            Node p1 = find(uf.get(s[1]));
            if (p0 != p1) {
                if (p0.s.compareTo(p1.s) < 0) {
                    p1.p = p0;
                } else {
                    p0.p = p1;
                }
            }
        }

        Map<String, Integer> count = new HashMap<>();
        for (String key : map.keySet()) {
            Node p = find(uf.get(key));
            count.put(p.s, count.getOrDefault(p.s, 0) + map.get(key));
        }
        List<String> list = new ArrayList<>();
        for (String key : count.keySet()) {
            StringBuilder sb = new StringBuilder();
            sb.append(key).append("(").append(count.get(key)).append(")");
            list.add(sb.toString());
        }
        return list.toArray(new String[list.size()]);
    }

    Node find(Node node) {
        if (node.p != node) {
            node.p = find(node.p);
        }
        return node.p;
    }

    class Node {
        Node p;
        String s;

        public Node(String s) {
            this.p = this;
            this.s = s;
        }
    }
}
