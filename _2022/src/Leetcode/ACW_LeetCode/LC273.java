package Leetcode.ACW_LeetCode;

import java.util.ArrayList;
import java.util.List;

public class LC273 {
    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        List<Integer> nums = new ArrayList<>();
        while (num > 0) {
            nums.add(num % 1000);
            num /= 1000;
        }
        StringBuilder res = new StringBuilder();
        for (int i = nums.size() - 1; i >= 0; i--) {
            if (nums.get(i) != 0) {
                StringBuilder sb = new StringBuilder();
                toString(nums.get(i), sb);
                sb.append(s1000[i]).append(" ");
                res.append(sb.toString());
            }
        }
        return res.toString().trim();
    }

    void toString(int num, StringBuilder sb) {
        if (num == 0) return;

        if (num < 10) {
            sb.append(s1[num]).append(" ");
        } else if (num < 20) {
            sb.append(s10[num % 10]).append(" ");
        } else if (num < 100) {
            sb.append(s100[num / 10]).append(" ");
            toString(num % 10, sb);
        } else {
            sb.append(s1[num / 100]).append(" Hundred ");
            toString(num % 100, sb);
        }
    }

    String[] s1 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    String[] s10 = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] s100 = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    String[] s1000 = {"", "Thousand", "Million", "Billion"};
}
