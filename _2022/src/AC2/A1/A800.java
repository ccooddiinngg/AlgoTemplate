package AC2.A1;

import java.util.Scanner;

public class A800 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int t = sc.nextInt();
        int[] nums1 = new int[n];
        int[] nums2 = new int[m];
        for (int i = 0; i < n; i++) {
            nums1[i] = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            nums2[i] = sc.nextInt();
        }
        int[] res = find(nums1, nums2, t);
        System.out.print(res[0] + " " + res[1]);
    }

    static int[] find(int[] nums1, int[] nums2, int t) {
        int i = 0;
        int j = nums2.length - 1;
        while (i < nums1.length && j >= 0) {
            if (nums1[i] + nums2[j] < t) {
                i++;
            } else if (nums1[i] + nums2[j] > t) {
                j--;
            } else {
                return new int[]{i, j};
            }
        }
        return new int[]{-1, -1};
    }
}

