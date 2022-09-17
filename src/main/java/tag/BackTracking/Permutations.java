package tag.BackTracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        bt(nums, 0, new ArrayList<>());
        return list;
    }

    List<List<Integer>> list = new ArrayList<>();

    void bt(int[] nums, int idx, List<Integer> path) {
        if (idx == nums.length) {
            list.add(new ArrayList<>(path));
            return;
        }
        for (int i = idx; i < nums.length; i++) {
            swap(nums, idx, i);
            path.add(nums[idx]);
            bt(nums, idx + 1, path);
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
