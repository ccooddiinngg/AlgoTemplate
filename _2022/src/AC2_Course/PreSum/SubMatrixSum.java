package AC2_Course.PreSum;

public class SubMatrixSum {
    public static int[][] getPre(int[][] nums) {
        int[][] pre = new int[nums.length][nums[0].length];

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                if (j == 0) {
                    pre[i][j] = nums[i][j];
                } else {
                    pre[i][j] = pre[i][j - 1] + nums[i][j];
                }
            }
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                pre[i][j] = pre[i - 1][j] + pre[i][j];
            }
        }
        return pre;
    }

    public static int find(int[][] pre, int i1, int j1, int i2, int j2) {
        return pre[i2][j2] - (j1 > 0 ? pre[i2][j1 - 1] : 0) - (i1 > 0 ? pre[i1 - 1][j2] : 0) + (i1 > 0 && j1 > 0 ? pre[i1 - 1][j1 - 1] : 0);
    }
}
