package AC2.A4;

import java.util.Scanner;

public class A868 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = count(n);
        System.out.println(count);
    }

    static int count(int n) {
        boolean[] notPrime = new boolean[n + 1];
        int count = 0;
        for (int i = 2; i < n + 1; i++) {
            if (!notPrime[i]) {
                count++;
                for (int j = i + i; j < n + 1; j += i) {
                    notPrime[j] = true;
                }
            }
        }
        return count;
    }
}
