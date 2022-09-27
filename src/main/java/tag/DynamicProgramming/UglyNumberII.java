package tag.DynamicProgramming;

public class UglyNumberII {
    public int nthUglyNumber(int n) {
        int i2 = 0;
        int i3 = 0;
        int i5 = 0;
        int[] nums = new int[n];
        nums[0] = 1;
        for (int i = 1; i < n; i++) {
            int u2 = 2 * nums[i2];
            int u3 = 3 * nums[i3];
            int u5 = 5 * nums[i5];
            int min = Math.min(u2, Math.min(u3, u5));
            if (min == u2) i2++;
            if (min == u3) i3++;
            if (min == u5) i5++;
            nums[i] = min;
        }
        return nums[n - 1];
    }
}
