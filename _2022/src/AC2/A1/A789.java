package AC2.A1;

import java.util.Scanner;

public class A789 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        for (int j = 0; j < q; j++) {
            int target = sc.nextInt();
            int l = findLeft(nums, target);
            int r = findRight(nums, target);
            System.out.print(l);
            System.out.print(" ");
            System.out.println(r);
        }
    }

    static int findLeft(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        //选靠左的点，向右推
        while (i < j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] >= target) {
                j = mid;
            } else {
                i = mid + 1;
            }
        }
        return nums[i] == target ? i : -1;
    }

    static int findRight(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        //选靠右的点，向左推
        while (i < j) {
            int mid = i + (j - i) / 2 + 1;
            if (nums[mid] <= target) {
                i = mid;
            } else {
                j = mid - 1;
            }
        }
        return nums[i] == target ? i : -1;
    }
}
