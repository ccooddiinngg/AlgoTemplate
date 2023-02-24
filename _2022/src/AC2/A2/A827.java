package AC2.A2;

import java.util.Scanner;

public class A827 {
    static int head = 0;
    static int tail = 1;
    static int index = 2;
    static int[] e = new int[100000];
    static int[] l = new int[100000];
    static int[] r = new int[100000];

    static {
        r[head] = 1;
        l[tail] = 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < M; i++) {
            String[] s = sc.nextLine().split(" ");
            switch (s[0]) {
                case "L":
                    insertRight(head, Integer.parseInt(s[1]));
                    break;
                case "R":
                    insertRight(l[tail], Integer.parseInt(s[1]));
                    break;
                case "D":
                    remove(Integer.parseInt(s[1]) + 1);
                    break;
                case "IL":
                    insertRight(l[Integer.parseInt(s[1]) + 1], Integer.parseInt(s[2]));
                    break;
                case "IR":
                    insertRight(Integer.parseInt(s[1]) + 1, Integer.parseInt(s[2]));
                    break;
                default:
                    break;
            }
        }
        int curr = r[head];
        while (curr != tail) {
            System.out.print(e[curr] + " ");
            curr = r[curr];
        }
    }

    //注意顺序 r[k] 的改动要放到最后
    static void insertRight(int k, int val) {
        e[index] = val;
        r[index] = r[k];
        l[index] = k;
        l[r[k]] = index;
        r[k] = index;
        index++;
    }

    static void remove(int k) {
        r[l[k]] = r[k];
        l[r[k]] = l[k];
    }


}
