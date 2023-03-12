package Stack;

import java.util.*;

public class NaryTreePostorderTraversal {
    public List<Integer> postorder(Node root) {
        Deque<Node> stack = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        stack.push(root);
        while (!stack.isEmpty()) {
            Node p = stack.pop();
            list.add(p.val);
            for (int i = 0; i < p.children.size(); i++) {
                stack.push(p.children.get(i));
            }
        }
        Collections.reverse(list);
        return list;
    }

}
