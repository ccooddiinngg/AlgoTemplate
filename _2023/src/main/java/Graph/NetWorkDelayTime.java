package Graph;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class NetWorkDelayTime {
    public int networkDelayTime(int[][] times, int n, int k) {
        int INF = 0x3f3f3f3f;
        Map<Integer, List<Edge>> map = new HashMap<>();
        for (int[] t : times) {
            if (!map.containsKey(t[0])) {
                map.put(t[0], new ArrayList<>());
            }
            map.get(t[0]).add(new Edge(t[0], t[1], t[2]));
        }
        int[] dis = dij(n, k, map);

        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, dis[i]);
        }
        return max < INF ? max : -1;
    }


    public int[] dij(int n, int k, Map<Integer, List<Edge>> map) {
        int INF = 0x3f3f3f3f;
        Queue<Edge> q = new PriorityQueue<>((a, b) -> a.w - b.w);
        int[] dis = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        Arrays.fill(dis, INF);
        dis[k] = 0;
        q.offer(new Edge(k, k, 0));
        while (!q.isEmpty()) {
            Edge curr = q.poll();
            visited[curr.t] = true;
            if (map.containsKey(curr.t)) {
                for (Edge next : map.get(curr.t)) {
                    if (dis[next.t] > dis[curr.t] + next.w) {
                        dis[next.t] = dis[curr.t] + next.w;
                        q.offer(new Edge(k, next.t, dis[next.t]));
                    }
                }
            }
        }
        return dis;
    }

    class Edge {
        int f;
        int t;
        int w;

        public Edge(int f, int t, int w) {
            this.f = f;
            this.t = t;
            this.w = w;
        }
    }

    @Test
    void test() {
        int[][] times = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        int n = 4;
        int k = 2;

        Assertions.assertEquals(2, networkDelayTime(times, n, k));
    }
}

