package AC2_Course.Knapsack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


//@@ 拆分为01背包和完全背包
public class K06 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int V = sc.nextInt();
        int[] v = new int[N];
        int[] w = new int[N];
        int[] s = new int[N];
        for (int i = 0; i < N; i++) {
            v[i] = sc.nextInt();
            w[i] = sc.nextInt();
            s[i] = sc.nextInt();
        }

        class Item {
            int v;
            int w;
            int s;

            public Item(int v, int w, int s) {
                this.v = v;
                this.w = w;
                this.s = s;
            }
        }

        List<Item> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            if (s[i] > 0) {
                int q = s[i];
                for (int j = 1; j < q; j *= 2) {
                    q -= j;
                    list.add(new Item(j * v[i], j * w[i], -1));
                }
                if (q > 0) {
                    list.add(new Item(q * v[i], q * w[i], -1));
                }
            } else {
                list.add(new Item(v[i], w[i], s[i]));
            }
        }

        int[][] dp = new int[list.size() + 1][V + 1];
        for (int i = dp.length - 2; i >= 0; i--) {
            for (int j = 0; j < dp[0].length; j++) {
                if (list.get(i).s == -1) {
                    dp[i][j] = (dp[i + 1][j]);
                    if (list.get(i).v <= j) {
                        dp[i][j] = Math.max(dp[i][j], dp[i + 1][j - list.get(i).v] + list.get(i).w);
                    }
                } else {
                    dp[i][j] = (dp[i + 1][j]);
                    if (list.get(i).v <= j) {
                        dp[i][j] = Math.max(dp[i][j], dp[i][j - list.get(i).v] + list.get(i).w);
                    }
                }
            }
        }

        System.out.println(dp[0][V]);
    }
}

