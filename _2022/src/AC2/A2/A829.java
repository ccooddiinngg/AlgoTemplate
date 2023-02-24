package AC2.A2;

import java.util.Scanner;

public class A829 {
    static int[] queue = new int[100000];
    static int head = 0;
    static int tail = 0;

    static void push(int x) {
        queue[tail++] = x;
    }

    static void pop() {
        if (empty()) {
            throw new NullPointerException();
        }
        head++;
    }

    static int query() {
        if (empty()) {
            throw new NullPointerException();
        }
        return queue[head];
    }

    static boolean empty() {
        return tail == head;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < M; i++) {
            String[] s = sc.nextLine().split(" ");
            switch (s[0]) {
                case "push":
                    push(Integer.parseInt(s[1]));
                    break;
                case "query":
                    System.out.println(query());
                    break;
                case "pop":
                    pop();
                    break;
                case "empty":
                    if (empty()) {
                        System.out.println("YES");
                    } else {
                        System.out.println("NO");
                    }
                    break;
                default:
                    break;
            }
        }
    }
}
