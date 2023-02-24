package AC2_Course.Knapsack;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class K08 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("src/ACWING.Knapsack/K08_data.txt"));
        int N = sc.nextInt();
        int V = sc.nextInt();

        int[] dp = new int[V + 1];
        for (int i = 0; i < N; i++) {
            int q = sc.nextInt();
            int[] v = new int[q];
            int[] w = new int[q];
            for (int i1 = 0; i1 < q; i1++) {
                v[i1] = sc.nextInt();
                w[i1] = sc.nextInt();
            }
            for (int j = V; j >= 0; j--) {
                for (int k = 0; k < q; k++) {
                    if (j >= v[k]) {
                        dp[j] = Math.max(dp[j], dp[j - v[k]] + w[k]);
                    }
                }
            }
        }

        System.out.println(dp[V]);
    }
}
