package Leetcode.ACW_LeetCode;

import java.util.ArrayList;
import java.util.List;

public class LC66 {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        List<Integer> list = new ArrayList<>();
        int carry = 0;
        for (int i = n - 1; i >= 0; i--) {
            int a = digits[i];
            int b = i == n - 1 ? 1:0;
            int c = a + b + carry;
            list.add(0, c % 10);
            carry = c / 10;
        }
        if (carry > 0) list.add(0, carry);
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
