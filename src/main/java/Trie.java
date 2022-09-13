import utils.TrieNode;

public class Trie {
    private TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(String s) {
        TrieNode p = this.root;
        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            if (p.next[idx] == null) {
                p.next[idx] = new TrieNode();
            }
            p = p.next[idx];
        }
        p.isEnd = true;
    }

    public boolean has(String s) {
        TrieNode p = this.root;
        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            if (p.next[idx] == null) {
                return false;
            }
            p = p.next[idx];
        }
        return p.isEnd;
    }
}
