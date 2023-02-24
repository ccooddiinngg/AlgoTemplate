package Leetcode.ACW_LeetCode;

import java.util.ArrayList;
import java.util.List;

public class LC46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        bt(nums, 0, new ArrayList<>(), list);
        return list;
    }

    void bt(int[] nums, int idx, List<Integer> path, List<List<Integer>> list) {
        if (idx == nums.length) {
            list.add(new ArrayList<>(path));
            return;
        }
        for (int i = idx; i < nums.length; i++) {
            swap(nums, idx, i);
            path.add(nums[idx]);
            bt(nums, idx + 1, path, list);
            path.remove(path.size() - 1);
            swap(nums, idx, i);
        }
    }

    void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
