package Leetcode.Offer;

public class O61 {
    public boolean isStraight(int[] nums) {
        boolean[] p = new boolean[14];
        int max = 0;
        int min = 14;
        for (int num : nums) {
            if (num != 0) {
                if (p[num]) return false;
                p[num] = true;
                max = Math.max(max, num);
                min = Math.min(min, num);
            }
        }
        return (max - min <= 4);
    }
}
