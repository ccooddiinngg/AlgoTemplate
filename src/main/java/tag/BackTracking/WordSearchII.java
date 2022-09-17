package tag.BackTracking;

import java.util.ArrayList;
import java.util.List;

public class WordSearchII {
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String s : words) {
            trie.insert(s);
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                Node p = trie.head;
                bt(board, i, j, p);
            }
        }
        return list;
    }

    int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    List<String> list = new ArrayList<>();

    void bt(char[][] board, int x, int y, Node p) {
        int idx = board[x][y] - 'a';
        if (p.next[idx] == null) {
            return;
        }
        if (p.next[idx].word != null) {
            list.add(p.next[idx].word);
            p.next[idx].word = null;
        }
        char t = board[x][y];
        board[x][y] = '*';
        for (int i = 0; i < dir.length; i++) {
            int x1 = x + dir[i][0];
            int y1 = y + dir[i][1];
            if (x1 >= 0 && x1 < board.length && y1 >= 0 && y1 < board[0].length && board[x1][y1] != '*') {
                bt(board, x1, y1, p.next[t - 'a']);
            }
        }
        board[x][y] = t;
    }

    class Trie {
        Node head = new Node();

        public Trie() {

        }

        void insert(String s) {
            Node p = head;
            for (char c : s.toCharArray()) {
                int idx = c - 'a';
                if (p.next[idx] == null) {
                    p.next[idx] = new Node();
                }
                p = p.next[idx];
            }
            p.word = s;
        }
    }

    class Node {
        Node[] next;
        String word;

        public Node() {
            this.next = new Node[26];
            this.word = null;
        }
    }
}

