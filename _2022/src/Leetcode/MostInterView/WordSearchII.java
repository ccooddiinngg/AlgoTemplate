package Leetcode.MostInterView;

import java.util.LinkedList;
import java.util.List;

class WordSearchII {
    public List<String> findWords(char[][] board, String[] words) {
        Node root = buildTrie(words);
        List<String> list = new LinkedList<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                helper(board, i, j, root, list);
            }
        }
        return list;
    }

    public void helper(char[][] board, int i, int j, Node root, List<String> list) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == '*') {
            return;
        }

        Node next = root.next[board[i][j] - 'a'];
        if (next != null) {
            if (next.word != null) {
                list.add(next.word);
                //! remove word from the search list.
                next.word = null;
            }
            char c = board[i][j];
            board[i][j] = '*';

            helper(board, i + 1, j, next, list);
            helper(board, i, j + 1, next, list);
            helper(board, i - 1, j, next, list);
            helper(board, i, j - 1, next, list);

            board[i][j] = c;
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

    public Node buildTrie(String[] words) {
        Node root = new Node();
        for (String s : words) {
            Node node = root;
            for (char c : s.toCharArray()) {
                int index = c - 'a';
                if (node.next[index] == null) {
                    node.next[index] = new Node();
                }
                node = node.next[index];
            }
            node.word = s;
        }
        return root;
    }

    public static void main(String[] args) {
        WordSearchII wordSearchII = new WordSearchII();
        char[][] board = {{'a', 'b', 'c', 'e'}, {'x', 'x', 'c', 'd'}, {'x', 'x', 'b', 'a'}};
        String[] words = {"abc", "abcd"};
        System.out.println(wordSearchII.findWords(board, words));
    }
}
