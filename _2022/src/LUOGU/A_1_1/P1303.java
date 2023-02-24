package LUOGU.A_1_1;

import java.util.Scanner;

public class P1303 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        if (a.equals("0") || b.equals("0")) {
            System.out.println("0");
            return;
        }
        String c = multiply(a, b);
        System.out.println(c);
    }

    private static String multiply(String a, String b) {
        StringBuilder c = new StringBuilder();
        for (int i = b.length() - 1; i >= 0; i--) {
            StringBuilder t = multi(a, b.charAt(i) - '0');
            for (int j = 0; j < b.length() - 1 - i; j++) {
                t.append("0");
            }
            c = add(t, c);
        }
        return c.toString();
    }

    private static StringBuilder add(StringBuilder x, StringBuilder y) {
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
        return sb;
    }

    private static StringBuilder multi(String s, int b) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            int a = s.charAt(i) - '0';
            int sum = a * b + carry;
            sb.insert(0, sum % 10);
            carry = sum / 10;
        }
        if (carry > 0) {
            sb.insert(0, carry);
        }
        return sb;
    }
}
