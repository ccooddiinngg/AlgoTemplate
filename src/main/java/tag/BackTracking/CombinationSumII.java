package tag.BackTracking;

import java.util.*;

public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        bt(candidates, target, 0, new ArrayList<>());
        return list;
    }

    List<List<Integer>> list = new ArrayList<>();

    void bt(int[] candidates, int rest, int idx, List<Integer> path) {
        if (rest == 0) {
            list.add(new ArrayList<>(path));
            return;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = idx; i < candidates.length; i++) {
            if (rest >= candidates[i] && !set.contains(candidates[i])) {
                set.add(candidates[i]);
                path.add(candidates[i]);
                bt(candidates, rest - candidates[i], i + 1, path);
                path.remove(path.size() - 1);
            }
        }
    }
}
