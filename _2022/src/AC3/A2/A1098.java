package AC3.A2;

import java.util.Scanner;

public class A1098 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][][] matrix = new int[m][n][4];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int num = sc.nextInt();
                int[] wall = getWall(num);
                matrix[i][j] = wall;
            }
        }
        boolean[][] visited = new boolean[m][n];
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    count++;
                    size = 0;
                    dfs(matrix, m, n, i, j, visited);
                }
            }
        }
        System.out.println(count);
        System.out.println(maxSize);
    }

    static int size = 0;
    static int maxSize = 0;

    static void dfs(int[][][] matrix, int m, int n, int x, int y, boolean[][] visited) {
        visited[x][y] = true;
        size++;
        maxSize = Math.max(maxSize, size);
        for (int i = 0; i < 4; i++) {
            if (matrix[x][y][i] == 0) {
                int x1 = x + direction[i][0];
                int y1 = y + direction[i][1];
                if (x1 >= 0 && x1 < m && y1 >= 0 && y1 < n && !visited[x1][y1]) {
                    dfs(matrix, m, n, x1, y1, visited);
                }
            }
        }
    }

    static int[][] direction = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static int[] dir = {8, 4, 2, 1};

    static int[] getWall(int n) {
        int[] wall = new int[4];
        for (int i = 0; i < dir.length; i++) {
            if (n >= dir[i]) {
                wall[i] = 1;
                n -= dir[i];
            }
        }
        return wall;
    }
}
