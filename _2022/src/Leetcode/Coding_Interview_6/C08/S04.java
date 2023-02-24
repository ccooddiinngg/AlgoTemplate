package Leetcode.Coding_Interview_6.C08;

import java.util.ArrayList;
import java.util.List;

public class S04 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        list.add(path);
        dfs(nums, nums.length, 0, list, path);
        return list;
    }

    void dfs(int[] nums, int n, int idx, List<List<Integer>> list, List<Integer> path) {
        for (int i = idx; i < n; i++) {
            int num = nums[i];
            path.add(num);
            list.add(new ArrayList<>(path));
            dfs(nums, n, i + 1, list, path);
            path.remove(path.size() - 1);
        }
    }
}
