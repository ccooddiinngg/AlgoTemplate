package AC2.A6;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class A148 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int min = getMin(nums, n);
        System.out.println(min);
    }

    static int getMin(int[] nums, int n) {
        Queue<Integer> q = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            q.add(nums[i]);
        }
        int res = 0;
        while (q.size() > 1) {
            int t = q.poll() + q.poll();
            res += t;
            q.add(t);
        }
        return res;
    }
}
