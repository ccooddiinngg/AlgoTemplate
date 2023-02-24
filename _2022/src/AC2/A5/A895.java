package AC2.A5;

import java.util.Arrays;
import java.util.Scanner;

public class A895 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int max = maxLen(nums, n);
        System.out.println(max);
    }

    static int maxLen(int[] nums, int n) {
        int[] lens = new int[n + 2];
        Arrays.fill(lens, Integer.MAX_VALUE);
        lens[0] = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int j = find(lens, nums[i]);
            lens[j] = nums[i];
        }
        int max = 1;
        for (int j = 1; j < n + 2; j++) {
            if (lens[j] == Integer.MAX_VALUE) {
                max = j;
                break;
            }
        }
        return max - 1;
    }

    static int find(int[] lens, int num) {
        int i = 0;
        int j = lens.length - 1;
        while (i < j) {
            int mid = i + (j - i) / 2;
            if (lens[mid] >= num) {
                j = mid;
            } else {
                i = mid + 1;
            }
        }
        return i;
    }
}
