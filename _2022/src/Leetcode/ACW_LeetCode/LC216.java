package Leetcode.ACW_LeetCode;

import java.util.ArrayList;
import java.util.List;

public class LC216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> list = new ArrayList<>();
        bt(1, n, k, new ArrayList<>(), list);
        return list;
    }

    void bt(int idx, int rest, int k, List<Integer> path, List<List<Integer>> list) {
        if (rest == 0 && k == 0) {
            list.add(new ArrayList<>(path));
            return;
        }
        if (k < 0) {
            return;
        }
        for (int i = idx; i <= 9; i++) {
            if (rest >= i) {
                path.add(i);
                bt(i + 1, rest - i, k - 1, path, list);
                path.remove(path.size() - 1);
            }
        }
    }
}
