package AC3.A1;

import java.util.Scanner;

public class A187 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 0;
        while (true) {
            n = sc.nextInt();
            if (n == 0) break;
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }
            min = Integer.MAX_VALUE;
            dfs(nums, n, new int[n], new int[n], 0, 0, 0);
            System.out.println(min);
        }
    }

    static int min;

    //u: 上升子序列的个数, d: 下降子序列的个数, idx: 当前第几个数
    static void dfs(int[] nums, int n, int[] up, int[] down, int u, int d, int idx) {
        if (u + d >= min) return;
        if (idx == n) {
            min = u + d;
            return;
        }
        int pre = 0;
        int i;
        for (i = 1; i <= u; i++) {
            if (up[i] < nums[idx]) {
                break;
            }
        }
        pre = up[i];
        up[i] = nums[idx];
        dfs(nums, n, up, down, Math.max(u, i), d, idx + 1);
        up[i] = pre;

        for (i = 1; i <= d; i++) {
            if (down[i] > nums[idx]) {
                break;
            }
        }
        pre = down[i];
        down[i] = nums[idx];
        dfs(nums, n, up, down, u, Math.max(d, i), idx + 1);
        down[i] = pre;
    }
}
