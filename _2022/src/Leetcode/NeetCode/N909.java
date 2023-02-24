package Leetcode.NeetCode;

import org.junit.jupiter.api.Test;

import java.util.*;

//@@ BFS
public class N909 {


    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        Map<Integer, Integer> map = new HashMap<>();
        boolean goRight = true;
        int number = 1;
        for (int i = n - 1; i >= 0; i--) {
            int j;
            if (goRight) {
                j = 0;
                while (j < n) {
                    if (board[i][j] == -1) {
                        map.put(number, number);
                    } else {
                        map.put(number, board[i][j]);
                    }
                    j++;
                    number++;
                }
            } else {
                j = n - 1;
                while (j >= 0) {
                    if (board[i][j] == -1) {
                        map.put(number, number);
                    } else {
                        map.put(number, board[i][j]);
                    }
                    j--;
                    number++;
                }
            }
            goRight = !goRight;
        }
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> currents = new LinkedList<>();
        currents.add(1);
        int size = currents.size();
        int level = 0;
        while (size > 0) {
            int c = currents.poll();
            visited.add(c);
            for (int i = 1; i <= 6; i++) {
                if (c + i <= n * n) {
                    int next = map.get(c + i);
                    if (!visited.contains(next)) {
                        currents.add(next);
                    }
                }
            }
            size--;

            if (size == 0) {
                level++;
                if (currents.contains(n * n)) {
                    break;
                } else {
                    size = currents.size();
                }
            }

        }
        return level;
    }


    @Test
    void test() {
        int[][] board = {{-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}, {-1, 35, -1, -1, 13, -1}, {-1, -1, -1, -1, -1, -1}, {-1, 15, -1, -1, -1, -1}};
        int steps = snakesAndLadders(board);
        System.out.println(steps);
    }
}
