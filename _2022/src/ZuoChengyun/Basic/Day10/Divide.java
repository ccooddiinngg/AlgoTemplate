package ZuoChengyun.Basic.Day10;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Divide {
    public static int bruteForce(Integer[] bars, int min) {
        if (bars.length == 1) {
            return min;
        }
        int m = Integer.MAX_VALUE;
        for (int i = 0; i < bars.length; i++) {
            for (int j = i + 1; j < bars.length; j++) {
                m = Math.min(m, bruteForce(copyAndMergeTwo(bars, i, j), min + bars[i] + bars[j]));
            }
        }
        return m;
    }

    private static Integer[] copyAndMergeTwo(Integer[] bars, int i, int j) {
        Integer[] copy = new Integer[bars.length - 1];
        for (int p = 0, q = 0; p < bars.length; p++) {
            if (p != i && p != j) {
                copy[q++] = bars[p];
            }
        }
        copy[copy.length - 1] = bars[i] + bars[j];
        return copy;
    }


    public static int greedyHeap(Integer[] bars) {
        Queue<Integer> q = new PriorityQueue<>();
        q.addAll(List.of(bars));
        int min = 0;
        while (q.size() > 1) {
            int sum = q.poll() + q.poll();
            min += sum;
            q.add(sum);
        }
        return min;
    }

    public static void main(String[] args) {
        Integer[] bars = {3, 21, 25, 14, 11, 23, 13, 29, 6};
        int min = bruteForce(bars, 0);
        System.out.println(min);

        int minGreedyHeap = greedyHeap(bars);
        System.out.println(minGreedyHeap);

    }
}
