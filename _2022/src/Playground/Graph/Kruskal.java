package Playground.Graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Kruskal {
    public int kruskal(Graph graph) {
        List<Edge> list = new ArrayList<>();
        for (int v : graph.map.keySet()) {
            list.addAll(graph.map.get(v));
        }
        list.sort(Comparator.comparingInt(a -> a.w));
        US us = new US(graph.n);
        int addedEdges = 0;
        int res = 0;
        for (int i = 0; i < list.size(); i++) {
            Edge e = list.get(i);
            if (!us.isSameSet(e.f, e.t)) {
                us.union(e.f, e.t);
                addedEdges++;
                res += e.w;
            }
        }
        if (addedEdges == graph.n - 1) {
            return res;
        } else {
            return -1;
        }
    }

    class US {
        int[] p;

        public US(int n) {
            this.p = new int[n + 1];
            for (int i = 0; i < p.length; i++) {
                p[i] = i;
            }
        }

        private int find(int x) {
            if (p[x] != x) {
                p[x] = find(p[x]);
            }
            return p[x];
        }

        public void union(int x, int y) {
            int px = find(x);
            int py = find(y);
            if (px != py) {
                p[px] = py;
            }
        }

        public boolean isSameSet(int x, int y) {
            return find(x) == find(y);
        }
    }


}
