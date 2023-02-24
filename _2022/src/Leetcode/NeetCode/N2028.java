package Leetcode.NeetCode;

import java.util.Arrays;

//@@ increase the res[i] to reach total
public class N2028 {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int sum = 0;
        for (int v : rolls) {
            sum += v;
        }
        int rest = (rolls.length + n) * mean - sum;

        if (rest > n * 6 || rest < n) {
            return new int[]{};
        }

        int[] res = new int[n];
        Arrays.fill(res, rest / n);
        int i = 0;
        int total = (rest / n) * n;
        while (total < rest) {
            if (res[i] == 6) {
                i++;
            } else {
                res[i]++;
                total++;
            }
        }
        return res;
    }
}
