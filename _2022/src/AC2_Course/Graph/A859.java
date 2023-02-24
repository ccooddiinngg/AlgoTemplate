package AC2_Course.Graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*859. Kruskal算法求最小生成树

给定一个 n 个点 m 条边的无向图，图中可能存在重边和自环，边权可能为负数。

求最小生成树的树边权重之和，如果最小生成树不存在则输出 impossible。

给定一张边带权的无向图 G=(V,E)，其中 V 表示图中点的集合，E 表示图中边的集合，n=|V|，m=|E|。

由 V 中的全部 n 个顶点和 E 中 n−1 条边构成的无向连通子图被称为 G 的一棵生成树，其中边的权值之和最小的生成树被称为无向图 G 的最小生成树。

输入格式
第一行包含两个整数 n 和 m。

接下来 m 行，每行包含三个整数 u,v,w，表示点 u 和点 v 之间存在一条权值为 w 的边。

输出格式
共一行，若存在最小生成树，则输出一个整数，表示最小生成树的树边权重之和，如果最小生成树不存在则输出 impossible。

数据范围
1≤n≤105,
1≤m≤2∗105,
图中涉及边的边权的绝对值均不超过 1000。

输入样例：
4 5
1 2 1
1 3 2
1 4 3
2 3 2
3 4 4
输出样例：
6*/

//@@ use edges count >= n - 1 to verify all nodes has been connected,
//@@ it's wrong by counting added nodes bc it could be several unconnected parts.
public class A859 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("src/ACWING/Graph/A859Data.txt"));
        int n = sc.nextInt();
        int m = sc.nextInt();

        List<Edge> edges = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int f = sc.nextInt();
            int t = sc.nextInt();
            int w = sc.nextInt();
            edges.add(new Edge(f, t, w));
        }

        edges.sort((a, b) -> a.w - b.w);

        UnionSet unionSet = new UnionSet(n);

        int added = 0;
        int path = 0;
        for (Edge e : edges) {
            if (!unionSet.isSameSet(e.f, e.t)) {
                unionSet.union(e.f, e.t);
                path += e.w;
                added++;
            }
        }
        if (added >= n - 1) {
            System.out.print(path);
        } else {
            System.out.print("impossible");
        }
    }

    static class UnionSet {
        int[] set;

        public UnionSet(int n) {
            set = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                set[i] = i;
            }
        }


        int find(int i) {
            if (set[i] != i) {
                set[i] = find(set[i]);
            }
            return set[i];
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
                set[pi] = pj;
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
