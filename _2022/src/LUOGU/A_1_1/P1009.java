package LUOGU.A_1_1;

import java.util.Scanner;

public class P1009 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String t = "1";
        String c = "1";
        for (int i = 2; i <= n; i++) {
            t = muti(t, i);
            c = add(c, t);
        }
        System.out.println(c);
    }

    private static String add(String x, String y) {
        StringBuilder sb = new StringBuilder();
        int m = x.length();
        int n = y.length();
        int carry = 0;
        int i = m - 1;
        int j = n - 1;
        while (i >= 0 || j >= 0 || carry > 0) {
            int a = i >= 0 ? x.charAt(i) - '0' : 0;
            int b = j >= 0 ? y.charAt(j) - '0' : 0;
            int sum = a + b + carry;
            sb.insert(0, sum % 10);
            carry = sum / 10;
            i--;
            j--;
        }
        return sb.toString();
    }

    private static String muti(String x, int y) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int i = x.length() - 1; i >= 0; i--) {
            int a = x.charAt(i) - '0';
            int sum = a * y + carry;
            sb.insert(0, sum % 10);
            carry = sum / 10;
        }
        if (carry > 0) {
            sb.insert(0, carry);
        }
        return sb.toString();
    }
}
