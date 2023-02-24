package Leetcode.MostLiked100;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int max = 0;

        //!using set instead of array to optimise speed
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int start = num;
                int length = 1;
                while (set.contains(start + 1)) {
                    start++;
                    length++;
                }
                max = Math.max(max, length);
            }
        }
        return max;
    }
}
