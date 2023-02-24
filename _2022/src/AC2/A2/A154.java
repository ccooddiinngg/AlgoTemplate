package AC2.A2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A154 {

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
        slider(nums, k);
    }

    static void slider(int[] nums, int k) {
        int[] q = new int[nums.length];
        int head = 0;
        int tail = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i - k + 1 > q[head]) {
                head++;
            }
            while (tail > head && nums[q[tail - 1]] >= nums[i]) {
                tail--;
            }
            q[tail++] = i;
            if (i >= k - 1) {
                System.out.print(nums[q[head]] + " ");
            }
        }
        System.out.println();
        q = new int[nums.length];
        head = 0;
        tail = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i - k + 1 > q[head]) {
                head++;
            }
            while (tail > head && nums[q[tail - 1]] <= nums[i]) {
                tail--;
            }
            q[tail++] = i;
            if (i >= k - 1) {
                System.out.print(nums[q[head]] + " ");
            }
        }
    }
}
