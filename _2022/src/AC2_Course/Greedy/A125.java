package AC2_Course.Greedy;

import java.util.Arrays;
import java.util.Scanner;


//按 w + s 的值从小到大排序， 从上往下排列
public class A125 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Pair[] values = new Pair[n];
        for (int i = 0; i < n; i++) {
            int w = sc.nextInt();
            int s = sc.nextInt();
            values[i] = new Pair(w, s);
        }
        Arrays.sort(values, (a, b) -> (a.w + a.s) - (b.w + b.s));

        int max = Integer.MIN_VALUE;
        int[] pre = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            pre[i] = pre[i - 1] + values[i - 1].w;
        }
        for (int i = 0; i < n; i++) {
            max = Math.max(max, pre[i] - values[i].s);
        }
        System.out.println(max);
    }

    static class Pair {
        int w;
        int s;

        public Pair(int w, int s) {
            this.w = w;
            this.s = s;
        }
    }

}
