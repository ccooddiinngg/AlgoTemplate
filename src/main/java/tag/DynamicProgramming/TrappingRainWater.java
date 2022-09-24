package tag.DynamicProgramming;

public class TrappingRainWater {
    public int trap(int[] height) {
        int m = height.length;
        int[] left = new int[m];
        left[0] = height[0];
        for (int i = 1; i < m; i++) {
            left[i] = Math.max(left[i - 1], height[i - 1]);
        }
        int[] right = new int[m];
        right[m - 1] = height[m - 1];
        for (int i = m - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], height[i + 1]);
        }
        int sum = 0;
        for (int i = 0; i < m; i++) {
            sum += Math.max((Math.min(left[i], right[i]) - height[i]), 0);
        }
        return sum;
    }
}
