package AC2.A1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class A793 {
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

        List<Integer> res = product(a, b);
        while (res.size() > 1 && res.get(res.size() - 1) == 0) {
            res.remove(res.size() - 1);
        }
        for (int i = res.size() - 1; i >= 0; i--) {
            System.out.print(res.get(i));
        }
    }

    static List<Integer> product(int[] a, int[] b) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < b.length; i++) {
            List<Integer> p = product(a, b[i]);
            for (int k = 0; k < i; k++) {
                p.add(0, 0);
            }
            res = add(res, p);
        }
        return res;
    }

    static List<Integer> product(int[] a, int b) {
        List<Integer> res = new ArrayList<>();
        int carry = 0;
        for (int i = 0; i < a.length; i++) {
            int v = a[i] * b + carry;
            res.add(v % 10);
            carry = v / 10;
        }
        if (carry != 0) {
            res.add(carry);
        }
        return res;
    }

    static List<Integer> add(List<Integer> a, List<Integer> b) {
        List<Integer> res = new ArrayList<>();
        int i = 0;
        int carry = 0;
        while (i < a.size() || i < b.size()) {
            int va = i < a.size() ? a.get(i) : 0;
            int vb = i < b.size() ? b.get(i) : 0;
            int sum = va + vb + carry;
            res.add(sum % 10);
            carry = sum / 10;
            i++;
        }
        if (carry != 0) {
            res.add(carry);
        }
        return res;
    }
}
