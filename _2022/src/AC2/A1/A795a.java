package AC2.A1;

import java.util.Scanner;

//树状数组
public class A795a {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        BIT bit = new BIT(n);
        for (int i = 1; i <= n; i++) {
            int val = sc.nextInt();
            bit.update(i, val);
        }

        for (int i = 0; i < q; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            int res = bit.ask(r) - bit.ask(l - 1);
            System.out.println(res);
        }
    }

    static class BIT {
        int n;
        int[] t;

        public BIT(int n) {
            this.n = n;
            t = new int[n + 1];
        }

        private int lowBit(int n) {
            return n & -n;
        }

        public void update(int i, int v) {
            while (i <= n) {
                t[i] += v;
                i += lowBit(i);
            }
        }

        public int ask(int i) {
            int res = 0;
            while (i > 0) {
                res += t[i];
                i -= lowBit(i);
            }
            return res;
        }
    }
}

