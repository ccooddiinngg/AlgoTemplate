package Stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class ExclusiveTimeOfFunctions {
    public int[] exclusiveTime(int n, List<String> logs) {
        Deque<int[]> stack = new ArrayDeque<>();
        int[] ans = new int[n];
        for (String log : logs) {
            String[] strs = log.split(":");
            int id = Integer.parseInt(strs[0]);
            int time = Integer.parseInt(strs[2]);
            if (strs[1].equals("start")) {
                if (!stack.isEmpty()) {
                    ans[stack.peek()[0]] += time - stack.peek()[1];
                }
                stack.push(new int[]{id, time});
            } else {
                time++;
                int[] last = stack.pop();
                ans[last[0]] += time - last[1];
                if (!stack.isEmpty()) {
                    stack.peek()[1] = time;
                }
            }
        }
        return ans;
    }

    @Test
    void test() {
        int n = 2;
        List<String> logs = List.of("0:start:0", "1:start:2", "1:end:5", "0:end:6");
        Assertions.assertArrayEquals(new int[]{3, 4}, exclusiveTime(n, logs));
    }
}
