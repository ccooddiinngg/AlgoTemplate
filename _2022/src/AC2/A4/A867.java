package AC2.A4;

import java.util.Scanner;

public class A867 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            primeFactor(num);
            System.out.println();
        }
    }

    private static void primeFactor(int num) {
//        只找小于sqrt(n)质因子 i <= num / i
        for (int i = 2; i <= num / i; i++) {
            if (num % i == 0) {
                int count = 0;
                while (num % i == 0) {
                    count++;
                    num /= i;
                }
                System.out.println(i + " " + count);
            }
        }
//        n中最多只含有一个大于sqrt(n)的因子：如果有两个大于sqrt(n)的因子，那么相乘会大于n
        if (num > 1) {
            System.out.println(num + " " + 1);
        }
    }
}
