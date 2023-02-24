package ZuoChengyun.BasicPlus.Day2;

import java.util.Comparator;
import java.util.LinkedList;

public class AMonotonicQueue {
    public int left = -1;
    public int right = 0;
    public LinkedList<Integer> q = new LinkedList<>();
    public int[] array;
    public Comparator<Integer> comparator;

    public AMonotonicQueue(int[] array, Comparator<Integer> comparator) {
        this.array = array;
        this.comparator = comparator;
    }

    public void rightIncrease() {
        if (right >= array.length) return;
        while (!q.isEmpty() && comparator.compare(array[q.peekLast()], array[right]) <= 0) {
            q.pollLast();
        }
        q.addLast(right);
        right++;
    }

    public void leftIncrease() {
        if (left >= right - 1) {
            return;
        }
        left++;
        if (!q.isEmpty() && q.peekFirst() == left) {
            q.pollFirst();
        }
    }

    public Integer peek() {
        if (!q.isEmpty()) {
            return array[q.peekFirst()];
        }
        return null;
    }
}
