package Leetcode.NeetCode;

import java.util.*;


//@@ House Robbing
public class N740 {
    public int deleteAndEarn(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + num);
        }

        List<Integer> list = new ArrayList<>(map.keySet());

        Collections.sort(list);

        int[] dp = new int[list.size() + 2];
        for (int i = dp.length - 3; i >= 0; i--) {
            int v0 = 0;
            int v1 = map.get(list.get(i));
            if (i + 1 < list.size() && list.get(i + 1) != list.get(i) + 1) {
                v1 += dp[i + 1];
            } else {
                v0 += dp[i + 1];
                v1 += dp[i + 2];
            }
            dp[i] = Math.max(v0, v1);
        }

        return dp[0];
    }

    //bruteForce
    public int helper(List<Integer> list, Map<Integer, Integer> map, int index) {
        if (index >= list.size()) {
            return 0;
        }
        int v0 = 0;
        int v1 = map.get(list.get(index));
        if (index + 1 < list.size() && list.get(index + 1) != list.get(index) + 1) {
            v1 += helper(list, map, index + 1);
        } else {
            v0 += helper(list, map, index + 1);
            v1 += helper(list, map, index + 2);
        }
        return Math.max(v0, v1);
    }
}
