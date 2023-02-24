package Leetcode.Coding_Interview_6.C01;

public class S04 {
    public boolean canPermutePalindrome(String s) {
        int[] map = new int[128];
        for (int i = 0; i < s.length(); i++) {
            int c = (int) s.charAt(i);
            map[c]++;
        }
        int single = 0;
        for (int num : map) {
            if (num % 2 == 1) {
                single++;
            }
        }
        return single <= 1;
    }
}
