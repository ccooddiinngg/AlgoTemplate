package Playground.Graph;

import java.util.*;

public class Dijkstra {

    int INF = 0x3f3f3f3f;

    public int dijkstra(int start, int end, Graph graph) {
        int[] dis = new int[graph.n + 1];
        Arrays.fill(dis, INF);
        dis[start] = 0;
        Edge e0 = new Edge(start, start, 0);
        Queue<Edge> q = new PriorityQueue<>(Comparator.comparingInt(a -> a.w));
        Set<Integer> vis = new HashSet<>();
        q.add(e0);
        while (!q.isEmpty()) {
            Edge e = q.poll();
            if (vis.contains(e.t)) continue;
            vis.add(e.t);
            for (Edge next : graph.map.get(e.t)) {
                if (dis[next.t] > dis[e.t] + next.w) {
                    dis[next.t] = dis[e.t] + next.w;
                    q.add(new Edge(start, next.t, dis[next.t]));
                }
            }
        }
        // System.out.println(Arrays.toString(dis));
        return dis[end];
    }
}
