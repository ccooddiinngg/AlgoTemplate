package AC3.A4;

import java.util.Scanner;

public class A241 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        t = new int[n + 1];

        int[] nums = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            nums[i] = sc.nextInt();
        }
        find(nums, n);
    }

    static int n;
    static int[] t;

    static void update(int i, int val) {
        while (i <= n) {
            t[i] += val;
            i += i & -i;
        }
    }

    static int ask(int i) {
        int res = 0;
        while (i > 0) {
            res += t[i];
            i -= i & -i;
        }
        return res;
    }

    static void find(int[] nums, int n) {
        long res1 = 0;
        long res2 = 0;
        for (int i = 1; i <= n; i++) {
            int v = nums[i];
            int g = ask(n) - ask(v);
            int l = ask(v - 1);
            res1 += (long) g * (n - v - g);
            res2 += (long) l * (v - 1 - l);
            update(v, 1);
        }
        System.out.println(res1 + " " + res2);
    }
}
