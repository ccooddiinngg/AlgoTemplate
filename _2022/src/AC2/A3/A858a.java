package AC2.A3;

import java.util.*;

public class A858a {
    static int MAX = 0x3f3f3f3f;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        Map<Integer, List<Edge>> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            map.put(i, new ArrayList<>());
            map.get(i).add(new Edge(i, i, 0));
        }
        for (int i = 0; i < m; i++) {
            int f = sc.nextInt();
            int t = sc.nextInt();
            int w = sc.nextInt();
            map.get(f).add(new Edge(f, t, w));
            map.get(t).add(new Edge(t, f, w));
        }
        prim(map, n);
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

    static void prim(Map<Integer, List<Edge>> map, int n) {
        int[] dis = new int[n + 1];
        int path = 0;
        Set<Integer> set = new HashSet<>();
        Arrays.fill(dis, MAX);
        for (int i = 1; i <= n; i++) {
            int k = -1;
            for (int j = 1; j <= n; j++) {
                if (!set.contains(j) && (k == -1 || dis[j] < dis[k])) {
                    k = j;
                }
            }
            set.add(k);
            if (i != 1) {
                if (dis[k] == MAX) {
                    System.out.println("impossible");
                    return;
                }
                path += dis[k];
            }
            for (Edge e : map.get(k)) {
                if (dis[e.t] > e.w) {
                    dis[e.t] = e.w;
                }
            }
        }
        System.out.println(path);
    }
}
