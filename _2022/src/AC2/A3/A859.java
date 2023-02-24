package AC2.A3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class A859 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int w = sc.nextInt();
            edges.add(new Edge(from, to, w));
        }

        kruskal(edges, n);
    }

    static void kruskal(List<Edge> edges, int n) {
        edges.sort((a, b) -> a.w - b.w);
        U u = new U(n);
        int added = 0;
        int path = 0;
        for (int i = 0; i < edges.size(); i++) {
            Edge e = edges.get(i);
            if (!u.isSameSet(e.f, e.t)) {
                u.union(e.f, e.t);
                path += e.w;
                added++;
            }
        }
        //使用每次加一条边来统计一共加入了多少条边，如果边数 == n - 1 ，那么表示所有点都在一个联通区域内
        //不能用set统计访问过的点数是否等于n来确定有没有最小生成树，有可能有多片区域不联通
        if (added == n - 1) {
            System.out.println(path);
        } else {
            System.out.println("impossible");
        }
    }

    //union set
    static class U {
        int[] p;

        public U(int n) {
            p = new int[n + 1];
            for (int i = 1; i < p.length; i++) {
                p[i] = i;
            }
        }

        int find(int i) {
            if (p[i] != i) {
                p[i] = find(p[i]);
            }
            return p[i];
        }

        boolean isSameSet(int i, int j) {
            int pi = find(i);
            int pj = find(j);
            return pi == pj;
        }

        void union(int i, int j) {
            int pi = find(i);
            int pj = find(j);
            if (pi != pj) {
                p[pi] = pj;
            }
        }
    }


    static class Edge {
        int f;
        int t;
        int w;

        public Edge(int f, int t, int w) {
            this.f = f;
            this.t = t;
            this.w = w;
        }
    }
}
