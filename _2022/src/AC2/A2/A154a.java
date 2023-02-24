package AC2.A2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;

public class A154a {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = reader.readLine().split(" ");
        int n = Integer.parseInt(temp[0]);
        int k = Integer.parseInt(temp[1]);

        temp = reader.readLine().split(" ");

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(temp[i]);
        }
        find(nums, k, (a, b) -> b - a);
        System.out.println();
        find(nums, k, (a, b) -> a - b);
    }


    static void find(int[] nums, int k, Comparator<Integer> comp) {
        int n = nums.length;
        LinkedList<Integer> q = new LinkedList<>();
        for (int i = 0, l = -1, r = 0; r < n; r++) {
            while (!q.isEmpty() && comp.compare(nums[q.peekLast()], nums[r]) <= 0) {
                q.pollLast();
            }
            q.addLast(r);
            if (r >= k) {
                l++;
                if (q.peekFirst() == l) {
                    q.poll();
                }
            }
            if (r >= k - 1) {
                System.out.print(nums[q.peekFirst()] + " ");
            }
        }
    }
}
