package ZuoChengyun.Basic.Day14;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Queens {

    public static int queens(int N, int i, int[][] map, Set<Integer[]> result) {
        if (i == N) {
            result.add(flat2DArray(map));
            return 1;
        }
        int count = 0;
        for (int j = 0; j < N; j++) {
            if (valid(map, i, j)) {
                map[i][j] = 1;
                count += queens(N, i + 1, map, result);
                map[i][j] = 0;
            }
        }
        return count;
    }

    private static Integer[] flat2DArray(int[][] map) {
        Integer[] flatten = new Integer[map.length];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == 1) {
                    flatten[i] = j;
                }
            }
        }
        return flatten;
    }

    private static boolean valid(int[][] map, int i, int j) {
        return !sameColumn(map, j) && !sameDiagonal(map, i, j);
    }

    private static boolean sameDiagonal(int[][] map, int i, int j) {
        for (int d = 0; d < map.length; d++) {
            if (i - d >= 0 && j - d >= 0 && map[i - d][j - d] == 1) {
                return true;
            }
            if (i - d >= 0 && j + d < map.length && map[i - d][j + d] == 1) {
                return true;
            }
        }
        return false;
    }

    private static boolean sameColumn(int[][] map, int j) {
        for (int[] row : map) {
            if (row[j] == 1) return true;
        }
        return false;
    }

    @Test
    void queensTest() {
        int N = 8;
        int[][] map = new int[N][N];
        Set<Integer[]> result = new HashSet<>();
        int queens = queens(N, 0, map, result);
        System.out.println(queens);
        for (Integer[] arr : result) {
            System.out.println(Arrays.toString(arr));
        }
    }
}
