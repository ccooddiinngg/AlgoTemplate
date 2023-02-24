package ZuoChengyun.Middle.Day1;

import ZuoChengyun.BasicPlus.Day2.AMonotonicQueue;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

public class Rope {
    public static int find(int[] arr, int L) {
        LinkedList<Integer> q = new LinkedList<>();
        int i = 0;
        int max = 0;
        while (i < arr.length) {
            if (q.isEmpty() || arr[i] - q.peekFirst() <= L) {
                q.addLast(arr[i++]);
                max = Math.max(max, q.size());
            } else {
                q.pollFirst();
            }
        }
        return max;
    }

    @Test
    void test() {
        int[] arr = {1, 2, 3, 4, 5, 7, 9};
        System.out.println(find(arr, 4));
    }
}
