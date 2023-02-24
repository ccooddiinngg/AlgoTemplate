package AC2.A2;

import java.util.Scanner;

public class A828 {
    static int[] stack = new int[100000];
    static int size = 0;

    static void push(int x) {
        stack[size++] = x;
    }

    static int pop() {
        if (empty()) {
            throw new NullPointerException();
        }
        size--;
        return stack[size];
    }

    static boolean empty() {
        return size == 0;
    }

    static int query() {
        if (empty()) {
            throw new NullPointerException();
        }
        return stack[size - 1];
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
