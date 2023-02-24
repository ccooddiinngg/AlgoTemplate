package ZuoChengyun.Basic.Day04;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class APriorityQueue {
    public static void main(String[] args) {
//        Queue<Integer> q = new PriorityQueue<>();
        Queue<Integer> q = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        q.add(1);
        q.add(4);
        q.add(3);
        q.add(5);
        q.add(2);

        while (!q.isEmpty()) {
            System.out.println(q.poll());
        }

        int[] array = {2, 3, 1, 5, 4};
        sortStrategy(array, 2);
        System.out.println(Arrays.toString(array));
    }

    //An unsorted array, every num is at most k distance form its sorted pos, find a sorting strategy.
    public static void sortStrategy(int[] array, int K) {
        Queue<Integer> q = new PriorityQueue<>();
        for (int i = 0; i < K + 1; i++) {
            q.add(array[i]);
        }
        int k = 0;
        for (int j = K + 1; j < array.length; j++) {
            array[k++] = q.poll();
            q.add(array[j]);
        }
        while (!q.isEmpty()) {
            array[k++] = q.poll();
        }
    }

}
