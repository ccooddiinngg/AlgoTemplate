package utils;

public class TrieNode {
    public TrieNode[] next;
    public boolean isEnd;

    public TrieNode() {
        this.next = new TrieNode[26];
        this.isEnd = false;
    }
}
