package AC2_Course.Knapsack;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class K04 {
    public int maxValue1D(int[] v, int[] w, int[] s, int V) {
        List<List<Integer>> list = getAmount(s);
        int[] dp = new int[V + 1];
        for (int i = v.length - 1; i >= 0; i--) {
            List<Integer> q = list.get(i);
            for (int k = 0; k < q.size(); k++) {
                for (int j = dp.length - 1; j >= 0; j--) {
                    if (q.get(k) * v[i] <= j) {
                        dp[j] = Math.max(dp[j], dp[j - q.get(k) * v[i]] + q.get(k) * w[i]);
                    }
                }
            }
        }
        return dp[V];
    }

    public List<List<Integer>> getAmount(int[] nums) {
        List<List<Integer>> res = new ArrayList<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            List<Integer> list = new ArrayList<>();
            int num = nums[i];
            //@@ get all possible sub numbers (1, 2, 4, 8, ...num)
            //@@ the sum of all subs must <= num
            for (int j = 1; j <= num; j *= 2) {
                num -= j;
                list.add(j);
            }
            if (num > 0) {
                list.add(num);
            }
            res.add(list);
        }
        System.out.println(res);
        return res;
    }

    @Test
    void test() {
        int[] v = {1, 2, 3, 4};
        int[] w = {2, 4, 4, 5};
        int[] s = {3, 1, 3, 2};
        int V = 5;

        System.out.println(maxValue1D(v, w, s, V));
    }
}
