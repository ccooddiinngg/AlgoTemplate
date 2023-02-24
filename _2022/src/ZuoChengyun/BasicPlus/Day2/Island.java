package ZuoChengyun.BasicPlus.Day2;

import ZuoChengyun.Basic.Utils.Utils;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Island {
    public static int find(int[][] m) {
        int count = 0;
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                if (m[i][j] == 1) {
                    dfs(m, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private static void dfs(int[][] m, int i, int j) {
        if (i < 0 || j < 0 || i == m.length || j == m[0].length || m[i][j] == 0) {
            return;
        }
        m[i][j] = 0;
        dfs(m, i, j + 1);
        dfs(m, i + 1, j);
        dfs(m, i, j - 1);
        dfs(m, i - 1, j);
    }

    @Test
    void findTest() {
        String[] island = {
                "001010",
                "111010",
                "101100",
                "011000"};

        int[][] m = Arrays.stream(island).map(row -> row.chars().map(c -> c - '0')
                .toArray()).toArray(int[][]::new);
        Utils.print2DArray(m);

        int count = find(m);
        Utils.print2DArray(m);
        System.out.println(count);
    }
}
