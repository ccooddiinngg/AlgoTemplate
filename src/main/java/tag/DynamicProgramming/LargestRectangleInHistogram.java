package tag.DynamicProgramming;

import java.util.Deque;
import java.util.LinkedList;

public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        int m = heights.length;
        Deque<Integer> deque = new LinkedList<>();
        int[][] b = new int[m][2];
        for (int i = 0; i < m; i++) {
            while (!deque.isEmpty() && heights[deque.peek()] > heights[i]) {
                int idx = deque.pop();
                b[idx][0] = deque.isEmpty() ? 0 : deque.peek() + 1;
                b[idx][1] = i - 1;
            }
            deque.push(i);
        }
        while (!deque.isEmpty()) {
            int idx = deque.pop();
            b[idx][0] = deque.isEmpty() ? 0 : deque.peek() + 1;
            b[idx][1] = m - 1;
        }
        int max = 0;
        for (int i = 0; i < b.length; i++) {
            max = Math.max(max, (b[i][1] - b[i][0] + 1) * heights[i]);
        }
        return max;
    }
}
