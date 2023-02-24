package AC2.A6;

import java.util.Arrays;
import java.util.Scanner;

public class A913 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        long min = getMin(nums, n);
        System.out.println(min);

    }

    static long getMin(int[] nums, int n) {
        Arrays.sort(nums);
        long res = 0;
        for (int i = 0; i < n; i++) {
            res += (long) nums[i] * (n - 1 - i);
        }
        return res;
    }
}
