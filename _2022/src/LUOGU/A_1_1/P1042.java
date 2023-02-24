package LUOGU.A_1_1;

import java.util.Scanner;

public class P1042 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        do {
            sb.append(sc.next());
        } while (sb.indexOf("E") == -1);    //出现E停止录入
        //截取有用的字符串
        String s = sb.substring(0, sb.indexOf("E") + 1);
        print(s.toString(), 11);
        System.out.println();
        print(s.toString(), 21);
    }

    static void print(String s, int points) {
        int p1 = 0;
        int p2 = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'E') break;
            if (s.charAt(i) == 'W') p1++;
            if (s.charAt(i) == 'L') p2++;
            if ((p1 >= points && p1 > p2 + 1) || (p2 >= points && p2 > p1 + 1)) {
                System.out.println(p1 + ":" + p2);
                p1 = 0;
                p2 = 0;
            }
        }
        System.out.println(p1 + ":" + p2);
    }
}
