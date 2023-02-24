package ZuoChengyun.Basic.Day05;

public class ATrie {
    private final Node root;

    public ATrie() {
        this.root = new Node();
    }

    private static class Node {
        public int p = 0;
        public int e = 0;
        public Node[] next = new Node[26];
    }

    public void insert(String word) {
        Node curr = root;
        curr.p++;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (curr.next[c - 'a'] == null) {
                curr.next[c - 'a'] = new Node();
            }
            curr = curr.next[c - 'a'];
            curr.p++;
        }
        curr.e++;
    }


    /**
     * @param word word
     * @return word frequency
     */
    public int search(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (curr.next[c - 'a'] == null) {
                return 0;
            }
            curr = curr.next[c - 'a'];
        }
        return curr.e;
    }

    /**
     * @param prefix prefix string
     * @return count of strings with same prefix
     */
    public int prefixNumber(String prefix) {
        Node curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (curr.next[c - 'a'] == null) {
                return 0;
            }
            curr = curr.next[c - 'a'];
        }
        return curr.p;
    }

    public void remove(String word) {
        int frequency = search(word);
        if (frequency == 0) {
            return;
        }
        Node curr = root;
        curr.p--;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            curr.next[c - 'a'].p--;
            if (curr.next[c - 'a'].p == 0) {
                curr.next[c - 'a'] = null;
                return;
            }
            curr = curr.next[c - 'a'];
        }
        curr.e--;
    }

    public static void main(String[] args) {
        ATrie aTrie = new ATrie();
        aTrie.insert("abc");
        aTrie.insert("abc");
        aTrie.insert("abc");
        aTrie.insert("ab");
        aTrie.insert("abcd");
        System.out.println(aTrie.search("abc"));
        System.out.println(aTrie.prefixNumber("ab"));
        aTrie.remove("abc");
        System.out.println(aTrie.search("abc"));
    }
}

