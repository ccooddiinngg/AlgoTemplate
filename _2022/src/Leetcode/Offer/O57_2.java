package Leetcode.Offer;

import java.util.ArrayList;
import java.util.List;

public class O57_2 {
    public int[][] findContinuousSequence(int target) {
        List<int[]> list = new ArrayList<>();
        for (int i = 1; i <= target / 2; i++) {
            for (int j = i + 1; j < target; j++) {
                int sum = (i + j) * (j - i + 1) / 2;
                if (sum > target) break;
                if (sum == target) {
                    int[] res = new int[j - i + 1];
                    int idx = 0;
                    for (int k = i; k <= j; k++) {
                        res[idx++] = k;
                    }
                    list.add(res);
                }
            }
        }
        int[][] ans = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}
