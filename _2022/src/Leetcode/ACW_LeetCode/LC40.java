package Leetcode.ACW_LeetCode;

import java.util.*;

public class LC40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, target, 0, new ArrayList<>(), list);
        return list;
    }

    void dfs(int[] candidates, int rest, int idx, List<Integer> path, List<List<Integer>> list) {
        if (rest == 0) {
            list.add(new ArrayList<>(path));
            return;
        }
        if (idx == candidates.length) return;
        Set<Integer> set = new HashSet<>();
        for (int i = idx; i < candidates.length; i++) {
            if (candidates[i] <= rest) {
                if (!set.contains(candidates[i])) {
                    set.add(candidates[i]);
                    path.add(candidates[i]);
                    dfs(candidates, rest - candidates[i], i + 1, path, list);
                    path.remove(path.size() - 1);
                }
            }
        }
    }

}
