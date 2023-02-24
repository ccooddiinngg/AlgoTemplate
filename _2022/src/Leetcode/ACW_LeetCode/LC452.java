package Leetcode.ACW_LeetCode;

import java.util.Arrays;

public class LC452 {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> a[0] < b[0] ? -1 : 1);
        int end = points[0][1];
        int count = 1;
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > end) {
                count++;
                end = points[i][1];
            } else {
                end = Math.min(end, points[i][1]);
            }
        }
        return count;
    }
}
