package AC2.A1;

import java.util.Scanner;

public class A797 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int[] pre = preDiff(nums);

        for (int i = 0; i < q; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            int v = sc.nextInt();
            pre[l - 1] += v;
            if (r < pre.length) {
                pre[r] -= v;
            }
        }
        int[] res = preSum(pre);
        for (int num : res) {
            System.out.print(num + " ");
        }
    }

    static int[] preDiff(int[] nums) {
        int[] pre = new int[nums.length];
        pre[0] = nums[0];
        for (int i = 1; i < pre.length; i++) {
            pre[i] = nums[i] - nums[i - 1];
        }
        return pre;
    }

    static int[] preSum(int[] nums) {
        int[] pre = new int[nums.length];
        pre[0] = nums[0];
        for (int i = 1; i < pre.length; i++) {
            pre[i] = pre[i - 1] + nums[i];
        }
        return pre;
    }
}
