package AC2.A1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class A792 {
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
        boolean isNegative = false;
        if (a.length < b.length) {
            isNegative = true;
        }
        if (a.length == b.length) {
            for (int i = a.length - 1; i >= 0; i--) {
                if (a[i] > b[i]) break;
                if (a[i] < b[i]) {
                    isNegative = true;
                    break;
                }
            }
        }
        List<Integer> c = null;
        if (isNegative) {
            c = subtract(b, a);
        } else {
            c = subtract(a, b);
        }
        if (isNegative) {
            System.out.print("-");
        }

        while (c.size() > 1 && c.get(c.size() - 1) == 0) {
            c.remove(c.size() - 1);
        }
        for (int i = c.size() - 1; i >= 0; i--) {
            System.out.print(c.get(i));
        }
    }

    static List<Integer> subtract(int[] a, int[] b) {
        int carry = 0;
        List<Integer> c = new ArrayList<>();
        int i = 0;
        while (i < a.length) {
            int va = a[i] - carry;
            int vb = i < b.length ? b[i] : 0;
            if (va < vb) {
                carry = 1;
                va += 10;
            } else {
                carry = 0;
            }
            c.add(va - vb);
            i++;
        }
        return c;
    }
}
