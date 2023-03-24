package Utils;

public class Utils {
    public static int[] buildRandomArray(int len) {
        int[] nums = new int[len];
        for (int i = 0; i < len; i++) {
            nums[i] = (int) (Math.random() * len) + 1;
        }
        return nums;
    }
}
