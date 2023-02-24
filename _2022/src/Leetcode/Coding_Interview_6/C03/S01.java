package Leetcode.Coding_Interview_6.C03;

public class S01 {
    class TripleInOne {
        int[] stack;
        int stackSize;
        int[] idx;

        public TripleInOne(int stackSize) {
            this.stackSize = stackSize;
            stack = new int[stackSize * 3];
            idx = new int[3];
        }

        public void push(int stackNum, int value) {
            if (idx[stackNum] + (stackSize * stackNum) < stackSize * (stackNum + 1)) {
                stack[idx[stackNum] + (stackSize * stackNum)] = value;
                idx[stackNum]++;
            }
        }

        public int pop(int stackNum) {
            if (!isEmpty(stackNum)) {
                idx[stackNum]--;
                int v = stack[idx[stackNum] + (stackSize * stackNum)];
                return v;
            } else {
                return -1;
            }
        }

        public int peek(int stackNum) {
            if (!isEmpty(stackNum)) {
                int v = stack[idx[stackNum] + (stackSize * stackNum) - 1];
                return v;
            } else {
                return -1;
            }
        }

        public boolean isEmpty(int stackNum) {
            return idx[stackNum] == 0;
        }
    }
}
