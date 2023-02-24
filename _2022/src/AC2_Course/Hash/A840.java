package AC2_Course.Hash;

import java.util.Scanner;

//840 模拟散列表
public class A840 {

    static int prime = 100003;
    static Node[] arr = new Node[prime];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < q; i++) {
            String[] s = sc.nextLine().split(" ");
            String op = s[0];
            int v = Integer.parseInt(s[1]);
            switch (op) {
                case "I":
                    add(v);
                    break;
                case "Q":
                    if (find(v)) {
                        System.out.println("Yes");
                    } else {
                        System.out.println("No");
                    }
                    break;
                default:
            }
        }
    }

    static void add(int v) {
        int idx = ((v % prime) + prime) % prime;
        Node node = new Node(v);
        node.next = arr[idx];
        arr[idx] = node;
    }

    static boolean find(int v) {
        int idx = ((v % prime) + prime) % prime;
        Node node = arr[idx];
        while (node != null && node.val != v) {
            node = node.next;
        }
        return node != null;
    }

    static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
            next = null;
        }
    }
}

