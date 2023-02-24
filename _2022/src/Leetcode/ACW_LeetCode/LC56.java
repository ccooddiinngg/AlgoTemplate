package Leetcode.ACW_LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int end = Integer.MIN_VALUE;
        int start = Integer.MIN_VALUE;
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] <= end) {
                end = Math.max(end, intervals[i][1]);
            }else {
                if (i != 0) {
                    list.add(new int[] {start, end});
                }
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        list.add(new int[] {start, end});
        return list.toArray(int[][]::new);
    }
}
