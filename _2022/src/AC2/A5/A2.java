package AC2.A5;

import java.util.Scanner;

public class A2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int V = sc.nextInt();
        int[] v = new int[N];
        int[] w = new int[N];
        for (int i = 0; i < N; i++) {
            v[i] = sc.nextInt();
            w[i] = sc.nextInt();
        }
        int max = maxW(v, w, N, V);
        System.out.println(max);
    }

    static int maxW(int[] v, int[] w, int N, int V) {
        int[] dp = new int[V + 1];
        for (int i = N - 1; i >= 0; i--) {
            for (int j = V; j >= v[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - v[i]] + w[i]);
            }
        }
        return dp[V];
    }
}

/*
01背包的本质
1.有几件物品就有几层决策
2.只有条件满足时(j > v[i] * k)时才能选择把i物品放入背包
3.当每件可多选的时候(多重背包I)，物品依然有n件，k 循环在 j循环内
4.当使用2进制优化多重背包时(多重背包II)，物品变为(S1+S2+S3+…)件，k循环在j循环外
5。分组背包是物品有n件(n组)，每件有k种选法，k 循环在 j循环内
*/
