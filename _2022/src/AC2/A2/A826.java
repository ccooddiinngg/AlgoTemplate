package AC2.A2;

import java.util.Scanner;

public class A826 {
    static int[] e = new int[100000];
    static int[] ne = new int[100000];
    static int head = -1;
    static int index = 1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < M; i++) {
            String[] s = sc.nextLine().split(" ");

            switch (s[0]) {
                case "H" -> insertHead(Integer.parseInt(s[1]));
                case "I" -> insertAfter(Integer.parseInt(s[1]), Integer.parseInt(s[2]));
                case "D" -> removeAfter(Integer.parseInt(s[1]));
                default -> {
                }
            }

        }
        int curr = head;
        while (curr != -1) {
            System.out.print(e[curr] + " ");
            curr = ne[curr];
        }
    }

    static void insertHead(int val) {
        e[index] = val;
        ne[index] = head;
        head = index++;
    }

    static void insertAfter(int k, int val) {
        e[index] = val;
        ne[index] = ne[k];
        ne[k] = index;
        index++;
    }

    static void removeAfter(int k) {
        if (k == 0) {
            head = ne[head];
            return;
        }
        ne[k] = ne[ne[k]];
    }
}


