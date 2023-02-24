package Leetcode.ACW_LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LC128 {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        US us = new US(nums.length);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) continue;
            if (map.containsKey(nums[i] + 1)) {
                us.union(i, map.get(nums[i] + 1));
            }
            if (map.containsKey(nums[i] - 1)) {
                us.union(i, map.get(nums[i] - 1));
            }
            map.put(nums[i], i);
        }
        int max = 0;
        for (int val: us.size) {
            max = Math.max(max, val);
        }
        return max;
    }

    class US {
        int[] p;
        int[] size;
        public US(int n) {
            p = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                p[i] = i;
            }
            Arrays.fill(size, 1);
        }

        int find(int n) {
            if (p[n] != n) {
                p[n] = find(p[n]);
            }
            return p[n];
        }

        void union(int n1, int n2) {
            int p1 = find(n1);
            int p2 = find(n2);
            if (p1 != p2) {
                p[p1] = p2;
                size[p2] += size[p1];
            }
        }

        boolean isSameSet(int n1, int n2) {
            int p1 = find(n1);
            int p2 = find(n2);
            return p1 == p2;
        }
    }
}
