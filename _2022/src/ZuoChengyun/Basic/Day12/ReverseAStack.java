package ZuoChengyun.Basic.Day12;

import java.util.Stack;

public class ReverseAStack {
    public static void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) return;
        int bottom = getBottom(stack);
        reverse(stack);
        stack.push(bottom);
    }

    public static int getBottom(Stack<Integer> stack) {
        int i = stack.pop();
        if (stack.isEmpty()) {
            return i;
        } else {
            int j = getBottom(stack);
            stack.push(i);
            return j;
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(3);
        stack.push(5);
        stack.push(7);
        System.out.println(stack);
        ReverseAStack.reverse(stack);
        System.out.println(stack);
    }
}
