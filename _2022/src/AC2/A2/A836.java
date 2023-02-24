package AC2.A2;

import java.util.Scanner;

public class A836 {
    static int[] p = new int[100000];

    static {
        for (int i = 0; i < p.length; i++) {
            p[i] = i;
        }
    }

    static int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }

    static void union(int x, int y) {
        int px = find(x);
        int py = find(y);
        if (px != py) {
            p[px] = py;
        }
    }

    static boolean isSameSet(int x, int y) {
        int px = find(x);
        int py = find(y);
        return px == py;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        for (int i = 0; i < m; i++) {
            s = sc.nextLine().split(" ");
            if ("M".equals(s[0])) {
                union(Integer.parseInt(s[1]), Integer.parseInt(s[2]));
            } else {
                boolean b = isSameSet(Integer.parseInt(s[1]), Integer.parseInt(s[2]));
                if (b) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No");
                }
            }
        }
    }
}
