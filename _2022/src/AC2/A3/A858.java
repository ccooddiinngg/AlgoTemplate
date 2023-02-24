package AC2.A3;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class A858 {
    static int MAX = 0x3f3f3f3f;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] map = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                map[i][j] = i == j ? 0 : MAX;
            }
        }

        for (int k = 0; k < m; k++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int w = sc.nextInt();
            map[from][to] = Math.min(map[from][to], w);
            map[to][from] = Math.min(map[to][from], w);
        }

        prim(map, n);
    }

    private static void prim(int[][] map, int n) {
        int path = 0;
        Set<Integer> used = new HashSet<>();
        int[] dis = new int[n + 1];
        Arrays.fill(dis, MAX);

        //循环n次， 每次确定一条到集合的最短边
        for (int k = 0; k < n; k++) {
            int t = -1;
            for (int i = 1; i <= n; i++) {
                if (!used.contains(i) && (t == -1 || dis[i] < dis[t])) {
                    t = i;
                }
            }
            if (k != 0 && dis[t] == MAX) {
                System.out.println("impossible");
                return;
            }
            if (k != 0) {
                path += dis[t];
            }
            used.add(t);
            for (int i = 1; i <= n; i++) {
                if (dis[i] > map[i][t]) {
                    dis[i] = map[i][t];
                }
            }
        }
        System.out.println(path);
    }
}
