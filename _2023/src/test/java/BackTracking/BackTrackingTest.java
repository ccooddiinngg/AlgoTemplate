package BackTracking;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

class BackTrackingTest {

    @Test
    void test() {
        String[] stickers = {"claim", "last", "determine", "cry", "bed", "result", "human", "duck", "seem"};
        String target = "camereal";
        Assertions.assertEquals(3, minStickers(stickers, target));
    }

    public int minStickers(String[] stickers, String target) {
        int m = target.length();
        int[][] count = new int[stickers.length][26];
        for (int i = 0; i < stickers.length; i++) {
            for (int j = 0; j < stickers[i].length(); j++) {
                count[i][stickers[i].charAt(j) - 'a']++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        q.offer(0);
        set.add(0);
        int step = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            step++;
            for (int i = 0; i < size; i++) {
                int curr = q.poll();
//                System.out.println(Integer.toBinaryString(curr));
                if (curr == (1 << m) - 1) {
                    return step - 1;
                }
                for (int[] c : count) {
                    int state = curr;
                    int[] temp = Arrays.copyOf(c, c.length);
                    for (int j = 0; j < m; j++) {
                        int idx = target.charAt(j) - 'a';
                        if ((state >> (m - 1 - j) & 1) == 0 && temp[idx] > 0) {
                            state |= (1 << (m - 1 - j));
                            temp[idx]--;
                        }
                    }
                    if (!set.contains(state)) {
                        set.add(state);
                        q.offer(state);
                    }
                }
            }

        }
        return -1;
    }


}

