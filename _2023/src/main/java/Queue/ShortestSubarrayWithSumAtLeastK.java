package Queue;

import java.util.LinkedList;

public class ShortestSubarrayWithSumAtLeastK {
    public int shortestSubarray(int[] nums, int k) {
        int m = nums.length;
        LinkedList<Integer> q = new LinkedList<>();
        long[] pre = new long[m + 1];
        for (int i = 1; i < m + 1; i++) {
            pre[i] = pre[i - 1] + nums[i - 1];
        }
        long min = Long.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < m + 1; i++) {
            while (!q.isEmpty() && pre[i] - pre[q.peekFirst()] >= k) {
                min = Math.min(min, i - q.peekFirst());
                q.pollFirst();
            }
            while (!q.isEmpty() && pre[i] <= pre[q.peekLast()]) {
                q.pollLast();
            }
            q.offerLast(i);
        }
        return min == Long.MAX_VALUE ? -1 : (int) min;
    }
}
