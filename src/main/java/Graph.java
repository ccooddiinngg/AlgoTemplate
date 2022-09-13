import utils.Edge;

import java.util.PriorityQueue;
import java.util.*;

public class Graph {
    private static final int INF = 0x3f3f3f3f;
    public Map<Integer, List<Edge>> map;
    public int V;

    public Graph() {
        this.map = new HashMap<>();
        this.V = 0;
    }

    public void build(int[][] matrix) {
        this.V = matrix.length;
        for (int i = 0; i < this.V; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (matrix[i][j] != 0) {
                    map.get(i).add(new Edge(i, j, matrix[i][j]));
                }
            }
        }
    }

    //from 0 to n-1
    public int[] dijkstra() {
        int[] dis = new int[V];
        boolean[] visited = new boolean[V];
        Arrays.fill(dis, INF);
        dis[0] = 0;
        PriorityQueue<Edge> q = new PriorityQueue<>(Comparator.comparingInt(a -> a.w));
        q.offer(new Edge(0, 0, 0));
        while (!q.isEmpty()) {
            Edge curr = q.poll();
            if (visited[curr.t]) continue;
            visited[curr.t] = true;
            for (Edge next : map.get(curr.t)) {
                if (dis[next.t] > dis[curr.t] + next.w) {
                    dis[next.t] = dis[curr.t] + next.w;
                    q.offer(new Edge(0, next.t, dis[next.t]));
                }
            }
        }
        return dis;
    }

    public int kruskal() {
        UnionFind unionFind = new UnionFind(V);

        List<Edge> list = new ArrayList<>();
        for (List<Edge> edges : map.values()) {
            list.addAll(edges);
        }
        list.sort(Comparator.comparingInt(a -> a.w));
        int shortestPath = 0;
        int added = 0;
        for (Edge edge : list) {
            if (!unionFind.isSameSet(edge.f, edge.t)) {
                shortestPath += edge.w;
                added++;
                unionFind.union(edge.f, edge.t);
            }
        }
        if (added == V - 1) {
            return shortestPath;
        }
        return INF;
    }
}
