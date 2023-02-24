package ZuoChengyun.Middle.Day6;

import ZuoChengyun.Basic.Utils.Utils;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class SnackPack {
    public static int find(int[] arr, int rest, int index, String path, List<String> list) {
        if (index >= arr.length) {
            list.add(path);
            return 1;
        }
        int v0 = 0;
        int v1 = 0;
        if (rest - arr[index] >= 0) {
            v1 = find(arr, rest - arr[index], index + 1, path + "+" + arr[index], list);
        }
        v0 = find(arr, rest, index + 1, path, list);
        return v0 + v1;
    }

    public static int findDP(int[] arr, int W) {
        int[][] dp = new int[arr.length + 1][W + 1];
        for (int j = 0; j < dp[0].length; j++) {
            dp[dp.length - 1][j] = 1;
        }
        for (int i = dp.length - 2; i >= 0; i--) {
            for (int j = 0; j < dp[0].length; j++) {
                if (j - arr[i] >= 0) {
                    dp[i][j] += dp[i + 1][j - arr[i]];
                }
                dp[i][j] += dp[i + 1][j];
            }
        }
        Utils.print2DArray(dp);
        return dp[0][W];
    }

    @Test
    void test() {
        int[] arr = {1, 2, 3, 5};
        int W = 8;
        List<String> list = new ArrayList<>();
        System.out.println(find(arr, W, 0, "", list));
        System.out.println(list);

        System.out.println(findDP(arr, W));
    }
}
