package Leetcode.NeetCode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

//473. Matchsticks to Square
//@@ SORT, try to put it to 4 edges, O(4 ^ m)
public class N473 {
    public boolean makesquare(int[] matchsticks) {
        int m = matchsticks.length;
        int sum = 0;
        for (int num : matchsticks) {
            sum += num;
        }
        if (sum % 4 != 0) {
            return false;
        }
        for (int num : matchsticks) {
            if (num > sum / 4) {
                return false;
            }
        }
        int[] edges = new int[4];
        Arrays.sort(matchsticks);
        for (int i = 0; i < m / 2; i++) {
            int t = matchsticks[i];
            matchsticks[i] = matchsticks[m - 1 - i];
            matchsticks[m - 1 - i] = t;
        }
        return helper(matchsticks, 0, edges, sum / 4);
    }

    public boolean helper(int[] matchsticks, int index, int[] edges, int max) {
        if (index == matchsticks.length) {
            return true;
        }
        boolean b = false;
        for (int i = 0; i < edges.length; i++) {
            if (edges[i] + matchsticks[index] <= max) {
                edges[i] += matchsticks[index];
                if (helper(matchsticks, index + 1, edges, max)) {
                    return true;
                }
                edges[i] -= matchsticks[index];
            }
        }
        return b;
    }

    @Test
    void test() {
        int[] matchsticks = {1, 1, 2, 2, 2};
//        int[] matchsticks = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 102};
        System.out.println(makesquare(matchsticks));
    }
}
