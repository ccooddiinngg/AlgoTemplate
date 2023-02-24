package Leetcode.NeetCode;

import java.util.Arrays;

public class N853 {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] map = new int[position.length][2];

        for (int i = 0; i < map.length; i++) {
            map[i][0] = position[i];
            map[i][1] = speed[i];
        }

        Arrays.sort(map, (a, b) -> a[0] - b[0]);

        int m = map.length;

        double[] time = new double[m];
        for (int i = 0; i < m; i++) {
            time[i] = (double) (target - map[i][0]) / (double) map[i][1];
        }

        double curr = 0;
        int count = 0;
        for (int i = m - 1; i >= 0; i--) {
            if (time[i] > curr) {
                curr = time[i];
                count++;
            }
        }
        return count;
    }
}
