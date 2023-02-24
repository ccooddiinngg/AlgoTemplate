package AC2.A3;

import java.util.*;

public class A849 {
    static int MAX = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Map<Integer, List<Edge>> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int f = sc.nextInt();
            int t = sc.nextInt();
            int w = sc.nextInt();
            map.get(f).add(new Edge(f, t, w));
        }
        int[] dis = new int[n + 1];
        Arrays.fill(dis, MAX);
        //from 1 to 1
        dis[1] = 0;
        dijkstra(n, map, dis, new HashSet<>());
    }

    //from 1 to n
    static void dijkstra(int n, Map<Integer, List<Edge>> map, int[] dis, Set<Integer> used) {
        Queue<Edge> q = new PriorityQueue<>((a, b) -> a.w - b.w);
        q.add(new Edge(1, 1, 0));
        while (!q.isEmpty()) {
            Edge curr = q.poll();
            if (!used.contains(curr.t)) {
                used.add(curr.t);
                for (Edge edge : map.get(curr.t)) {
                    if (dis[edge.t] > dis[curr.t] + edge.w) {
                        dis[edge.t] = dis[curr.t] + edge.w;
                        q.add(new Edge(1, edge.t, dis[edge.t]));
                    }
                }
            }
        }
        if (dis[n] == MAX) {
            System.out.println(-1);
        } else {
            System.out.println(dis[n]);
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
