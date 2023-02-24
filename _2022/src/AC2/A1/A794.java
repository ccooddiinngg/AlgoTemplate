package AC2.A1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class A794 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        int[] a = new int[s1.length()];
        for (int i = 0; i < a.length; i++) {
            a[i] = Integer.parseInt(String.valueOf(s1.charAt(i)));
        }
        int b = Integer.parseInt(s2);
        List<Integer> res = divide(a, b);

        while (res.size() > 2 && res.get(0) == 0) {
            res.remove(0);
        }
        for (int i = 0; i < res.size() - 1; i++) {
            System.out.print(res.get(i));
        }

        System.out.println();
        System.out.print(res.get(res.size() - 1));
    }

    static List<Integer> divide(int[] a, int b) {
        List<Integer> res = new ArrayList<>();
        int remainder = 0;
        for (int i = 0; i < a.length; i++) {
            int v = a[i] + remainder * 10;
            res.add(v / b);
            remainder = v % b;
        }
        res.add(remainder);
        return res;
    }
}
