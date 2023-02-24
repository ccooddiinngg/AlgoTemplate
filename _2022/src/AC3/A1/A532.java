package AC3.A1;

import java.util.Arrays;
import java.util.Scanner;

public class A532 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        for (int i = 0; i < k; i++) {
            int n = sc.nextInt();
            int[] v = new int[n];
            for (int j = 0; j < n; j++) {
                v[j] = sc.nextInt();
            }
            System.out.println(find(v, n));
        }
    }

    static int find(int[] v, int n) {
        Arrays.sort(v);
        int count = 0;
        int[] dp = new int[v[n - 1] + 1];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            if (dp[v[i]] == 0) {
                count++;
            }
            for (int j = v[i]; j < v[n - 1] + 1; j++) {
                dp[j] += dp[j - v[i]];
            }

        }

        return count;
    }
}
