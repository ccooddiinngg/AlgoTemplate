package Leetcode.ACW_LeetCode;

import java.util.LinkedList;

public class LC239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        LinkedList<Integer> q = new LinkedList<>();
        int[] res = new int[nums.length + 1 - k];
        int idx = 0;
        for (int i = 0, j = 0; j < nums.length; j++) {

            while (!q.isEmpty() && nums[q.peekLast()] <= nums[j]) {
                q.pollLast();
            }
            q.offerLast(j);
            if (j >= k) {
                if (q.peekFirst() == i) {
                    q.pollFirst();
                }
                i++;
            }

            if (j >= k - 1) {
                res[idx++] = nums[q.peekFirst()];
            }
        }
        return res;
    }
}
