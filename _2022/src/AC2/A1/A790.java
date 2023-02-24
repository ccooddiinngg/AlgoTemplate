package AC2.A1;

import java.util.Scanner;

public class A790 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double n = sc.nextDouble();
        double l = -10000;
        double r = 10000;

        while (l < r - 1e-7) {
            double mid = (l + r) / 2;
            if (mid * mid * mid > n) {
                r = mid;
            } else {
                l = mid;
            }
        }
        System.out.printf("%.6f", l);
    }
}
