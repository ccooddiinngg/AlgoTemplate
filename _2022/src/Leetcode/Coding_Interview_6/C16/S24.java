package Leetcode.Coding_Interview_6.C16;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class S24 {
    public List<List<Integer>> pairSums(int[] nums, int target) {
        int n = nums.length;
        List<List<Integer>> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int i = 0; i < n; i++) {
            int t = target - nums[i];
            if (nums[i] == t && map.get(nums[i]) < 2) continue;
            if (map.get(nums[i]) > 0 && map.containsKey(t) && map.get(t) > 0) {
                list.add(List.of(nums[i], t));
                map.put(nums[i], map.get(nums[i]) - 1);
                map.put(t, map.get(t) - 1);
            }
        }
        return list;
    }
}
