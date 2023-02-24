package AC3.A2;

import java.util.Scanner;

public class A1097 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] matrix = new int[m][n];
        String s = "";
        for (int i = 0; i < m; i++) {
            s = sc.next();
            for (int j = 0; j < n; j++) {
                matrix[i][j] = s.charAt(j) == '.' ? 0 : 1;
            }
        }
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    count++;
                    dfs(matrix, m, n, i, j);
                }
            }
        }
        System.out.println(count);
    }

    static int[][] dir = {{0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}};

    static void dfs(int[][] matrix, int m, int n, int x, int y) {
        matrix[x][y] = 0;
        for (int i = 0; i < dir.length; i++) {
            int x1 = x + dir[i][0];
            int y1 = y + dir[i][1];
            if (x1 >= 0 && x1 < m && y1 >= 0 && y1 < n && matrix[x1][y1] == 1) {
                dfs(matrix, m, n, x1, y1);
            }
        }
    }
}
