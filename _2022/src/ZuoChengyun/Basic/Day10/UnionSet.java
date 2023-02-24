package ZuoChengyun.Basic.Day10;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class UnionSet<T> {
    public static class Node<T> {
        public T value;

        public Node(T value) {
            this.value = value;
        }
    }

    public Map<T, Node<T>> nodes;
    public Map<Node<T>, Node<T>> parents;
    public Map<Node<T>, Integer> sizeMap;

    public UnionSet(List<T> values) {
        nodes = new HashMap<>();
        parents = new HashMap<>();
        sizeMap = new HashMap<>();

        for (T v : values) {
            Node<T> node = new Node<>(v);
            nodes.put(v, node);
            parents.put(node, node);
            sizeMap.put(node, 1);
        }
    }

    private Node<T> findParent(Node<T> node) {
        Stack<Node<T>> stack = new Stack<>();
        while (parents.get(node) != node) {
            stack.push(node);
            node = parents.get(node);
        }
        while (!stack.isEmpty()) {
            parents.put(stack.pop(), node);
        }
        return node;
    }

    public boolean isSameSet(T a, T b) {
        if (!nodes.containsKey(a) || !nodes.containsKey(b)) return false;
        return parents.get(nodes.get(a)) == parents.get(nodes.get(b));
    }

    public void union(T a, T b) {
        if (!nodes.containsKey(a) || !nodes.containsKey(b)) return;
        Node<T> aP = findParent(nodes.get(a));
        Node<T> bP = findParent(nodes.get(b));
        if (aP == bP) return;
        Integer sizeA = sizeMap.get(aP);
        Integer sizeB = sizeMap.get(bP);

        if (sizeA >= sizeB) {
            parents.put(bP, aP);
            sizeMap.put(aP, sizeA + sizeB);
            sizeMap.remove(bP);
        } else {
            parents.put(aP, bP);
            sizeMap.put(bP, sizeA + sizeB);
            sizeMap.remove(aP);
        }
    }


}
