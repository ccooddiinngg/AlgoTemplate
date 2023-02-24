package Leetcode.Coding_Interview_6.C10;

import java.util.ArrayList;
import java.util.List;

public class S11a {
    List<List<Integer>> list = new ArrayList<>();

    public void wiggleSort(int[] nums) {
        dfs(nums, 0, true);
    }

    void dfs(int[] nums, int idx, boolean top) {
        if (idx == nums.length) {
            List<Integer> l = new ArrayList<>();
            for (int num : nums) {
                l.add(num);
            }
            list.add(l);
            return;
        }
        for (int i = idx; i < nums.length; i++) {
            if (idx == 0) {
                swap(nums, i, idx);
                dfs(nums, idx + 1, top);
                dfs(nums, idx + 1, !top);
                swap(nums, i, idx);
            } else {
                if ((top && nums[i] >= nums[idx - 1])) {
                    swap(nums, i, idx);
                    dfs(nums, idx + 1, !top);
                    swap(nums, i, idx);
                }
                if ((!top && nums[i] <= nums[idx - 1])) {
                    swap(nums, i, idx);
                    dfs(nums, idx + 1, !top);
                    swap(nums, i, idx);
                }
            }
        }
    }

    void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
