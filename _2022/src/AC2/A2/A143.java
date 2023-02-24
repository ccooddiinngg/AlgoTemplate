package AC2.A2;

import java.util.Scanner;

public class A143 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
            insert(nums[i]);
            max = Math.max(max, find(nums[i]));
        }

        System.out.println(max);
    }

    static class Node {
        Node[] next;

        public Node() {
            this.next = new Node[2];
        }
    }

    static Node root = new Node();

    static void insert(int n) {
        Node curr = root;
        for (int i = 31; i >= 0; i--) {
            int idx = n >> i & 1;
            if (curr.next[idx] == null) {
                curr.next[idx] = new Node();
            }
            curr = curr.next[idx];
        }
    }

    static int find(int n) {
        Node c = root;
        int res = 0;
        for (int i = 31; i >= 0; i--) {
            int bit = n >> i & 1;
            if (bit == 1) {
                if (c.next[0] != null) {
                    res += 1 << i;
                    c = c.next[0];
                } else {
                    c = c.next[1];
                }
            } else {
                if (c.next[1] != null) {
                    res += 1 << i;
                    c = c.next[1];
                } else {
                    c = c.next[0];
                }
            }
        }
        return res;
    }
}
