package tag.BackTracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        bt(k, n, 1, new ArrayList<>());
        return list;
    }

    List<List<Integer>> list = new ArrayList<>();

    void bt(int k, int rest, int idx, List<Integer> path) {
        if (rest == 0 && path.size() == k) {
            list.add(new ArrayList<>(path));
            return;
        }
        for (int i = idx; i <= 9; i++) {
            if (i <= rest && path.size() < k) {
                path.add(i);
                bt(k, rest - i, i + 1, path);
                path.remove(path.size() - 1);
            }
        }
    }
}
