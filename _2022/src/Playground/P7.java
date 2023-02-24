package Playground;

public class P7 {
    public static void main(String[] args) {
        int[] nums = {1, 12, 23, 34, 45, 56};
        int num = 1000;
        int i = 0;
        int j = nums.length - 1;

        while (i < j) {
            int mid = i + (j - i) / 2 + 1;
            if (nums[mid] <= num) {
                i = mid;
            } else {
                j = mid - 1;
            }
        }
        System.out.println(i);
    }
}
