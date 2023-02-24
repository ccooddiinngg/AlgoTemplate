package Leetcode.NeetCode;

import java.util.PriorityQueue;
import java.util.Queue;


//@@ keep k largest nums
public class N703 {
    int k;
    Queue<Integer> min;

    public N703(int k, int[] nums) {
        this.k = k;
        min = new PriorityQueue<>(k);

        for (int i = 0; i < nums.length; i++) {
            add(nums[i]);
        }

    }

    public int add(int val) {
        if (min.size() < k) {
            min.add(val);
        } else if (min.peek() < val) {
            min.poll();
            min.add(val);
        }
        return min.peek();
    }
}
