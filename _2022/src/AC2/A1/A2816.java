package AC2.A1;

import java.util.Scanner;

public class A2816 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] nums1 = new int[n];
        int[] nums2 = new int[m];
        for (int i = 0; i < n; i++) {
            nums1[i] = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            nums2[i] = sc.nextInt();
        }
        if (find(nums1, nums2)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    static boolean find(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                i++;
            }
            j++;
        }
        return i == nums1.length;
    }
}

