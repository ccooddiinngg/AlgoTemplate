package tag.SlidingWindow;

import java.util.LinkedList;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        LinkedList<Integer> q = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        int idx = 0;
        int i = 0;
        int j = 0;
        while (j < nums.length) {
            if (j >= k) {
                if (q.peekFirst() == i) {
                    q.pollFirst();
                }
                i++;
            }
            while (!q.isEmpty() && nums[q.peekLast()] < nums[j]) {
                q.pollLast();
            }
            q.offerLast(j);
            if (j >= k - 1) {
                res[idx++] = nums[q.peekFirst()];
            }
            j++;
        }
        return res;
    }
}
