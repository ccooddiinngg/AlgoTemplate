package Stack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class NaryTreePreorderTraversal {
    public List<Integer> preorder(Node root) {
        Deque<Node> stack = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        stack.push(root);
        while (!stack.isEmpty()) {
            Node p = stack.pop();
            list.add(p.val);
            for (int i = p.children.size() - 1; i >= 0; i--) {
                stack.push(p.children.get(i));
            }
        }
        return list;
    }

}
