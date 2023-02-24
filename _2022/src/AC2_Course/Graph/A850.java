package AC2_Course.Graph;

import java.util.*;

/*
// new graph
// new set
// new dis[]
// for n
//     find the shortest node in graph: priorityQueue
//     add node to set
//     update node's neighbors dis[i] if (dis[i] > dis[node] + w)
// return dis[n]
*/
public class A850 {

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
        for (int i = 2; i < n + 1; i++) {
            dis[i] = Integer.MAX_VALUE;
        }

        boolean[] set = new boolean[n + 1];
        PriorityQueue<Edge> q = new PriorityQueue<>(Comparator.comparingInt(e -> e.w));
        q.add(new Edge(1, 1, 0));

        while (!q.isEmpty()) {
            Edge e = q.poll();
            if (!set[e.to]) {
                set[e.to] = true;
                for (Edge edge : map.get(e.to)) {
                    if (dis[e.to] + edge.w < dis[edge.to])
                        dis[edge.to] = dis[e.to] + edge.w;
                    q.add(new Edge(1, edge.to, dis[edge.to]));
                }
            }
        }
        System.out.println(dis[n] == Integer.MAX_VALUE ? -1 : dis[n]);
    }


    static class Edge {
        int from;
        int to;
        int w;

        public Edge(int from, int to, int w) {
            this.from = from;
            this.to = to;
            this.w = w;
        }
    }
}


