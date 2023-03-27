package Heap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class FindKPairsWithSmallestSum {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int m = nums1.length;
        int n = nums2.length;
        List<List<Integer>> list = new ArrayList<>();
        Queue<int[]> q = new PriorityQueue<>((a, b) -> (nums1[a[0]] + nums2[a[1]]) - (nums1[b[0]] + nums2[b[1]]));
        for (int i = 0; i < m; i++) {
            q.offer(new int[]{i, 0});
        }
        while (!q.isEmpty() && list.size() < k) {
            int[] p = q.poll();
            list.add(List.of(nums1[p[0]], nums2[p[1]]));
            if (p[1] < n - 1) {
                q.offer(new int[]{p[0], p[1] + 1});
            }
        }
        return list;
    }

    @Test
    void test() {
        int[] nums1 = {1, 7, 11};
        int[] nums2 = {2, 4, 6};
        int k = 3;
        int[][] exp = {{1, 2}, {1, 4}, {1, 6}};
        Assertions.assertEquals(Arrays.deepToString(exp), kSmallestPairs(nums1, nums2, k).toString());
    }
}
