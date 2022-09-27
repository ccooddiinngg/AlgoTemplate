package tag.DynamicProgramming;

import java.util.Deque;
import java.util.LinkedList;

public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;
        int[] h = new int[n];
        for (int j = 0; j < n; j++) {
            h[j] = matrix[0][j] == '1' ? 1 : 0;
        }
        max = Math.max(max, getMax(h));
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                h[j] = matrix[i][j] == '1' ? 1 + h[j] : 0;
            }
            max = Math.max(max, getMax(h));
        }
        return max;
    }

    //histogram
    int getMax(int[] h) {
        int m = h.length;
        Deque<Integer> q = new LinkedList<>();
        int[][] bound = new int[m][2];
        for (int i = 0; i < m; i++) {
            while (!q.isEmpty() && h[q.peek()] > h[i]) {
                int idx = q.pop();
                bound[idx][0] = q.isEmpty() ? 0 : q.peek() + 1;
                bound[idx][1] = i - 1;
            }
            q.push(i);
        }
        while (!q.isEmpty()) {
            int idx = q.pop();
            bound[idx][0] = q.isEmpty() ? 0 : q.peek() + 1;
            bound[idx][1] = m - 1;
        }
        int max = 0;
        for (int i = 0; i < m; i++) {
            max = Math.max(max, (bound[i][1] + 1 - bound[i][0]) * h[i]);
        }
        return max;
    }
}
