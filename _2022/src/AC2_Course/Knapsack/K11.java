package AC2_Course.Knapsack;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class K11 {
    public static void main(String[] args) throws FileNotFoundException {
//        int[] v = {1, 2, 3, 4};
//        int[] w = {2, 4, 4, 6};
//        int V = 5;

        Scanner sc = new Scanner(new File("src/ACWING.Knapsack/K11_data.txt"));
        int N = sc.nextInt();
        int V = sc.nextInt();
        int[] v = new int[N];
        int[] w = new int[N];
        for (int i = 0; i < N; i++) {
            v[i] = sc.nextInt();
            w[i] = sc.nextInt();
        }

        int[][] dp = new int[v.length + 1][V + 1];

        //@@ if using 2D dp, remember to set dp[i][j] first to dp[i + 1][j]
        for (int i = dp.length - 2; i >= 0; i--) {
            for (int j = V; j >= 0; j--) {
                dp[i][j] = dp[i + 1][j];
                if (j >= v[i]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i + 1][j - v[i]] + w[i]);
                }
            }
        }

        List<Integer> list = new ArrayList<>();
        int j = V;
        for (int i = 0; i < dp.length - 1; i++) {
            if (j >= v[i] && dp[i][j] == dp[i + 1][j - v[i]] + w[i]) {
                list.add(i);
                j -= v[i];
            }
        }
        System.out.println(list);
    }
}