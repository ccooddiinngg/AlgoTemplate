package AC2_Course.DP;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class A91 {

    File file = new File("src/ACWING/DP/A91Data.txt");
    File file1 = new File("src/ACWING/DP/A91Data1.txt");

    int[][] input(File file) {
        Scanner sc = null;
        try {
            sc = new Scanner(file);
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }
            return matrix;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Test
    void testBruteForce() {
        int[][] matrix = input(file);
        int n = matrix.length;
        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        int res = dfs(n, 0, matrix, visited);
        System.out.println(res);
    }

    //bruteforce ans = 128 ; time: 500 s
    int dfs(int n, int curr, int[][] matrix, Set<Integer> visited) {
        if (visited.size() == n - 1) {
            return matrix[curr][n - 1];
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n - 1; i++) {
            if (!visited.contains(i)) {
                visited.add(i);
                min = Math.min(min, dfs(n, i, matrix, visited) + matrix[curr][i]);
                visited.remove(i);
            }
        }
        return min;
    }

    @Test
    void testDP() {
        int[][] matrix = input(file1);
        int n = matrix.length;

        int[][] dp = new int[1 << n][n];
        for (int[] row : dp) {
            Arrays.fill(row, 0x3f3f3f3f);
        }
        dp[1][0] = 0;
        for (int state = 0; state < 1 << n; state++) {
            if ((state & 1) == 1) {
                for (int j = 0; j < n; j++) {
                    if ((state >> j & 1) == 1) {
                        for (int k = 0; k < n; k++) {
                            dp[state][j] = Math.min(dp[state][j], dp[state ^ (1 << j)][k] + matrix[k][j]);
                        }
                    }
                }
            }
        }

        System.out.println(dp[(1 << n) - 1][n - 1]);
    }

}
