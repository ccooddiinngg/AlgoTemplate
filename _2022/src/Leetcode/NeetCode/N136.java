package Leetcode.NeetCode;

//@@ XOR
public class N136 {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res = num ^ res;
        }
        return res;
    }
}
