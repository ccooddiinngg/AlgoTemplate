package AC2.A3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class A853 {
    static int MAX = 0x3f3f3f3f;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int w = sc.nextInt();
            edges.add(new Edge(from, to, w));
        }

        int[] dis = new int[n + 1];
        //除了出发点以外都设为INF
        for (int i = 2; i < dis.length; i++) {
            dis[i] = MAX;
        }

        bellman_ford(edges, k, dis, n);
    }

    static void bellman_ford(List<Edge> edges, int k, int[] dis, int n) {
        for (int i = 0; i < k; i++) {
            int[] disCopy = copy(dis);
            for (Edge e : edges) {
                //可能会出现很多点同时更新一个点的情况
                if (dis[e.t] > disCopy[e.f] + e.w) {
                    dis[e.t] = disCopy[e.f] + e.w;
                }
            }
        }
        System.out.println(dis[n] > MAX / 2 ? "impossible" : dis[n]);
    }

    //防止更新dis时用更新过的距离去更新别的距离，所以每次都copy一份用于更新的dis
    static int[] copy(int[] dis) {
        int[] cp = new int[dis.length];
        System.arraycopy(dis, 0, cp, 0, dis.length);
        return cp;
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
