package AC2.A4;

import java.util.Scanner;

public class A872 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int res = find(a, b);
            System.out.println(res);
        }
    }

    private static int find(int a, int b) {
        if (b == 0) {
            return a;
        }
        return find(b, a % b);
    }
}
