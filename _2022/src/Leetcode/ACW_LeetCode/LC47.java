package Leetcode.ACW_LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        bt(nums, 0, new ArrayList<>(), list);
        return list;
    }

    void bt(int[] nums, int idx, List<Integer> path, List<List<Integer>> list) {
        if (idx == nums.length) {
            list.add(new ArrayList<>(path));
            return;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = idx; i < nums.length; i++) {
            if (!set.contains(nums[i])) {
                set.add(nums[i]);
                swap(nums, idx, i);
                path.add(nums[idx]);
                bt(nums, idx + 1, path, list);
                path.remove(path.size() - 1);
                swap(nums, idx, i);
            }
        }
    }

    void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
