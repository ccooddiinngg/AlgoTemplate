package Leetcode.Coding_Interview_6.C01;

public class S01 {
    public boolean isUnique(String astr) {
        int bit = 0;
        for (int i = 0; i < astr.length(); i++) {
            int c = (int) astr.charAt(i) - 'a';
            if ((bit >> c & 1) == 1) return false;
            bit += 1 << c;
        }
        return true;
    }

}
