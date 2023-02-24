package Leetcode.Coding_Interview_6.C04;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class S01a {
    int N = 100010;
    int INF = 0x3f3f3f3f;
    int[] dis = new int[N];
    boolean[] st = new boolean[N];
    int[] h = new int[N];
    int[] e = new int[N];
    int[] ne = new int[N];
    int[] w = new int[N];
    int idx = 0;

    void add(int a, int b, int c) {
        w[idx] = c;
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        Arrays.fill(h, -1);
        Arrays.fill(dis, INF);
        for (int[] e : graph) {
            add(e[0], e[1], 1);
        }

        dijkstra(n, start, target);
        // System.out.println(dis[target]);
        return dis[target] < INF;
    }

    void dijkstra(int n, int start, int target) {
        Queue<int[]> q = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        dis[start] = 0;
        q.add(new int[]{start, 0});
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            if (st[curr[0]]) continue;
            st[curr[0]] = true;
            for (int i = h[curr[0]]; i != -1; i = ne[i]) {
                int next = e[i];
                if (dis[next] > dis[curr[0]] + w[i]) {
                    dis[next] = dis[curr[0]] + w[i];
                    q.add(new int[]{next, dis[next]});
                }
            }
        }
    }

}
