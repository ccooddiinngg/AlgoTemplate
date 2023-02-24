package AC2_Course.StackAndQueue;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Random;

//USING array as queue
public class SlidingWindow {
    Random r = new Random();
    int[] nums = r.ints(300000, -9999, 9999).toArray();
    int k = 3;

    @Test
    void test1() {
        useArrayQueue(nums, k);
    }

    @Test
    void test2() {
        useLinkedList(nums, k);
    }

    public static void useLinkedList(int[] nums, int k) {
        int n = nums.length;

        LinkedList<Integer> q = new LinkedList<>();
        int j = -1;
        for (int i = 0; i <= n - k; i++) {
            if (!q.isEmpty() && q.peekFirst() == i - 1) {
                q.pollFirst();
            }
            while (j - i < k - 1) {
                j++;
                while (!q.isEmpty() && nums[q.peekLast()] >= nums[j]) {
                    q.pollLast();
                }
                q.add(j);
            }
//            System.out.print(nums[q.peek()] + " ");
        }
        System.out.println();
        q.clear();
        j = -1;
        for (int i = 0; i <= n - k; i++) {
            if (!q.isEmpty() && q.peekFirst() == i - 1) {
                q.pollFirst();
            }
            while (j - i < k - 1) {
                j++;
                while (!q.isEmpty() && nums[q.peekLast()] <= nums[j]) {
                    q.pollLast();
                }
                q.add(j);
            }
//            System.out.print(nums[q.peek()] + " ");
        }
    }

    public static void useArrayQueue(int[] nums, int k) {
        int n = nums.length;
        int[] q = new int[n];
        int head = 0;
        int tail = -1;

        for (int i = 0; i < n; i++) {
            if (head <= tail && i - k + 1 > q[head]) {
                head++;
            }
            while (head <= tail && nums[i] <= nums[q[tail]]) {
                tail--;
            }
            tail++;
            q[tail] = i;
            if (i >= k - 1) {
//                System.out.print(nums[q[head]] + " ");
            }
        }
        System.out.println();
        head = 0;
        tail = -1;

        for (int i = 0; i < n; i++) {
            if (head <= tail && i - k + 1 > q[head]) {
                head++;
            }
            while (head <= tail && nums[i] >= nums[q[tail]]) {
                tail--;
            }
            tail++;
            q[tail] = i;
            if (i >= k - 1) {
//                System.out.print(nums[q[head]] + " ");
            }
        }
    }
}
