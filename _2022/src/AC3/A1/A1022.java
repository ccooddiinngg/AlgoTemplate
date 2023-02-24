package AC3.A1;

import java.util.Scanner;

public class A1022 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int D = sc.nextInt();
        int n = sc.nextInt();
        int[] v = new int[n];
        int[] d = new int[n];
        for (int i = 0; i < n; i++) {
            v[i] = sc.nextInt();
            d[i] = sc.nextInt();
        }
        int[] res = find(v, d, V, D, n);
        System.out.println(res[0] + " " + res[1]);
    }

    static int[] find(int[] v, int[] d, int V, int D, int n) {
        //D can't be 0
        int[][] dp = new int[V + 1][D];
        for (int i = 0; i < n; i++) {
            for (int j = V; j >= v[i]; j--) {
                for (int k = D - 1; k >= d[i]; k--) {
                    dp[j][k] = Math.max(dp[j][k], dp[j - v[i]][k - d[i]] + 1);
                }
            }
        }
//        for (int[] row : dp) {
//            System.out.println(Arrays.toString(row));
//        }
        int max = dp[V][D - 1];
        int min = D;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (dp[i][j] == max) {
                    min = Math.min(min, j);
                }
            }
        }
        return new int[]{max, D - min};
    }
}
