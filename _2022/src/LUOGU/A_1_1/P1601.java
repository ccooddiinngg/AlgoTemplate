package LUOGU.A_1_1;

import java.util.Scanner;

public class P1601 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        String c = add(a, b);
        System.out.println(c);
    }

    public static String add(String x, String y) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int m = x.length();
        int n = y.length();
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
}
