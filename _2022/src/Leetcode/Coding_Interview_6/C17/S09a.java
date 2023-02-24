package Leetcode.Coding_Interview_6.C17;

import java.util.PriorityQueue;
import java.util.Queue;

public class S09a {
    public int getKthMagicNumber(int k) {
        Queue<Long> q = new PriorityQueue<>();
        int[] nums = {3, 5, 7};
        q.add((long) 1);
        while (k > 1) {
            long curr = q.poll();
            while (!q.isEmpty() && curr == q.peek()) {
                curr = q.poll();
            }
            k--;
            for (int i = 0; i < nums.length; i++) {
                q.add(nums[i] * curr);
            }
        }
        long res = q.poll();
        return (int) res;
    }
}
