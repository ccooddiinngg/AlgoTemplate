package Graph;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class ReachableNodesInSubdividedGraph {
    class Dijkstra2AdjacencyList {
        int n;
        int m;
        int[] e;
        int[] he;
        int[] ne;
        int[] w;
        int idx;

        void init(int n, int m) {
            this.n = n;
            this.m = m;
            e = new int[m];
            he = new int[n];
            Arrays.fill(he, -1);
            ne = new int[m];
            w = new int[m];
            idx = 0;
        }

        void add(int a, int b, int c) {
            e[idx] = b;
            ne[idx] = he[a];
            he[a] = idx;
            w[idx] = c;
            idx++;
        }

        public int reachableNodes(int[][] edges, int maxMoves, int n) {
            init(n, edges.length * 2);
            for (int[] e : edges) {
                int a = e[0], b = e[1], c = e[2];
                add(a, b, c + 1);
                add(b, a, c + 1);
            }

            int[] dist = dijkstra();
            // for (int v: dist) {
            //     System.out.print(v + " ");
            // }
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (dist[i] <= maxMoves) {
                    count++;
                }
            }
            for (int[] e : edges) {
                int f = e[0], t = e[1], cnt = e[2];
                int c1 = Math.max(0, maxMoves - dist[f]);
                int c2 = Math.max(0, maxMoves - dist[t]);
                count += Math.min(c1 + c2, cnt);
            }
            return count;
        }

        int[] dijkstra() {
            Queue<int[]> q = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
            int[] dist = new int[n];
            boolean[] visited = new boolean[n];
            Arrays.fill(dist, INF);
            dist[0] = 0;
            q.offer(new int[]{0, 0});
            while (!q.isEmpty()) {
                int[] curr = q.poll();
                int b = curr[0];
                if (visited[b]) continue;
                visited[b] = true;
                for (int i = he[b]; i != -1; i = ne[i]) {
                    int b1 = e[i], c1 = w[i];
                    if (dist[b1] > dist[b] + c1) {
                        dist[b1] = dist[b] + c1;
                        q.offer(new int[]{b1, dist[b1]});
                    }
                }
            }
            return dist;
        }

        int INF = 0x3f3f3f3f;
    }

    class Dijkstra2 {
        public int reachableNodes(int[][] edges, int maxMoves, int n) {
            for (int i = 0; i < n; i++) {
                map.add(new ArrayList<>());
            }
            for (int[] e : edges) {
                int f = e[0], t = e[1], w = e[2];
                map.get(f).add(new int[]{t, w + 1});
                map.get(t).add(new int[]{f, w + 1});
            }

            int[] dist = dijkstra();
            // for (int v: dist) {
            //     System.out.print(v + " ");
            // }
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (dist[i] <= maxMoves) {
                    count++;
                }
            }
            for (int[] e : edges) {
                int f = e[0], t = e[1], cnt = e[2];
                int c1 = Math.max(0, maxMoves - dist[f]);
                int c2 = Math.max(0, maxMoves - dist[t]);
                count += Math.min(c1 + c2, cnt);
            }
            return count;
        }

        int[] dijkstra() {
            int n = map.size();
            Queue<int[]> q = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
            int[] dist = new int[n];
            boolean[] visited = new boolean[n];
            Arrays.fill(dist, INF);
            dist[0] = 0;
            q.offer(new int[]{0, 0});
            while (!q.isEmpty()) {
                int[] e = q.poll();
                int t = e[0], w = e[1];
                if (visited[t]) continue;
                visited[t] = true;
                for (int[] nei : map.get(t)) {
                    int t1 = nei[0], w1 = nei[1];
                    if (dist[t1] > dist[t] + w1) {
                        dist[t1] = dist[t] + w1;
                        q.offer(new int[]{t1, dist[t1]});
                    }
                }
            }
            return dist;
        }

        int INF = 0x3f3f3f3f;
        List<List<int[]>> map = new ArrayList<>();
    }

    class Dijkstra1 {
        int[] e;
        int[] w;
        int[] ne;
        int[] he;
        int idx;

        void add(int from, int to, int weight) {
            e[idx] = to;
            w[idx] = weight;
            ne[idx] = he[from];
            he[from] = idx;
            idx++;
        }

        public int reachableNodes(int[][] edges, int maxMoves, int n) {
            e = new int[20010];
            w = new int[20010];
            ne = new int[20010];
            he = new int[n];
            Arrays.fill(he, -1);
            idx = 0;
            for (int[] e : edges) {
                add(e[0], e[1], e[2] + 1);
                add(e[1], e[0], e[2] + 1);
            }

            int[] dist = dijkstra(n, 0);

            int count = 0;
            for (int i = 0; i < n; i++) {
                if (dist[i] <= maxMoves) {
                    count++;
                }
            }
            for (int[] e : edges) {
                int n1 = e[0], n2 = e[1], cnt = e[2];
                int c1 = Math.max(0, maxMoves - dist[n1]);
                int c2 = Math.max(0, maxMoves - dist[n2]);
                count += Math.min(c1 + c2, cnt);
            }
            return count;
        }

        private int[] dijkstra(int n, int src) {
            int INF = 0x3f3f3f3f;
            int[] dist = new int[n];
            Arrays.fill(dist, INF);
            dist[src] = 0;
            boolean[] visited = new boolean[n];
            for (int i = 0; i < n; i++) {
                int k = -1;
                for (int j = 0; j < n; j++) {
                    if (!visited[j] && (k == -1 || dist[j] < dist[k])) {
                        k = j;
                    }
                }
                visited[k] = true;
                for (int i1 = he[k]; i1 != -1; i1 = ne[i1]) {
                    dist[e[i1]] = Math.min(dist[e[i1]], dist[k] + w[i1]);
                }
            }
            return dist;
        }
    }

    class Dijkstra1AdjacencyMatrix {
        int[][] map;
        int INF = 0x3f3f3f3f;

        void add(int from, int to, int weight) {
            map[from][to] = weight;
            map[to][from] = weight;
        }

        public int reachableNodes(int[][] edges, int maxMoves, int n) {
            map = new int[n][n];
            for (int[] row : map) {
                Arrays.fill(row, INF);
            }
            for (int[] e : edges) {
                add(e[0], e[1], e[2] + 1);
                add(e[1], e[0], e[2] + 1);
            }

            int[] dist = dijkstra(n, 0);
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (dist[i] <= maxMoves) {
                    count++;
                }
            }
            for (int[] e : edges) {
                int n1 = e[0], n2 = e[1], cnt = e[2];
                int c1 = Math.max(0, maxMoves - dist[n1]);
                int c2 = Math.max(0, maxMoves - dist[n2]);
                count += Math.min(c1 + c2, cnt);
            }
            return count;
        }

        private int[] dijkstra(int n, int src) {
            int INF = 0x3f3f3f3f;
            int[] dist = new int[n];
            Arrays.fill(dist, INF);
            dist[src] = 0;
            boolean[] visited = new boolean[n];
            for (int i = 0; i < n; i++) {
                int k = -1;
                for (int j = 0; j < n; j++) {
                    if (!visited[j] && (k == -1 || dist[j] < dist[k])) {
                        k = j;
                    }
                }
                visited[k] = true;
                for (int i1 = 0; i1 < n; i1++) {
                    dist[i1] = Math.min(dist[i1], dist[k] + map[k][i1]);
                }
            }
            return dist;
        }


    }

    @Test
    void test() {
        int[][] edges = {{1, 2, 5}, {0, 3, 3}, {1, 3, 2}, {2, 3, 4}, {0, 4, 1}};
        int maxMoves = 7;
        int n = 5;
        Dijkstra1 dijkstra1 = new Dijkstra1();
        Dijkstra1AdjacencyMatrix dijkstra1AdjacencyMatrix = new Dijkstra1AdjacencyMatrix();
        Dijkstra2 dijkstra2 = new Dijkstra2();
        Dijkstra2AdjacencyList dijkstra2AdjacencyList = new Dijkstra2AdjacencyList();

        Assertions.assertEquals(13, dijkstra1.reachableNodes(edges, maxMoves, n));
        Assertions.assertEquals(13, dijkstra1AdjacencyMatrix.reachableNodes(edges, maxMoves, n));
        Assertions.assertEquals(13, dijkstra2.reachableNodes(edges, maxMoves, n));
        Assertions.assertEquals(13, dijkstra2AdjacencyList.reachableNodes(edges, maxMoves, n));
    }
}
