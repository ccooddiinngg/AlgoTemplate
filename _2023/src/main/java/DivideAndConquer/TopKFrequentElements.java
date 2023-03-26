package DivideAndConquer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        int i = 0;
        int j = list.size() - 1;
        while (i < j) {
            int p = partition(list, i, j);
            if (p >= list.size() - k) {
                j = p;
            } else {
                i = p + 1;
            }
        }

        int[] ans = new int[k];
        int idx = 0;
        while (idx < ans.length) {
            ans[idx++] = list.get(i++).getKey();
        }
        return ans;
    }

    int partition(List<Map.Entry<Integer, Integer>> list, int l, int r) {
        if (l == r) return l;
        int seed = list.get(l + r >> 1).getValue();
        int i = l - 1;
        int j = r + 1;
        while (i < j) {
            while (list.get(++i).getValue() < seed) ;
            while (list.get(--j).getValue() > seed) ;
            if (i < j) {
                var t = list.get(i);
                list.set(i, list.get(j));
                list.set(j, t);
            }
        }
        return j;
    }

    @Test
    void test() {
        int[] nums = {-1, -1};
        int k = 1;
        Assertions.assertArrayEquals(new int[]{-1}, topKFrequent(nums, k));
    }
}
