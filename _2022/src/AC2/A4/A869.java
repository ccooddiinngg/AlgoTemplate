package AC2.A4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class A869 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            find(num);
        }
    }

    private static void find(int num) {
        List<Integer> list = new ArrayList<>();
        //只考虑 num^(1/2)
        for (int i = 1; i <= num / i; i++) {
            if (num % i == 0) {
                //4 * 4 = 16, 只需加一个4
                if (num / i != i) {
                    list.add(num / i);
                }
                System.out.print(i + " ");
            }
        }
        for (int i = list.size() - 1; i >= 0; i--) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }
}
