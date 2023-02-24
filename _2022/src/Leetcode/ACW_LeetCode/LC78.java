package Leetcode.ACW_LeetCode;

import java.util.ArrayList;
import java.util.List;

public class LC78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>());
        bt(nums, 0, new ArrayList<>(), list);

        return list;
    }

    void bt(int[] nums, int idx, List<Integer> path, List<List<Integer>> list) {
        if (idx == nums.length) {
            return;
        }
        for (int i = idx; i < nums.length; i++) {
            path.add(nums[i]);
            list.add(new ArrayList<>(path));
            bt(nums, i + 1, path, list);
            path.remove(path.size() - 1);
        }
    }
}
