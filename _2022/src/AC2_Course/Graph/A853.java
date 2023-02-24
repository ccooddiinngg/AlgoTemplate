package AC2_Course.Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
853. 有边数限制的最短路

给定一个 n 个点 m 条边的有向图，图中可能存在重边和自环， 边权可能为负数。

请你求出从 1 号点到 n 号点的最多经过 k 条边的最短距离，如果无法从 1 号点走到 n 号点，输出 impossible。

注意：图中可能 存在负权回路 。

输入格式
第一行包含三个整数 n,m,k。

接下来 m 行，每行包含三个整数 x,y,z，表示存在一条从点 x 到点 y 的有向边，边长为 z。

输出格式
输出一个整数，表示从 1 号点到 n 号点的最多经过 k 条边的最短距离。

如果不存在满足条件的路径，则输出 impossible。

数据范围
1≤n,k≤500,
1≤m≤10000,
任意边长的绝对值不超过 10000。

输入样例：
3 3 1
1 2 1
2 3 1
1 3 3
输出样例：
3
*/
public class A853 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int w = sc.nextInt();
            edges.add(new Edge(from, to, w));
        }

        int[] dist = new int[n + 1];
        int MAX = 0x3f3f3f3f;
        for (int i = 2; i < dist.length; i++) {
            dist[i] = MAX;
        }

        for (int i = 0; i < k; i++) {
            int[] pre = copy(dist);
            for (Edge e : edges) {
                dist[e.to] = Math.min(dist[e.to], pre[e.from] + e.w);
            }
        }
        System.out.println(dist[n] > MAX / 2 ? -1 : dist[n]);
    }

    static int[] copy(int[] a) {
        int[] b = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            b[i] = a[i];
        }
        return b;
    }

    static class Edge {
        int from;
        int to;
        int w;

        public Edge(int from, int to, int w) {
            this.from = from;
            this.to = to;
            this.w = w;
        }
    }
}
