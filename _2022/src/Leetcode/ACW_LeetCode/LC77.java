package Leetcode.ACW_LeetCode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class LC77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<>();

        bt(n, 1, k, new ArrayList<>(), list);
        return list;
    }

    void bt(int n, int idx, int k, List<Integer> path, List<List<Integer>> list) {
        if (path.size() == k) {
            list.add(new ArrayList<>(path));
            return;
        }
        for (int i = idx; i <= n; i++) {
            path.add(i);
            bt(n, i + 1, k, path, list);
            path.remove(path.size() - 1);
        }
    }

    @Test
    void test() {
        int n = 4;
        int k = 2;
        System.out.println(combine(n, k));
    }
}
