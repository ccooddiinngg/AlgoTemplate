package Graph;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class NetWorkDelayTime {
    class Floyd {
        public int networkDelayTime(int[][] times, int n, int k) {
            int INF = 0x3f3f3f3f;
            int[][] map = new int[n + 1][n + 1];
            for (int[] row : map) {
                Arrays.fill(row, INF);
            }
            for (int i = 0; i < times.length; i++) {
                map[times[i][0]][times[i][1]] = times[i][2];
            }
            for (int i = 1; i <= n; i++) {
                map[i][i] = 0;
            }

            for (int m = 1; m <= n; m++) {
                for (int i = 1; i <= n; i++) {
                    for (int j = 1; j <= n; j++) {
                        map[i][j] = Math.min(map[i][j], map[i][m] + map[m][j]);
                    }
                }
            }
            int max = 0;
            for (int i = 1; i <= n; i++) {
                max = Math.max(max, map[k][i]);
            }

            return max < INF ? max : -1;
        }


    }

    class Dijkstra {
        public int networkDelayTime(int[][] times, int n, int k) {
            int INF = 0x3f3f3f3f;
            int[][] map = new int[n + 1][n + 1];
            for (int[] row : map) {
                Arrays.fill(row, INF);
            }
            for (int[] t : times) {
                map[t[0]][t[1]] = t[2];
            }
            int[] dis = dijkstra(n, k, map);

            int max = 0;
            for (int i = 1; i <= n; i++) {
                max = Math.max(max, dis[i]);
            }
            return max < INF ? max : -1;
        }


        public int[] dijkstra(int n, int k, int[][] map) {
            int INF = 0x3f3f3f3f;
            //edges: [to, weight]
            Queue<int[]> q = new PriorityQueue<>((a, b) -> a[1] - b[1]);
            int[] dis = new int[n + 1];
            boolean[] visited = new boolean[n + 1];
            Arrays.fill(dis, INF);
            dis[k] = 0;
            q.offer(new int[]{k, 0});
            while (!q.isEmpty()) {
                int[] edge = q.poll();
                int curr = edge[0], w = edge[1];
                if (visited[curr]) continue;
                visited[curr] = true;
                for (int i = 1; i <= n; i++) {
                    if (dis[i] > dis[curr] + map[curr][i]) {
                        dis[i] = dis[curr] + map[curr][i];
                        q.offer(new int[]{i, dis[i]});
                    }
                }
            }
            return dis;
        }

    }


    @Test
    void test() {
        int[][] times = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        int n = 4;
        int k = 2;
        Dijkstra dijkstra = new Dijkstra();
        Assertions.assertEquals(2, dijkstra.networkDelayTime(times, n, k));

        Floyd floyd = new Floyd();
        Assertions.assertEquals(2, floyd.networkDelayTime(times, n, k));
    }
}

