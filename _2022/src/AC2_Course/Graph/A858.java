package AC2_Course.Graph;

import java.util.Arrays;
import java.util.Scanner;

/*858. Prim算法求最小生成树

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
1≤n≤500,
1≤m≤105,
图中涉及边的边权的绝对值均不超过 10000。

输入样例：
4 5
1 2 1
1 3 2
1 4 3
2 3 2
3 4 4
输出样例：
6*/
public class A858 {
    static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] map = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == j) {
                    map[i][j] = 0;
                } else {
                    map[i][j] = INF;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            int f = sc.nextInt();
            int t = sc.nextInt();
            int w = sc.nextInt();
            map[f][t] = Math.min(map[f][t], w);
            map[t][f] = Math.min(map[t][f], w);
        }

        int path = prim(map, n);

        System.out.println(path == INF ? "impossible" : path);
    }

    static int prim(int[][] map, int n) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);
        boolean[] visited = new boolean[n + 1];

        int path = 0;
        for (int i = 0; i < n; i++) {
            int t = -1;
            for (int j = 1; j <= n; j++) {
                if (!visited[j] && (t == -1 || dist[t] > dist[j])) {
                    t = j;
                }
            }
            if (i != 0 && dist[t] == INF) {
                return INF;
            }
            if (i != 0) {
                path += dist[t];
            }
            for (int j = 1; j <= n; j++) {
                dist[j] = Math.min(dist[j], map[t][j]);
            }
            visited[t] = true;
        }
        return path;
    }

}

