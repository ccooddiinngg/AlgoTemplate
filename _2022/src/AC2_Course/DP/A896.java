package AC2_Course.DP;

import java.util.Arrays;
import java.util.Scanner;

//7
//3 1 2 1 8 5 6
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int i = 0; i < n; i++) {
            int idx = indexOf(dp, nums[i]);
            dp[idx] = nums[i];
        }
        int max = indexOf(dp, Integer.MAX_VALUE);

        System.out.println(max);
    }

    //find the index of a num >= t
    static int indexOf(int[] dp, int t) {
        int i = 0;
        int j = dp.length;
        while (i < j) {
            int mid = i + j >> 1;
            if (dp[mid] >= t) {
                j = mid;
            } else {
                i = mid + 1;
            }
        }
        return i;
    }
}
