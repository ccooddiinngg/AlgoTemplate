package LUOGU.A_1_1;

import java.util.Scanner;

public class P1328 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int P = 5;
        int[][] matrix = {{0, 1, 2, 2, 1}, {2, 0, 1, 2, 1}, {1, 2, 0, 1, 2},
                {1, 1, 2, 0, 2}, {2, 2, 1, 1, 0}};

        int m = sc.nextInt();
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int[] p1 = new int[n1];
        int[] p2 = new int[n2];
        for (int i = 0; i < n1; i++) {
            p1[i] = sc.nextInt();
        }
        for (int i = 0; i < n2; i++) {
            p2[i] = sc.nextInt();
        }
        int score1 = 0;
        int score2 = 0;
        for (int i = 0; i < m; i++) {
            int o1 = p1[i % n1];
            int o2 = p2[i % n2];
            if (matrix[o1][o2] == 1) {
                score2++;
            } else if (matrix[o1][o2] == 2) {
                score1++;
            }
        }
        System.out.println(score1 + " " + score2);
    }
}
