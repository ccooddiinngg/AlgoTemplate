package ZuoChengyun.Basic.Day07;

import ZuoChengyun.Basic.Node;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Tree {
    public Node root;

    public Tree(Node root) {
        this.root = root;
    }

    public void serialize(Node root, LinkedList<String> list) {
        if (root == null) {
            list.add(null);
            return;
        }
        list.add(String.valueOf(root.val));
        serialize(root.left, list);
        serialize(root.right, list);
    }

    public static Node deserialize(LinkedList<String> list) {
        String n = list.poll();
        if (n == null) return null;
        Node node = new Node(Integer.parseInt(n));
        node.left = deserialize(list);
        node.right = deserialize(list);
        return node;
    }

    public void serializeBFS(Node root, LinkedList<String> list) {
        if (root == null) {
            list.add(null);
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        list.add(String.valueOf(root.val));
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.left != null) {
                queue.add(node.left);
                list.add(String.valueOf(node.left.val));
            } else {
                list.add(null);
            }
            if (node.right != null) {
                queue.add(node.right);
                list.add(String.valueOf(node.right.val));
            } else {
                list.add(null);
            }
        }
    }

    public static Node deserialize(Integer[] array) {
        LinkedList<String> list = new LinkedList<>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                list.add(((array[i].toString())));
            } else {
                list.add(null);
            }
        }
        return deserializeBFS(list);
    }

    public static Node deserializeBFS(LinkedList<String> list) {
        Queue<Node> q = new LinkedList<>();
        String s = list.poll();
        Node root = buildNode(s);
        if (root != null) {
            q.add(root);
        }
        while (!q.isEmpty()) {
            Node node = q.poll();
            node.left = buildNode(list.poll());
            if (node.left != null) q.add(node.left);
            node.right = buildNode(list.poll());
            if (node.right != null) q.add(node.right);
        }
        return root;
    }

    private static Node buildNode(String s) {
        if (s == null) return null;
        return new Node(Integer.parseInt(s));
    }

    //recursive
    public static void pre(Node root) {
        if (root == null) return;
        System.out.println(root.val);
        pre(root.left);
        pre(root.right);
    }

    //iteration
    //root -> left -> right
    public void pre1(Node root) {
        if (root == null) return;
        Stack<Node> stack = new Stack<>();

        stack.add(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            System.out.println(node.val);
            if (node.right != null) {
                stack.add(node.right);
            }
            if (node.left != null) {
                stack.add(node.left);
            }
        }
    }

    //root -> right -> left ==> left -> right -> root
    public void post1(Node root) {
        if (root == null) return;
        Stack<Node> stack = new Stack<>();
        Stack<Node> s = new Stack<>();

        stack.add(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            s.add(node);
            if (node.left != null) {
                stack.add(node.left);
            }
            if (node.right != null) {
                stack.add(node.right);
            }
        }
        while (!s.isEmpty()) {
            System.out.println(s.pop().val);
        }
    }

    public void in1(Node root) {
        if (root == null) return;
        Stack<Node> stack = new Stack<>();

        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.add(root.left);
                root = root.left;
            } else {
                Node node = stack.pop();
                System.out.println(node.val);
                root = node.right;
            }
        }
    }

    public void breadth(Node root) {
        if (root == null) return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node node = q.remove();
            System.out.println(node.val);
            if (node.left != null) q.add(node.left);
            if (node.right != null) q.add(node.right);
        }
    }
}
