package Leetcode.Coding_Interview_6.C17;

public class S13 {
    public int respace(String[] dictionary, String sentence) {
        for (String str : dictionary) {
            insert(str);
        }
        return f(sentence);
    }

    int f(String sentence) {
        int n = sentence.length();
        int[] dp = new int[n + 1];

        for (int i = 1; i < dp.length; i++) {
            dp[i] = dp[i - 1] + 1;
            Node curr = head;
            for (int j = i; j > 0; j--) {
                int idx = sentence.charAt(j - 1) - 'a';
                if (curr.next[idx] == null) {
                    break;
                } else if (curr.next[idx].end) {
                    dp[i] = Math.min(dp[i], dp[j - 1]);
                }
                curr = curr.next[idx];
            }
        }
        return dp[n];
    }

    Node head = new Node();

    class Node {
        Node[] next;
        boolean end;

        public Node() {
            next = new Node[26];
            end = false;
        }
    }

    void insert(String s) {
        Node curr = head;
        for (int i = s.length() - 1; i >= 0; i--) {
            int idx = s.charAt(i) - 'a';
            if (curr.next[idx] == null) {
                curr.next[idx] = new Node();
            }
            curr = curr.next[idx];
        }
        curr.end = true;
    }
}
