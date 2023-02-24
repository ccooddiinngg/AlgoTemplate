package Leetcode.Coding_Interview_6.C17;

public class S10 {
    public int majorityElement(int[] nums) {
        int t = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                t = nums[i];
                count = 1;
            } else {
                if (nums[i] == t) {
                    count++;
                } else {
                    count--;
                }
            }
        }
        //need count candidate to see if it's main num
        count = 0;
        for (int num : nums) {
            if (num == t) count++;
        }
        return count > nums.length / 2 ? t : -1;
    }
}
