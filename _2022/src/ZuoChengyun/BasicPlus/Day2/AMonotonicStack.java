package ZuoChengyun.BasicPlus.Day2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class AMonotonicStack {

    public int[] array;

    public Integer[][] result;
    public Stack<LinkedList<Integer>> stack;

    public AMonotonicStack(int[] array) {
        this.array = array;
        result = new Integer[array.length][2];
        stack = new Stack<>();

    }

    public void build() {
        for (int i = 0; i < array.length; i++) {
            if (!stack.isEmpty() && array[stack.peek().peekLast()] == array[i]) {
                stack.peek().add(i);
            } else {
                while (!stack.isEmpty() && array[stack.peek().peekLast()] > array[i]) {
                    LinkedList<Integer> pop = stack.pop();
                    Integer down = stack.isEmpty() ? null : stack.peek().peekLast();
                    while (!pop.isEmpty()) {
                        Integer index = pop.pollLast();
                        result[index] = new Integer[]{down, i};
                    }
                }
                LinkedList<Integer> temp = new LinkedList<>();
                temp.add(i);
                stack.add(temp);
            }
        }
        while (!stack.isEmpty()) {
            LinkedList<Integer> pop = stack.pop();
            Integer down = stack.isEmpty() ? null : stack.peek().peekLast();
            while (!pop.isEmpty()) {
                Integer index = pop.pollLast();
                result[index] = new Integer[]{down, null};
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {4, 3, 3, 5, 1, 2, 6, 7};
        AMonotonicStack aMonotonicStack = new AMonotonicStack(array);
        aMonotonicStack.build();
        System.out.println(Arrays.deepToString(aMonotonicStack.result));
    }
}
