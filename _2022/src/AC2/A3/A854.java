package AC2.A3;

import java.util.Scanner;

public class A854 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int q = sc.nextInt();

        int[][] map = new int[n + 1][n + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (i == j) {
                    map[i][j] = 0;
                } else {
                    map[i][j] = 0x3f3f3f3f;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            int f = sc.nextInt();
            int t = sc.nextInt();
            int w = sc.nextInt();
            map[f][t] = Math.min(map[f][t], w);
        }

        floyd(map, n);

        for (int i = 0; i < q; i++) {
            int f = sc.nextInt();
            int t = sc.nextInt();
            if (map[f][t] > 0x3f3f3f3f / 2) {
                System.out.println("impossible");
            } else {
                System.out.println(map[f][t]);
            }
        }
    }

    private static void floyd(int[][] map, int n) {
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                }
            }
        }
    }
}
