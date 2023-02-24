package AC2_Course.Trie;

public class Trie {
    Node head;

    public Trie() {
        this.head = new Node();
    }

    public void add(String s) {
        Node curr = head;
        int i = 0;
        while (i < s.length()) {
            int index = s.charAt(i) - 'a';
            if (curr.next[index] == null) {
                curr.next[index] = new Node();
            }
            curr = curr.next[index];
            i++;
        }
        curr.isEnd = true;
    }

    Node getNode(String s) {
        Node curr = head;
        int i = 0;
        while (i < s.length()) {
            int index = s.charAt(i) - 'a';
            if (curr.next[index] == null) {
                return null;
            }
            curr = curr.next[index];
            i++;
        }
        return curr;
    }

    public boolean hasPrefix(String s) {
        return getNode(s) != null;
    }

    public boolean hasWord(String s) {
        Node node = getNode(s);
        return node != null && node.isEnd;
    }

    static class Node {
        boolean isEnd;
        Node[] next;

        public Node() {
            this.isEnd = false;
            this.next = new Node[26];
        }
    }
}
