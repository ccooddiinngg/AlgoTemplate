package AC3.A1;

import java.util.Scanner;

public class A1016 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int max = getMax(nums, n);
        System.out.println(max);
    }

    static int getMax(int[] nums, int n) {
        int[] sum = new int[n];
        sum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            int t = nums[i];
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    t = Math.max(t, sum[j] + nums[i]);
                }
            }
            sum[i] = t;
        }
        int max = 0;
        for (int v : sum) {
            max = Math.max(max, v);
        }
        return max;
    }

}
