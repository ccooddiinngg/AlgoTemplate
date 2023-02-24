package AC2_Course.UnionFind;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UnionFind<T> {
    List<Node<T>> nodes;
    Map<T, Node<T>> map;

    public UnionFind(List<T> list) {
        nodes = new ArrayList<>();
        map = new HashMap<>();
        for (T el : list) {
            Node<T> node = new Node<>(el);
            nodes.add(node);
            map.put(el, node);
        }
    }

    public Node<T> findParent(T el) {
        Node<T> node = map.get(el);
        if (node.parent != node) {
            node.parent = findParent(node.parent.el);
        }
        return node.parent;
    }

    public void union(T el1, T el2) {
        Node<T> n1 = findParent(el1);
        Node<T> n2 = findParent(el2);
        if (n1 == n2) {
            return;
        }
        n1.parent = n2;
        n2.size += n1.size;
    }

    //@@ compare their parent
    public boolean isSameSet(T el1, T el2) {
        return findParent(el1) == findParent(el2);
    }

    static class Node<T> {
        T el;
        int size;
        Node<T> parent;

        public Node(T el) {
            this.el = el;
            this.size = 1;
            parent = this;
        }
    }
}
