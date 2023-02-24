package AC3.A1;

import java.util.Arrays;
import java.util.Scanner;

public class A1012 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        P[] ps = new P[n];
        for (int i = 0; i < n; i++) {
            int f = sc.nextInt();
            int t = sc.nextInt();
            ps[i] = new P(f, t);
        }
        int max = getMax(ps, n);
        System.out.println(max);

    }

    static int getMax(P[] ps, int n) {
        Arrays.sort(ps, (a, b) -> a.f - b.f);
        int[] count = new int[n + 2];
        Arrays.fill(count, Integer.MAX_VALUE);
        count[0] = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int idx = find(count, ps[i].t);
            count[idx] = ps[i].t;
        }
        int max = find(count, Integer.MAX_VALUE) - 1;
        return max;
    }

    static int find(int[] count, int num) {
        int i = 0;
        int j = count.length - 1;
        while (i < j) {
            int mid = i + (j - i) / 2;
            if (count[mid] >= num) {
                j = mid;
            } else {
                i = mid + 1;
            }
        }
        return i;
    }

    static class P {
        int f;
        int t;

        public P(int f, int t) {
            this.f = f;
            this.t = t;
        }
    }
}
