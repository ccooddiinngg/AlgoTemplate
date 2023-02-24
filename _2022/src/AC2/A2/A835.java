package AC2.A2;

import java.util.Scanner;

public class A835 {
    static Node root = new Node();

    static class Node {
        int count = 0;
        Node[] next = new Node[26];
    }

    static void insert(String s) {
        Node curr = root;
        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            if (curr.next[idx] == null) {
                curr.next[idx] = new Node();
            }
            curr = curr.next[idx];
        }
        curr.count++;
    }

    static int query(String s) {
        Node curr = root;
        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            if (curr.next[idx] == null) {
                return 0;
            }
            curr = curr.next[idx];
        }
        return curr.count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String[] s = sc.nextLine().split(" ");
            switch (s[0]) {
                case "I":
                    insert(s[1]);
                    break;
                case "Q":
                    System.out.println(query(s[1]));
                    break;
                default:
                    break;
            }
        }
    }
}
