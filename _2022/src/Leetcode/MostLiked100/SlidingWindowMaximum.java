package Leetcode.MostLiked100;

import java.util.Arrays;
import java.util.LinkedList;

public class SlidingWindowMaximum {
    static class Window {
        int left;
        int right;
        LinkedList<Integer> window;
        int[] array;

        public Window(int[] array) {
            this.array = array;
            left = -1;
            right = -1;
            window = new LinkedList<>();
        }

        public Integer getMax() {
            if (window.isEmpty()) {
                return null;
            }
            return window.getFirst();
        }

        public void moveRight() {
            if (right == array.length - 1) {
                return;
            }
            right++;
            while (!window.isEmpty() && array[window.getLast()] < array[right]) {
                window.pollLast();
            }
            window.addLast(right);
        }

        public void moveLeft() {
            if (left == right) {
                return;
            }
            left++;
            while (window.getFirst() <= left) {
                window.pollFirst();
            }
        }
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length + 1 - k];
        int resIndex = 0;

        Window window = new Window(nums);
        for (int i = 0; i < k; i++) {
            window.moveRight();
        }
        res[resIndex++] = nums[window.getMax()];

        for (int i = k; i < nums.length; i++) {
            window.moveRight();
            window.moveLeft();
            res[resIndex++] = nums[window.getMax()];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        System.out.println(Arrays.toString(maxSlidingWindow(nums, k)));
    }
}
