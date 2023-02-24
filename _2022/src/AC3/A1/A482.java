package AC3.A1;

import java.util.Scanner;

public class A482 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int max = getMax(nums, n);
        System.out.println(n - max);

    }

    //return max students can join the team
    static int getMax(int[] nums, int n) {
        int[] up = new int[n];
        up[0] = 1;
        for (int i = 1; i < n; i++) {
            int t = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    t = Math.max(t, up[j] + 1);
                }
            }
            up[i] = t;
        }
        int[] down = new int[n];
        down[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            int t = 1;
            for (int j = i + 1; j < n; j++) {
                if (nums[i] > nums[j]) {
                    t = Math.max(t, down[j] + 1);
                }
            }
            down[i] = t;
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, up[i] + down[i] - 1);
        }
        return max;
    }
}
