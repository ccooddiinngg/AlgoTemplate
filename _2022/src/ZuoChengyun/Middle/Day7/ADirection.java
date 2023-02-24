package ZuoChengyun.Middle.Day7;

import java.util.TreeMap;

public class ADirection {
    static class Node {
        String val;
        TreeMap<String, Node> next;

        public Node(String val) {
            this.val = val;
            this.next = new TreeMap<>();
        }
    }

    // s = ["a\\b\\c", "b\\e",...]
    public static Node buildDirection(String[] s) {
        Node root = new Node("");
        for (int i = 0; i < s.length; i++) {
            Node curr = root;
            String[] str = s[i].split("\\\\");
            for (int j = 0; j < str.length; j++) {
                if (!curr.next.containsKey(str[j])) {
                    Node node = new Node(str[j]);
                    curr.next.put(str[j], node);
                }
                curr = curr.next.get(str[j]);
            }
        }
        return root;
    }

    public static void printDFS(Node root, String path) {
        if (root.next == null) {
            return;
        }
        for (String key : root.next.keySet()) {
            System.out.print(path);
            System.out.println(key);
            printDFS(root.next.get(key), path + "--");
        }
    }

    public static void main(String[] args) {
        String[] s = {"a\\b\\c", "x\\ef", "m1\\n"};
        Node root = ADirection.buildDirection(s);
        ADirection.printDFS(root, " ");
    }

}
