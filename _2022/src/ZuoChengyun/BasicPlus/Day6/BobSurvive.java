package ZuoChengyun.BasicPlus.Day6;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class BobSurvive {

    private static boolean isValid(int x, int y, int M, int N) {
        return x >= 0 && y >= 0 && x < M && y < N;
    }

    public static int numOfSurvive(int M, int N, int x, int y, int steps) {
        if (steps == 0) {
            return isValid(x, y, M, N) ? 1 : 0;
        }
        if (!isValid(x, y, M, N)) {
            return 0;
        }
        return numOfSurvive(M, N, x + 1, y, steps - 1) +
                numOfSurvive(M, N, x - 1, y, steps - 1) +
                numOfSurvive(M, N, x, y + 1, steps - 1) +
                numOfSurvive(M, N, x, y - 1, steps - 1);
    }

    @Test
    void test() {
        int M = 5;
        int N = 6;
        int x = 0;
        int y = 0;
        int S = 3;

        int survive = numOfSurvive(M, N, x, y, S);
        System.out.println(survive);
        double allPossibility = Math.pow(4, S);
        System.out.println((double) survive / allPossibility);

    }

}
