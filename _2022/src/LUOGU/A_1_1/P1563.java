package LUOGU.A_1_1;

import java.util.Scanner;

public class P1563 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[] facing = new int[m];
        String[] names = new String[m];
        for (int i = 0; i < m; i++) {
            facing[i] = sc.nextInt();
            names[i] = sc.next();
        }
        int idx = 0;
        for (int j = 0; j < n; j++) {
            int dir = sc.nextInt();
            int step = sc.nextInt();
            if ((facing[idx] ^ dir) == 0) {
                idx -= step;
            } else {
                idx += step;
            }
            idx = (idx + m) % m;
        }
        System.out.println(names[idx]);
    }
}
