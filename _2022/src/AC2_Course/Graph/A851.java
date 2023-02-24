package AC2_Course.Graph;


import java.util.*;

/*
851. spfa求最短路

给定一个 n 个点 m 条边的有向图，图中可能存在重边和自环， 边权可能为负数。

请你求出 1 号点到 n 号点的最短距离，如果无法从 1 号点走到 n 号点，则输出 impossible。

数据保证不存在负权回路。

输入格式
第一行包含整数 n 和 m。

接下来 m 行每行包含三个整数 x,y,z，表示存在一条从点 x 到点 y 的有向边，边长为 z。

输出格式
输出一个整数，表示 1 号点到 n 号点的最短距离。

如果路径不存在，则输出 impossible。

数据范围
1≤n,m≤105,
图中涉及边长绝对值均不超过 10000。

输入样例：
3 3
1 2 5
2 3 -3
1 3 4
输出样例：
2
*/
public class A851 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        Map<Integer, List<Edge>> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            map.put(i, new LinkedList<>());
        }
        for (int i = 0; i < m; i++) {
            int f = sc.nextInt();
            int t = sc.nextInt();
            int w = sc.nextInt();
            map.get(f).add(new Edge(f, t, w));
        }

        int MAX = 0x3f3f3f3f;
        int[] dist = new int[n + 1];
        Arrays.fill(dist, MAX);
        dist[1] = 0;
        boolean[] inQ = new boolean[n + 1];

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        inQ[1] = true;
        while (!q.isEmpty()) {
            int node = q.poll();
            inQ[node] = false;
            for (Edge edge : map.get(node)) {
                if (dist[edge.t] > dist[node] + edge.w) {
                    dist[edge.t] = dist[node] + edge.w;
                    if (!inQ[edge.t]) {
                        q.add(edge.t);
                        inQ[edge.t] = true;
                    }
                }
            }
        }
        if (dist[n] > MAX / 2) {
            System.out.println("impossible");
        } else {
            System.out.println(dist[n]);
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
