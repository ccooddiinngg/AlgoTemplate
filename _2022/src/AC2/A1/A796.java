package AC2.A1;

import java.util.Scanner;

public class A796 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int q = sc.nextInt();
        int[][] nums = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                nums[i][j] = sc.nextInt();
            }
        }

        int[][] pre = preSum(nums);
        // for (int[] row: pre) {
        //     System.out.println(Arrays.toString(row));
        // }
        for (int i = 0; i < q; i++) {
            int i1 = sc.nextInt();
            int j1 = sc.nextInt();
            int i2 = sc.nextInt();
            int j2 = sc.nextInt();
            int res = f(pre, i1, j1, i2, j2);
            System.out.println(res);
        }
    }

    static int[][] preSum(int[][] nums) {
        int[][] pre = new int[nums.length + 1][nums[0].length + 1];
        for (int i = 1; i < pre.length; i++) {
            for (int j = 1; j < pre[0].length; j++) {
                pre[i][j] = pre[i][j - 1] + nums[i - 1][j - 1];
            }
            for (int j = 1; j < pre[0].length; j++) {
                pre[i][j] += pre[i - 1][j];
            }
        }
        return pre;
    }

    static int f(int[][] pre, int i1, int j1, int i2, int j2) {
        return pre[i2][j2] - pre[i2][j1 - 1] - pre[i1 - 1][j2] + pre[i1 - 1][j1 - 1];
    }
}
