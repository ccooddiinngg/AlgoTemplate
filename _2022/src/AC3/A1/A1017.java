package AC3.A1;

import java.util.Arrays;
import java.util.Scanner;

public class A1017 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int m = sc.nextInt();
            int[] nums = new int[m];
            int[] rnums = new int[m];
            for (int j = 0; j < m; j++) {
                int num = sc.nextInt();
                nums[j] = num;
                rnums[m - 1 - j] = num;
            }
            int max = getMax(nums, m);
            int rmax = getMax(rnums, m);

            max = Math.max(max, rmax);
            System.out.println(max);
        }
    }

    private static int getMax(int[] nums, int m) {
        int[] len = new int[m + 2];
        Arrays.fill(len, Integer.MAX_VALUE);
        len[0] = Integer.MIN_VALUE;

        for (int i = 0; i < m; i++) {
            int idx = find(len, nums[i]);
            len[idx] = nums[i];
        }
        for (int i = 1; i < len.length; i++) {
            if (len[i] == Integer.MAX_VALUE) {
                return i - 1;
            }
        }
        return -1;
    }

    private static int find(int[] len, int num) {
        int i = 0;
        int j = len.length - 1;
        while (i < j) {
            int mid = i + (j - i) / 2;
            if (len[mid] < num) {
                i = mid + 1;
            } else {
                j = mid;
            }
        }
        return i;
    }
}
