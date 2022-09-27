package tag.DynamicProgramming;

import java.util.List;

public class WordBreak {
    Trie root = new Trie();

    public boolean wordBreak(String s, List<String> wordDict) {
        for (String word : wordDict) {
            Trie p = root;
            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';
                if (p.next[index] == null) {
                    p.next[index] = new Trie();
                }
                p = p.next[index];
            }
            p.isEnd = true;
        }
        cache = new int[s.length()];
        return bt(s.toCharArray(), 0);
    }

    int[] cache;

    boolean bt(char[] chars, int idx) {
        if (idx == chars.length) {
            return true;
        }
        if (cache[idx] != 0) return cache[idx] == 1;
        Trie p = root;
        int i = idx;
        while (i < chars.length) {
            int index = chars[i] - 'a';
            if (p.next[index] == null) {
                break;
            }
            p = p.next[index];
            if (p.isEnd && bt(chars, i + 1)) {
                cache[idx] = 1;
                return true;
            }
            i++;
        }
        cache[idx] = 2;
        return false;
    }

    class Trie {
        Trie[] next = new Trie[26];
        boolean isEnd = false;

        public Trie() {
        }
    }
}
