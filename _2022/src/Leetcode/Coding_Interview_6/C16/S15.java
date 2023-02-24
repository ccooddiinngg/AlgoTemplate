package Leetcode.Coding_Interview_6.C16;

import java.util.HashMap;
import java.util.Map;

public class S15 {
    public int[] masterMind(String solution, String guess) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('R', 0);
        map.put('Y', 1);
        map.put('G', 2);
        map.put('B', 3);
        int[] sol = new int[4];
        int[] gue = new int[4];
        int count = 0;
        for (int i = 0; i < solution.length(); i++) {
            sol[map.get(solution.charAt(i))]++;
            if (solution.charAt(i) == guess.charAt(i)) {
                count++;
            }
        }
        for (int i = 0; i < guess.length(); i++) {
            gue[map.get(guess.charAt(i))]++;
        }
        int total = 0;
        for (int i = 0; i < sol.length; i++) {
            total += Math.min(sol[i], gue[i]);
        }
        return new int[]{count, total - count};
    }
}
