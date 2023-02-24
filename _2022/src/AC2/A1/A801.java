package AC2.A1;

import java.util.Scanner;

public class A801 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            System.out.print(lowBit(num) + " ");
        }

    }

    //Method I
    static int count(int n) {
        if (n == 0) return 0;
        return (n & 1) == 1 ? 1 + count(n >> 1) : count(n >> 1);
    }

    //Method II
    static int lowBit(int n) {
        int count = 0;
        while (n != 0) {
            n -= (n & -n);
            count++;
        }
        return count;
    }
}

