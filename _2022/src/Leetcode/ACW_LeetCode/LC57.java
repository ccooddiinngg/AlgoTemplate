package Leetcode.ACW_LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>(Arrays.asList(intervals));
        int idx = indexOf(list, newInterval[0]);
        // System.out.println(idx);
        list.add(idx, newInterval);
        int start = list.get(0)[0];
        int end = list.get(0)[1];
        List<int[]> res = new ArrayList<>();
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i)[0] <= end) {
                end = Math.max(end, list.get(i)[1]);
            }else {
                res.add(new int[] {start, end});
                start = list.get(i)[0];
                end = list.get(i)[1];
            }
        }
        res.add(new int[]{start, end});
        return res.toArray(int[][]::new);
    }

    int indexOf(List<int[]> list, int num) {
        int l = 0;
        int r = list.size();
        while (l < r) {
            int mid = l + r >> 1;
            if (list.get(mid)[0] >= num) {
                r = mid;
            }else {
                l = mid + 1;
            }
        }
        return l;
    }
}
