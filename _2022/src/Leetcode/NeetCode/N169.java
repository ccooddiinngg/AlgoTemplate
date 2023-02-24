package Leetcode.NeetCode;

//@@ vote
public class N169 {
    public int majorityElement(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int maj = 0;
        int count = 0;
        for (int num : nums) {
            if (count == 0) {
                maj = num;
            }
            if (num != maj) {
                count--;
            } else {
                count++;
            }
        }
        return maj;
    }
}
