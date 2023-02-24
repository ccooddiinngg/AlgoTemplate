package Leetcode.ACW_LeetCode;

public class LC67 {
    public String addBinary(String a, String b) {
        int m = a.length();
        int n = b.length();
        int i1 = m - 1;
        int i2 = n - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (i1 >= 0 || i2 >= 0) {
            int n1 = i1 >= 0 ? a.charAt(i1) - '0':0;
            int n2 = i2 >= 0 ? b.charAt(i2) - '0':0;
            int num = n1 + n2 + carry;
            sb.insert(0, num % 2);
            carry = num / 2;
            i1--;
            i2--;
        }
        if (carry > 0) sb.insert(0, carry);
        return sb.toString();
    }
}
