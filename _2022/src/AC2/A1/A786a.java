package AC2.A1;

import java.util.Scanner;

public class A786a {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int K = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int res = kthNumber(nums, K - 1);
        System.out.print(res);
    }

    static int kthNumber(int[] nums, int k) {
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int[] p = partition(nums, l, r);
            if (p[0] == k) {
                return nums[p[0]];
            } else if (p[0] > k) {
                r = p[0] - 1;
            } else {
                l = p[0] + 1;
            }
        }
        return -1;
    }

    static int[] partition(int[] nums, int l, int r) {
        int mid = nums[l + r >> 1];
        int i = l;
        int j = r;
        int p = l;
        while (p <= j) {
            if (nums[p] < mid) {
                swap(nums, p, i);
                i++;
                p++;
            } else if (nums[p] == mid) {
                p++;
            } else {
                swap(nums, p, j);
                j--;
            }
        }
        return new int[]{i, j};
    }

    static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
