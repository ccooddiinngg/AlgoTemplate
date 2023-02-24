package Leetcode.Coding_Interview_6.C03;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class S03 {
    class StackOfPlates {
        List<Stack<Integer>> list;
        int cap;

        public StackOfPlates(int cap) {
            this.cap = cap;
            list = new ArrayList<>();
            list.add(new Stack<>());
        }

        public void push(int val) {
            //if cap == 0 do nothing
            if (cap == 0) return;
            Stack<Integer> curr = list.get(list.size() - 1);
            if (curr.size() == cap) {
                list.add(new Stack<>());
                list.get(list.size() - 1).push(val);
            } else {
                curr.push(val);
            }

        }

        public int pop() {
            Stack<Integer> curr = list.get(list.size() - 1);
            if (curr.isEmpty()) {
                return -1;
            } else {
                int v = curr.pop();
                if (curr.isEmpty() && list.size() > 1) {
                    list.remove(list.size() - 1);
                }
                return v;
            }
        }

        public int popAt(int index) {
            //if index out of bound, return -1
            if (index < 0 || index >= list.size()) {
                return -1;
            }
            Stack<Integer> curr = list.get(index);
            if (index == 0 && curr.isEmpty()) {
                return -1;
            }
            int v = curr.pop();
            if (curr.isEmpty() && list.size() > 1) {
                list.remove(index);
            }
            return v;
        }
    }
}
