package AC2_Course.Knapsack;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class K07 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("src/ACWING.Knapsack/K07_data.txt"));
        int N = sc.nextInt();
        int V = sc.nextInt();
        int M = sc.nextInt();

        int[] v = new int[N];
        int[] m = new int[N];
        int[] w = new int[N];

        for (int i = 0; i < N; i++) {
            v[i] = sc.nextInt();
            m[i] = sc.nextInt();
            w[i] = sc.nextInt();
        }

        System.out.println(Arrays.toString(v));
        System.out.println(Arrays.toString(m));
        System.out.println(Arrays.toString(w));

        System.out.println(maxValue(v, m, w, V, M));
    }

    public static int maxValue(int[] v, int[] m, int[] w, int V, int M) {
        int[][] dp = new int[V + 1][M + 1];

        for (int i = v.length - 1; i >= 0; i--) {
            for (int j = V; j >= v[i]; j--) {
                for (int k = M; k >= m[i]; k--) {
                    dp[j][k] = Math.max(dp[j][k], dp[j - v[i]][k - m[i]] + w[i]);
                }
            }
        }

        return dp[V][M];
    }
}
