package Leetcode.Coding_Interview_6.C16;

public class S02 {
    class WordsFrequency {
        Trie head;

        public WordsFrequency(String[] book) {
            head = new Trie();
            for (String str : book) {
                insert(str);
            }
        }

        public int get(String word) {
            int count = prefix(word);
            return count;
        }

        class Trie {
            Trie[] next;
            int count;

            public Trie() {
                next = new Trie[26];
                count = 0;
            }
        }

        void insert(String str) {
            Trie curr = head;
            for (int i = 0; i < str.length(); i++) {
                int idx = str.charAt(i) - 'a';
                if (curr.next[idx] == null) {
                    curr.next[idx] = new Trie();
                }
                curr = curr.next[idx];
            }
            curr.count++;
        }

        int prefix(String str) {
            Trie curr = head;
            for (int i = 0; i < str.length(); i++) {
                int idx = str.charAt(i) - 'a';
                if (curr.next[idx] == null) {
                    return 0;
                }
                curr = curr.next[idx];
            }
            return curr.count;
        }
    }
}
