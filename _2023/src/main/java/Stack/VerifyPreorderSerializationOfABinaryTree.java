package Stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;

public class VerifyPreorderSerializationOfABinaryTree {
    public boolean isValidSerialization(String preorder) {
        String[] p = preorder.split(",");
        Stack<String> stack = new Stack<>();
        int i = 0;
        while (i < p.length) {
            String str = p[i];
            if (str.equals("#")) {
                if (!stack.isEmpty() && stack.peek().equals("#")) {
                    stack.pop();
                    if (stack.isEmpty()) return false;
                    stack.pop();
                    continue;
                }
            }
            stack.push(str);
            i++;
        }
        return stack.size() == 1 && stack.pop().equals("#");
    }

    @Test
    void test() {
        String preorder = "9,3,4,#,#,1,#,#,2,#,6,#,#";
        Assertions.assertTrue(isValidSerialization(preorder));
    }
}
