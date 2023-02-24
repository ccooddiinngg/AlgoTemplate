package AC2.A2;

import java.util.Scanner;
import java.util.Stack;

public class A830 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int[] res = find(nums);
        for (int num : res) {
            System.out.print(num + " ");
        }

    }

    static int[] find(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
                res[stack.pop()] = stack.isEmpty() ? -1 : nums[stack.peek()];
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            res[stack.pop()] = stack.isEmpty() ? -1 : nums[stack.peek()];
        }
        return res;
    }
}
