package Leetcode.MostLiked100;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> list = new LinkedList<>();
        int i = 0;
        while (i <= intervals.length - 1) {
            int[] temp = new int[2];
            temp[0] = intervals[i][0];
            temp[1] = intervals[i][1];

            while (i <= intervals.length - 2 && temp[1] >= intervals[i + 1][0]) {
                temp[1] = Math.max(temp[1], intervals[i + 1][1]);
                i++;
            }

            list.add(temp);
            i++;
        }

        return list.toArray(new int[list.size()][]);
    }

    @Test
    void test() {
        int[][] intervals = {{1, 4}, {0, 2}, {3, 5}};

        System.out.println(Arrays.deepToString(merge(intervals)));
    }
}
