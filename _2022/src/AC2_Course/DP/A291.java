package AC2_Course.DP;

import java.util.Scanner;

/*
2 4

5
*/
public class A291 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            if (m == 0 && n == 0) break;
            //最多12列， 每列最多 2 ^ 11 种可能
            long[][] dp = new long[12][2048];

            //初始状态， 是最先出现的可能性状态
            dp[0][0] = 1;

            //从上一个可能的状态开始，填完n列
            for (int j = 0; j < n; j++) {
                //每列可能出现的状态
                for (int curr = 0; curr < (1 << m); curr++) {
                    //如果这个状态存在，就尝试填写这个状态并产生下一个可能的状态
                    if (dp[j][curr] > 0) {
                        dfsBit(m, n, dp, 0, j, curr, 0);
                    }
                }
            }
            //当填完n - 1列后， n列里全是0的状态就是合法的状态（没有n-1列横向伸出的状态）
//            for (long[] row : dp) {
//                System.out.println(Arrays.toString(row));
//            }
            System.out.println(dp[n][0]);
        }
    }

    //dp[][] : col j and curr(00100100...) counts
    public static void dfsBit(int m, int n, long[][] dp, int i, int j, int curr, int next) {
        //填完最后一行， 下一个可能的状态把本次状态累加进去
        if (i == m) {
            dp[j + 1][next] += dp[j][curr];
            return;
        }
        //如果这个格子被左边伸出来的挡住了，就不用填了
        if (((curr >> i) & 1) == 1) {
            dfsBit(m, n, dp, i + 1, j, curr, next);
        } else {
            //横向填
            dfsBit(m, n, dp, i + 1, j, curr, next | (1 << i));
            //竖着填
            if (i < m - 1 && (curr & (1 << (i + 1))) == 0) {
                dfsBit(m, n, dp, i + 2, j, curr, next);
            }
        }
    }

    //bruteforce
    public static int dfs(int m, int n, int i, int j, int[] curr, int[] next) {
        if (i == 0 && j == n) {
            boolean b = true;
            for (int num : curr) {
                if (num != 0) {
                    b = false;
                }
            }
            return b ? 1 : 0;
        }
        if (i == m) {
            return dfs(m, n, 0, j + 1, next, new int[m]);
        }
        if (curr[i] == 1) {
            return dfs(m, n, i + 1, j, curr, next);
        }
        int o = 0;
        next[i] = 1;
        o += dfs(m, n, i + 1, j, curr, next);
        next[i] = 0;

        if (i < m - 1 && curr[i + 1] == 0) {
            o += dfs(m, n, i + 2, j, curr, next);
        }
        return o;
    }

}
