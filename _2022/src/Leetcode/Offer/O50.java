package Leetcode.Offer;

public class O50 {
    public char firstUniqChar(String s) {
        int[] map = new int[26];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            map[chars[i] - 'a']++;
        }
        char res = ' ';
        for (int i = 0; i < chars.length; i++) {
            if (map[chars[i] - 'a'] == 1) {
                res = chars[i];
                break;
            }
        }
        return res;
    }
}
