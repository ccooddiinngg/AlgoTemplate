package AC3.A1;

import java.util.*;

public class A1072 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<Integer, List<Edge>> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            int f = sc.nextInt();
            int t = sc.nextInt();
            int w = sc.nextInt();
            map.get(f).add(new Edge(f, t, w));
            map.get(t).add(new Edge(t, f, w));
        }
//        int max = 0;
//        for (int i = 1; i <= n; i++) {
//            max = Math.max(max, bt(map, i, new HashSet<>()));
//        }

        int[] max = getMax(map, 1, new HashSet<>());

        System.out.println(max[1]);
    }

    //BruteForce
    static int bt(Map<Integer, List<Edge>> map, int idx, Set<Integer> visited) {
        visited.add(idx);
        int dis = 0;
        for (Edge e : map.get(idx)) {
            if (!visited.contains(e.t)) {
                dis = Math.max(dis, bt(map, e.t, visited) + e.w);
            }
        }
        return dis;
    }

    //0: longest child, 1: max length
    static int[] getMax(Map<Integer, List<Edge>> map, int idx, Set<Integer> visited) {
        visited.add(idx);
        int max = 0;
        int c1 = 0;
        int c2 = 0;
        for (Edge e : map.get(idx)) {
            if (!visited.contains(e.t)) {
                int[] next = getMax(map, e.t, visited);
                int height = next[0] + e.w;
                max = Math.max(max, next[1]);
                if (height > c1) {
                    c2 = c1;
                    c1 = height;
                } else if (height > c2) {
                    c2 = height;
                }
            }
        }
        return new int[]{c1, Math.max(max, c1 + c2)};
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
