package Leetcode.ACW_LeetCode;

import java.util.HashMap;
import java.util.Map;

public class LC930 {
    public int numSubarraysWithSum(int[] nums, int goal) {
        Map<Integer, Integer> map = new HashMap<>();
        int pre = 0;
        map.put(0, 1);
        int count = 0;
        for (int num : nums) {
            pre += num;
            int t = pre - goal;
            if (map.containsKey(t)) {
                count += map.get(t);
            }
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return count;
    }
}
