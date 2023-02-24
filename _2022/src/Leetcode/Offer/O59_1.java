package Leetcode.Offer;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;

public class O59_1 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n == 0) return new int[0];
        int[] res = new int[n - k + 1];
        int idx = 0;
        LinkedList<Integer> q = new LinkedList<>();
        for (int i = -1, j = 0; j < n; j++) {
            while (!q.isEmpty() && nums[q.peekLast()] <= nums[j]) q.pollLast();
            q.offerLast(j);
            if (j - i >= k) {
                if (q.peekFirst() == i) q.pollFirst();
                res[idx++] = nums[q.peekFirst()];
                i++;
            }
        }
        return res;
    }

    @Test
    void test() {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        System.out.println(Arrays.toString(maxSlidingWindow(nums, 3)));
    }
}
