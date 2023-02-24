package AC2.A6;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class A125 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        P[] nums = new P[n];
        for (int i = 0; i < n; i++) {
            int w = sc.nextInt();
            int s = sc.nextInt();
            nums[i] = new P(w, s);
        }
        int max = getMax(nums, n);
        System.out.println(max);
    }


    //按 重量+强壮 从小到大从上往下排列
    static int getMax(P[] nums, int n) {
        Arrays.sort(nums, Comparator.comparingInt(a -> (a.w + a.s)));
        int[] preSum = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1].w;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, preSum[i] - nums[i].s);
        }
        return max;
    }

    static class P {
        int w;
        int s;

        public P(int w, int s) {
            this.w = w;
            this.s = s;
        }
    }
}
