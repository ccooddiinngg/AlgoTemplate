package AC2.A2;

import java.util.Scanner;

public class A240 {
    static int[] p = new int[50010];
    static int[] d = new int[50010];

    static {
        for (int i = 0; i < p.length; i++) {
            p[i] = i;
            d[i] = 0;
        }
    }

    static int find(int x) {
        if (p[x] != x) {
            //先执行find， 更新d[p[x]]
            int t = find(p[x]);
            d[x] += d[p[x]];
            p[x] = t;
        }
        return p[x];
    }

    static boolean eat(int x, int y) {
        int px = find(x);
        int py = find(y);
        if (px != py) {
            p[px] = py;
            d[px] = d[y] - d[x] + 1;
            return true;
        } else {
            return (d[x] - d[y] - 1) % 3 == 0;
        }
    }

    static boolean isSame(int x, int y) {
        int px = find(x);
        int py = find(y);
        if (px != py) {
            p[px] = py;
            d[px] = d[y] - d[x];
            return true;
        } else {
            return (d[y] - d[x]) % 3 == 0;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int count = 0;
        for (int i = 0; i < K; i++) {
            int op = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();
            if (x > N || y > N) {
                count++;
                continue;
            }
            if (op == 1 && !isSame(x, y)) {
                count++;
            }
            if (op == 2 && !eat(x, y)) {
                count++;
            }
        }
        System.out.println(count);
    }
}
