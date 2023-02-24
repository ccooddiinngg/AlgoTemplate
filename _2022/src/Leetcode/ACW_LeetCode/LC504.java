package Leetcode.ACW_LeetCode;

public class LC504 {
    public String convertToBase7(int num) {
        StringBuilder sb = new StringBuilder();
        if (num == 0) return "0";
        String sign = num >= 0 ? "" : "-";
        int n = Math.abs(num);
        while (n > 0) {
            sb.insert(0, n % 7);
            n /= 7;
        }
        sb.insert(0, sign);
        return sb.toString();
    }
}
