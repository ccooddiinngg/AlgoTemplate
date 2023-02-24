package AC2.A3;

import java.util.*;

public class A851 {
    static int MAX = 0x3f3f3f3f;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Map<Integer, List<Edge>> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int w = sc.nextInt();
            map.get(from).add(new Edge(from, to, w));
        }

        int[] dis = new int[n + 1];
        //除了出发点以外都设为INF
        for (int i = 2; i < dis.length; i++) {
            dis[i] = MAX;
        }
        spfa(map, dis, n);
    }

    static void spfa(Map<Integer, List<Edge>> map, int[] dis, int n) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        while (!q.isEmpty()) {
            int curr = q.poll();
            for (Edge e : map.get(curr)) {
                if (dis[e.t] > dis[e.f] + e.w) {
                    dis[e.t] = dis[e.f] + e.w;
                    q.add(e.t);
                }
            }
        }
        System.out.println(dis[n] > MAX / 2 ? "impossible" : dis[n]);
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
