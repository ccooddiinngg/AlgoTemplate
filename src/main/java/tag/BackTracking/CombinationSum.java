package tag.BackTracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        bt(candidates, target, 0, new ArrayList<>());
        return list;
    }

    List<List<Integer>> list = new ArrayList<>();

    void bt(int[] candidates, int rest, int idx, List<Integer> path) {
        if (rest == 0) {
            list.add(new ArrayList<>(path));
            return;
        }
        for (int i = idx; i < candidates.length; i++) {
            if (candidates[i] <= rest) {
                path.add(candidates[i]);
                bt(candidates, rest - candidates[i], i, path);
                path.remove(path.size() - 1);
            }
        }
    }
}
