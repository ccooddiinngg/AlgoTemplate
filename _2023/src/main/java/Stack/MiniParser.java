package Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MiniParser {
    interface NestedInteger {
        void add(NestedInteger ni);
    }

    class NI implements NestedInteger {
        public NI() {
        }

        public NI(int v) {

        }

        @Override
        public void add(NestedInteger ni) {

        }
    }

    public NestedInteger deserialize(String s) {
        int m = s.length();
        Stack<NestedInteger> stack = new Stack<>();
        NestedInteger head = new NI();
        int pre = 0;
        int sign = 1;
        for (int i = 0; i < m; i++) {
            char c = s.charAt(i);
            if (c == '[') {
                stack.push(new NI());
                stack.push(head);
            } else if (c == '-') {
                sign = -1;
            } else if (c == ']') {
                List<NestedInteger> list = new ArrayList<>();
                while (stack.peek() != head) {
                    list.add(stack.pop());
                }
//                pop head
                stack.pop();
                for (int j = list.size() - 1; j >= 0; j--) {
                    stack.peek().add(list.get(j));
                }
            } else if (Character.isDigit(c)) {
                pre = pre * 10 + c - '0';
                if (i == m - 1 || (i < m - 1 && !Character.isDigit(s.charAt(i + 1)))) {
                    stack.push(new NI(sign * pre));
                    pre = 0;
                    sign = 1;
                }
            }
        }
        return stack.pop();
    }

}


