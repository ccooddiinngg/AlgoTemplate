package Leetcode.ACW_LeetCode;

public class LC134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int i = 0;
        while (i < n) {
            boolean found = true;
            int preGas = 0;
            int preCost = 0;
            for (int j = i; j < i + n; j++) {
                preGas += gas[j % n];
                preCost += cost[j % n];
                if (preGas < preCost) {
                    found = false;
                    i = j + 1;
                    break;
                }
            }
            if (found) return i;
        }
        return -1;
    }
}
