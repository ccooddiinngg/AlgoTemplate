package tag.BackTracking;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        bt(n, k, 1, new ArrayList<>());
        return list;
    }

    List<List<Integer>> list = new ArrayList<>();

    void bt(int n, int k, int idx, List<Integer> path) {
        if (path.size() == k) {
            list.add(new ArrayList<>(path));
            return;
        }
        for (int i = idx; i <= n; i++) {
            path.add(i);
            bt(n, k, i + 1, path);
            path.remove(path.size() - 1);
        }
    }
}
