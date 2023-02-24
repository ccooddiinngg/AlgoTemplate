package AC3.A1;

import java.util.Arrays;
import java.util.Scanner;

public class A1010 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        int[] nums = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            nums[i] = Integer.parseInt(s[i]);
        }
        int max = getMax(nums, nums.length);
        int count = getCount(nums, nums.length);
        System.out.println(max);
        System.out.println(count);
    }

    static int getMax(int[] nums, int n) {
        int[] dp = new int[n + 2];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = Integer.MIN_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            int idx = findGreater(dp, nums[i]);
            dp[idx] = nums[i];
        }
        int max = findEqualAndGreater(dp, Integer.MAX_VALUE);
        return max - 1;
    }

    private static int findGreater(int[] dp, int num) {
        int i = 0;
        int j = dp.length - 1;
        while (i < j) {
            int mid = i + (j - i) / 2;
            if (dp[mid] > num) {
                j = mid;
            } else {
                i = mid + 1;
            }
        }
        return i;
    }

    private static int findEqualAndGreater(int[] dp, int num) {
        int i = 0;
        int j = dp.length - 1;
        while (i < j) {
            int mid = i + (j - i) / 2;
            if (dp[mid] >= num) {
                j = mid;
            } else {
                i = mid + 1;
            }
        }
        return i;
    }

    static int getCount(int[] nums, int n) {
        int[] count = new int[n];
        int end = 0;
        for (int i = 0; i < n; i++) {
            int j = 0;
            while (j < end && count[j] < nums[i]) {
                j++;
            }
            count[j] = nums[i];
            if (j == end) {
                end++;
            }
        }
        return end;
    }

}
