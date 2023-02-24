package AC2.A2;

import java.util.Arrays;
import java.util.Scanner;

public class A840 {
    static int p = 100003;
    static int[] h = new int[p];
    static int[] e = new int[p];
    static int[] ne = new int[p];
    static int index = 0;

    static {
        Arrays.fill(h, -1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String[] s = sc.nextLine().split(" ");
            if ("I".equals(s[0])) {
                insert(Integer.parseInt(s[1]));
            } else if ("Q".equals(s[0])) {
                boolean b = find(Integer.parseInt(s[1]));
                if (b) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No");
                }
            }
        }
    }

    private static boolean find(int x) {
        int idx = (x % p + p) % p;
        int index = h[idx];
        while (index != -1) {
            if (e[index] == x) {
                return true;
            }
            index = ne[index];
        }
        return false;
    }

    //把x插入到h[idx]的头部
    private static void insert(int x) {
        int idx = (x % p + p) % p;
        e[index] = x;
        ne[index] = h[idx];
        h[idx] = index++;
    }
}
