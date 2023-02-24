package Leetcode.Coding_Interview_6.C17;

import java.util.HashMap;
import java.util.Map;

public class S05 {
    public String[] findLongestSubarray(String[] array) {
        int n = array.length;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            if ("0123456789".contains(String.valueOf(array[i].charAt(0)))) {
                nums[i] = 1;
            } else {
                nums[i] = -1;
            }
        }

        int[] pre = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            pre[i] = pre[i - 1] + nums[i - 1];
        }

        int max = 0;
        int l = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < pre.length; i++) {
            if (map.containsKey(pre[i])) {
                if (i - map.get(pre[i]) > max) {
                    max = i - map.get(pre[i]);
                    l = map.get(pre[i]);
                }
            } else {
                map.put(pre[i], i);
            }
        }
        String[] res = new String[max];
        for (int i = 0, j = l; i < res.length; i++, j++) {
            res[i] = array[j];
        }
        return res;
    }
}
