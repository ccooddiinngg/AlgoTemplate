package AC2.A2;

import java.util.Scanner;

public class A841 {
    static long[] h = new long[100010];
    static long[] p = new long[100010];
    static int P = 131;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        String s = sc.next();
        p[0] = 1;
        for (int i = 1; i <= s.length(); i++) {
            p[i] = p[i - 1] * P;
            h[i] = h[i - 1] * P + s.charAt(i - 1);
        }

        for (int i = 0; i < m; i++) {
            int l1 = sc.nextInt();
            int r1 = sc.nextInt();
            int l2 = sc.nextInt();
            int r2 = sc.nextInt();
            long h1 = h[r1] - h[l1 - 1] * p[r1 - l1 + 1];
            long h2 = h[r2] - h[l2 - 1] * p[r2 - l2 + 1];
            if (h1 == h2) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }

}
