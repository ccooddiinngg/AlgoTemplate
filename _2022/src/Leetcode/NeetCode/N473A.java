package Leetcode.NeetCode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

//473. Matchsticks to Square
//@@ dfs 4 times , O(4 * 2 ^ m)
public class N473A {
    public boolean makesquare(int[] matchsticks) {
        int m = matchsticks.length;
        int sum = 0;
        for (int stick : matchsticks) {
            sum += stick;
        }
        int edges = 4;
        if (sum % edges != 0) {
            return false;
        }
        for (int stick : matchsticks) {
            if (stick > sum / edges) {
                return false;
            }
        }
        Arrays.sort(matchsticks);
        for (int i = 0; i < m / 2; i++) {
            int t = matchsticks[i];
            matchsticks[i] = matchsticks[m - 1 - i];
            matchsticks[m - 1 - i] = t;
        }

        boolean[] used = new boolean[m];
        return dfs(matchsticks, used, 0, sum / edges, 0, edges);
    }

    public boolean dfs(int[] matchsticks, boolean[] used, int index, int target, int path, int edges) {
        if (edges == 0) {
            return true;
        }
        if (path == target) {
            return dfs(matchsticks, used, 0, target, 0, edges - 1);
        }

        for (int i = index; i < matchsticks.length; i++) {
            if (!used[i] && matchsticks[i] + path <= target) {
                used[i] = true;
                path += matchsticks[i];
                if (dfs(matchsticks, used, i + 1, target, path, edges)) {
                    return true;
                }
                used[i] = false;
                path -= matchsticks[i];
            }
        }
        return false;
    }

    @Test
    void test() {
        int[] matchsticks = {1, 1, 1, 1, 1, 1, 1, 1};
        System.out.println(makesquare(matchsticks));
    }
}
