package AC2.A1;

import java.util.Scanner;

public class A795 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int[] pre = preSum(nums);
        for (int i = 0; i < q; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            System.out.println(pre[r] - pre[l - 1]);
        }
    }

    static int[] preSum(int[] nums) {
        int[] pre = new int[nums.length + 1];
        for (int i = 1; i < pre.length; i++) {
            pre[i] = pre[i - 1] + nums[i - 1];
        }
        return pre;
    }
}
