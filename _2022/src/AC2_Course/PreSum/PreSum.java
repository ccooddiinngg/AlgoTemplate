package AC2_Course.PreSum;

public class PreSum {

    //前缀和
    public static void preSum() {
        int n = 10;
        int[][] q = {{2, 8}, {1, 8}, {1, 7}, {3, 10}, {2, 7}};
        int[] nums = {-91, 996, 930, 915, -566, -366, -972, 566, -81, -748};

        int[] preSum = new int[nums.length + 1];
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }

        for (int i = 0; i < q.length; i++) {
            int l = q[i][0];
            int r = q[i][1];
            int res = preSum[r] - preSum[l - 1];
            System.out.println(res);
        }
    }

//输出：
//1503
//1412
//846
//-322
//937


    //差分
    public static void difference() {
        int n = 6;
        int[] nums = {1, 2, 2, 1, 2, 1};
        int[][] q = new int[][]{{1, 3, 1}, {3, 5, 1}, {1, 6, 1}};
        int[] origin = new int[n];
        origin[0] = nums[0];
        for (int i = 1; i < n; i++) {
            origin[i] = nums[i] - nums[i - 1];
        }

        for (int i = 0; i < q.length; i++) {
            int l = q[i][0];
            int r = q[i][1];
            int v = q[i][2];
            origin[l - 1] += v;
            if (r < n) {
                origin[r] -= v;
            }
        }

        nums[0] = origin[0];
        System.out.print(nums[0] + " ");
        for (int i = 1; i < n; i++) {
            nums[i] = nums[i - 1] + origin[i];
            System.out.print(nums[i] + " ");
        }

    }

//输出
//3 4 5 3 4 2

    public static void main(String[] args) {
        preSum();
        difference();
    }
}
