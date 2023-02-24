package AC2.A6;

import java.util.Arrays;
import java.util.Scanner;

public class A104 {
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

    //选中间那个位置， 偶数任选中间两个之一
    static int getMin(int[] nums, int n) {
        Arrays.sort(nums);
        int res = 0;
        int idx = n / 2;
        for (int i = 0; i < n; i++) {
            res += Math.abs(nums[i] - nums[idx]);
        }
        return res;
    }
}
