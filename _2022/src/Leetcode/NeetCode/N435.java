package Leetcode.NeetCode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class N435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int count = 0;
        //@@ could be negative number
        int end = Integer.MIN_VALUE;
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] < end) {
                count++;
                if (intervals[i][1] < end) {
                    end = intervals[i][1];
                }
            } else {
                end = intervals[i][1];
            }
        }
        return count;
    }

    @Test
    void test() {
        int[][] intervals = {{1, 2}, {2, 3}, {3, 4}, {-100, -2}, {5, 7}};
        System.out.println(eraseOverlapIntervals(intervals));
    }
}
