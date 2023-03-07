package Stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;

public class LongestAbsoluteFilePath {
    public int lengthLongestPath(String input) {
        //stack存储子树的head,当子树遍历结束后(发现节点的层级高于或等于head的层级),弹出head直到找到正确的head
        Stack<Node> stack = new Stack<>();
        String[] strs = input.split("\n");
        int max = -1;
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            int l = 0;
            while (l < str.length() && str.charAt(l) == '\t') {
                l++;
            }
            while (!stack.isEmpty() && stack.peek().level >= l) {
                stack.pop();
            }
            int len = (stack.isEmpty() ? 0 : stack.peek().len) + str.length() - l + 1;
            if (str.contains(".")) {
                max = Math.max(max, len);
            }
            stack.push(new Node(len, l));
        }
        return max == -1 ? 0 : max - 1;
    }

    class Node {
        int len;
        int level;

        public Node(int _len, int _level) {
            len = _len;
            level = _level;
        }
    }

    @Test
    void test() {
        String input = "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext";
        Assertions.assertEquals(20, lengthLongestPath(input));
    }

    @Test
    void test2() {
        String input = "a";
        Assertions.assertEquals(0, lengthLongestPath(input));
    }
}

