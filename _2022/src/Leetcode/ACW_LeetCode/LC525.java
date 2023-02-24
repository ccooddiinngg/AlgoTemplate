package Leetcode.ACW_LeetCode;

import java.util.HashMap;
import java.util.Map;

public class LC525 {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int max = 0;
        int preSum = 0;
        for (int i = 0; i < n; i++) {
            int num = nums[i] == 0 ? -1 : 1;
            preSum += num;
            if (map.containsKey(preSum)) {
                max = Math.max(max, i - map.get(preSum));
            } else {
                map.put(preSum, i);
            }

        }
        return max;
    }
}
