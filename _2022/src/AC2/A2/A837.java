package AC2.A2;

import java.util.Scanner;

public class A837 {
    static int[] p = new int[100010];
    static int[] size = new int[100010];

    static {
        for (int i = 0; i < p.length; i++) {
            p[i] = i;
            size[i] = 1;
        }
    }

    static int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }

    static boolean isSameSet(int x, int y) {
        int px = find(x);
        int py = find(y);
        return px == py;
    }

    static void union(int x, int y) {
        int px = find(x);
        int py = find(y);
        if (px != py) {
            p[px] = py;
            size[py] += size[px];
        }
    }

    static int getSize(int x) {
        return size[find(x)];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        for (int i = 0; i < m; i++) {
            s = sc.nextLine().split(" ");
            switch (s[0]) {
                case "C":
                    union(Integer.parseInt(s[1]), Integer.parseInt(s[2]));
                    break;
                case "Q1":
                    boolean b = isSameSet(Integer.parseInt(s[1]), Integer.parseInt(s[2]));
                    if (b) {
                        System.out.println("Yes");
                    } else {
                        System.out.println("No");
                    }
                    break;
                case "Q2":
                    System.out.println(getSize(Integer.parseInt(s[1])));
                    break;
                default:
                    break;
            }
        }
    }
}
