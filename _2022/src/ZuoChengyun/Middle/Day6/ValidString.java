package ZuoChengyun.Middle.Day6;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ValidString {
    public static int find(int rest, String path, List<String> list) {
        if (rest == 0) {
            list.add(path);
            return 1;
        }
        int v0 = 0;
        int v1 = 0;
        v0 = find(rest - 1, path + "1", list);
        if (rest >= 2) {
            v1 = find(rest - 2, path + "10", list);
        }
        return v0 + v1;
    }

    public static int findDP(int N) {
        int[] dp = new int[N + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < N + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[N];
    }

    @Test
    void test() {
        int N = 3;
        List<String> list = new ArrayList<>();
        System.out.println(find(N, "", list));
        System.out.println(list);

        System.out.println(findDP(N));
    }
}
