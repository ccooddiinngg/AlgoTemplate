package Leetcode.ACW_LeetCode;

import java.util.ArrayList;
import java.util.List;

public class LC228 {
    public List<String> summaryRanges(int[] nums) {

        List<String> list = new ArrayList<>();
        if (nums.length == 0) return list;
        if (nums.length == 1) {
            list.add(String.valueOf(nums[0]));
            return list;
        }
        int start = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1] + 1) {
                if (i - 1 != start) {
                    sb.append(nums[start]).append("->").append(nums[i - 1]);
                } else {
                    sb.append(nums[i - 1]);
                }
                list.add(sb.toString());
                start = i;
                sb = new StringBuilder();
            }
            if (i == nums.length - 1) {
                if (i != start) {
                    sb.append(nums[start]).append("->").append(nums[i]);
                } else {
                    sb.append(nums[i]);
                }
            }
        }
        list.add(sb.toString());
        return list;
    }
}
