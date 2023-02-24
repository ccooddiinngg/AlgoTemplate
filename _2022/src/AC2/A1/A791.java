package AC2.A1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class A791 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        int[] a = new int[s1.length()];
        int[] b = new int[s2.length()];
        for (int i = s1.length() - 1, j = 0; i >= 0; i--, j++) {
            a[j] = Integer.parseInt(String.valueOf(s1.charAt(i)));
        }
        for (int i = s2.length() - 1, j = 0; i >= 0; i--, j++) {
            b[j] = Integer.parseInt(String.valueOf(s2.charAt(i)));
        }
        List<Integer> c = add(a, b);
        for (int i = c.size() - 1; i >= 0; i--) {
            System.out.print(c.get(i));
        }
    }

    static List<Integer> add(int[] a, int[] b) {
        int carry = 0;
        List<Integer> c = new ArrayList<>();
        int i = 0;
        while (i < a.length || i < b.length) {
            carry += i < a.length ? a[i] : 0;
            carry += i < b.length ? b[i] : 0;
            c.add(carry % 10);
            carry /= 10;
            i++;
        }
        if (carry != 0) {
            c.add(carry);
        }
        return c;
    }
}
