package AC2.A5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class A5 {
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
        int max = maxW(v, w, s, N, V);
        System.out.println(max);
    }

    static int maxW(int[] v, int[] w, int[] s, int N, int V) {
        int[] dp = new int[V + 1];
        for (int i = N - 1; i >= 0; i--) {
            List<Integer> list = split(s[i]);
            for (int k = 0; k < list.size(); k++) {
                for (int j = dp.length - 1; j >= 0; j--) {
                    if (j >= v[i] * list.get(k)) {
                        dp[j] = Math.max(dp[j], dp[j - v[i] * list.get(k)] + w[i] * list.get(k));
                    }
                }
            }
        }
        return dp[V];
    }

    private static List<Integer> split(int x) {
        List<Integer> list = new ArrayList<>();
        int i = 1;
        while (x > i) {
            list.add(i);
            x -= i;
            i *= 2;
        }
        list.add(x);
        return list;
    }
}
