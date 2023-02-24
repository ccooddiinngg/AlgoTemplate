package AC3.A2;

import java.util.Scanner;

public class A1106 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        boolean[][] visited = new boolean[n][n];
        int high = 0;
        int low = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    isLow = true;
                    isHigh = true;
                    dfs(matrix, n, i, j, visited);
                    if (isLow) low++;
                    if (isHigh) high++;
                }
            }
        }
        System.out.println(high + " " + low);
    }

    static int[][] dir = {{0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}};

    static boolean isHigh = true;
    static boolean isLow = true;

    static void dfs(int[][] matrix, int n, int x, int y, boolean[][] visited) {
        boolean[] res = isHighOrLow(matrix, n, x, y);
        isHigh = isHigh && res[1];
        isLow = isLow && res[0];

        visited[x][y] = true;
        for (int i = 0; i < dir.length; i++) {
            int x1 = x + dir[i][0];
            int y1 = y + dir[i][1];
            if (x1 >= 0 && x1 < n && y1 >= 0 && y1 < n && matrix[x1][y1] == matrix[x][y] && !visited[x1][y1]) {
                dfs(matrix, n, x1, y1, visited);
            }
        }

    }

    private static boolean[] isHighOrLow(int[][] matrix, int n, int x, int y) {
        int low = 0;
        int high = 0;
        for (int i = 0; i < dir.length; i++) {
            int x1 = x + dir[i][0];
            int y1 = y + dir[i][1];
            if (x1 >= 0 && x1 < n && y1 >= 0 && y1 < n) {
                if (matrix[x1][y1] > matrix[x][y]) high++;
                if (matrix[x1][y1] < matrix[x][y]) low++;
            }
        }
        boolean[] res = new boolean[2];
        if (low == 0) res[0] = true;
        if (high == 0) res[1] = true;
        return res;
    }
}
