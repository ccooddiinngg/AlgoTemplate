package Leetcode.Coding_Interview_6.C01;

public class S02 {
    public boolean CheckPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        int[] map = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            map[s1.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s2.length(); i++) {
            int c = s2.charAt(i) - 'a';
            map[c]--;
            if (map[c] < 0) return false;
        }
        return true;
    }
}
