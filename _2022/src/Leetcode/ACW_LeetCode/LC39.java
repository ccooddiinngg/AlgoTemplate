package Leetcode.ACW_LeetCode;

import java.util.ArrayList;
import java.util.List;

public class LC39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        dfs(candidates, target, 0, new ArrayList<>(), list);
        return list;
    }

    void dfs(int[] candidates, int rest, int idx, List<Integer> path, List<List<Integer>> list) {
        if (rest == 0) {
            list.add(new ArrayList<>(path));
            return;
        }
        for (int i = idx; i < candidates.length; i++) {
            if (rest >= candidates[i]) {
                path.add(candidates[i]);
                dfs(candidates, rest - candidates[i], i, path, list);
                path.remove(path.size() - 1);
            }
        }
    }

}
