import utils.Edge;

import java.util.PriorityQueue;
import java.util.*;

public class Graph {
    private static final int INF = 0x3f3f3f3f;
    public Map<Integer, List<Edge>> map;
    public int n;

    public Graph() {
        this.map = new HashMap<>();
        this.n = 0;
    }

    public void build(int[][] matrix) {
        this.n = matrix.length;
        for (int i = 0; i < this.n; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    continue;
                }
                map.get(i).add(new Edge(i, j, matrix[i][j]));
            }
        }
    }

    //from 0 to n-1
    public int[] dijkstra() {
        int[] dis = new int[n];
        boolean[] visited = new boolean[n];
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
}
