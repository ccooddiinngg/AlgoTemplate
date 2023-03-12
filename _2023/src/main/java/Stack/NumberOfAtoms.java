package Stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class NumberOfAtoms {
    public String countOfAtoms(String formula) {
        Map<String, Integer> map = new HashMap<>();
        Deque<Node> stack = new ArrayDeque<>();
        int m = formula.length();
        int i = 0;
        while (i < m) {
            char c = formula.charAt(i);
            if (c == '(') {
                stack.push(new Node("("));
                i++;
            }
            if (c == ')') {
                List<Node> li = new ArrayList<>();
                while (!stack.isEmpty() && !stack.peek().el.equals("(")) {
                    li.add(stack.pop());
                }
                stack.pop();
                int j = i + 1;
                int multiply = 1;
                StringBuilder multi = new StringBuilder();
                while (j < m && Character.isDigit(formula.charAt(j))) {
                    multi.append(formula.charAt(j));
                    j++;
                }
                if (multi.length() != 0) {
                    multiply = Integer.parseInt(multi.toString());
                }
                for (Node node : li) {
                    node.count *= multiply;
                    stack.push(node);
                }
                i = j;
            }
            if (Character.isUpperCase(c)) {
                StringBuilder atomic = new StringBuilder();
                atomic.append(c);
                int j = i + 1;
                while (j < m && (Character.isLowerCase(formula.charAt(j)))) {
                    atomic.append(formula.charAt(j));
                    j++;
                }
                int count = 1;
                StringBuilder cnt = new StringBuilder();
                while (j < m && (Character.isDigit(formula.charAt(j)))) {
                    cnt.append(formula.charAt(j));
                    j++;
                }
                if (cnt.length() != 0) {
                    count = Integer.parseInt(cnt.toString());
                }
                String el = atomic.toString();
                stack.push(new Node(el, count));
                i = j;
            }
        }
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            map.put(node.el, map.getOrDefault(node.el, 0) + node.count);
        }
        StringBuilder sb = new StringBuilder();
        List<String> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);
        for (String key : keys) {
            sb.append(key).append(map.get(key) == 1 ? "" : map.get(key));
        }
        return sb.toString();
    }

    class Node {
        String el;
        int count;

        public Node(String _el, int _count) {
            el = _el;
            count = _count;
        }

        public Node(String _el) {
            el = _el;
            count = 1;
        }
    }

    @Test
    void test() {
        String formula = "H2O";
        Assertions.assertEquals("H2O", countOfAtoms(formula));
    }
}
