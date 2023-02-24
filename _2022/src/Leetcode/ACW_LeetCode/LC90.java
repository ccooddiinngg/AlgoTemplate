package Leetcode.ACW_LeetCode;

import org.junit.jupiter.api.Test;

import java.util.*;

public class LC90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        //Sort first
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>());
        bt(nums, 0, new ArrayList<>(), list);
        return list;
    }

    void bt(int[] nums, int idx, List<Integer> path, List<List<Integer>> list) {
        if (idx == nums.length) return;
        Set<Integer> set = new HashSet<>();
        for (int i = idx; i < nums.length; i++) {
            if (set.contains(nums[i])) continue;
            set.add(nums[i]);
            path.add(nums[i]);
            list.add(new ArrayList<>(path));
            //! not idx + 1
            bt(nums, i + 1, path, list);
            path.remove(path.size() - 1);
        }
    }

    @Test
    void test() {
        int[] nums = {1, 2, 2};
        System.out.println(subsetsWithDup(nums));
    }
}
