package LUOGU.A_1_1;

import java.util.Scanner;

public class P2670 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            String s = sc.next();
            for (int j = 0; j < n; j++) {
                if (s.charAt(j) == '*') {
                    matrix[i][j] = 1;
                }
            }
        }
        int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    int count = 0;
                    for (int k = 0; k < dir.length; k++) {
                        int i1 = i + dir[k][0];
                        int j1 = j + dir[k][1];
                        if (i1 >= 0 && i1 < m && j1 >= 0 && j1 < n && matrix[i1][j1] == 1) {
                            count++;
                        }
                    }
                    System.out.print(count);
                } else {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }
}
