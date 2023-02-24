package Leetcode.ACW_LeetCode;

public class LC458 {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int states = minutesToTest / minutesToDie + 1;
        int count = 0;
        while (Math.pow(states, count) < buckets) {
            count++;
        }
        return count;
    }
}
