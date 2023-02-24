package Leetcode.NeetCode;

//@@ sliding window
public class N567 {
    public boolean checkInclusion(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        if (m > n) {
            return false;
        }

        int[] letters = new int[26];
        for (char c : s1.toCharArray()) {
            letters[c - 'a']++;
        }

        int[] window = new int[26];
        int i = -1;
        int j = -1;
        while (j < m - 1) {
            j++;
            window[s2.charAt(j) - 'a']++;
        }
        if (equals(letters, window)) {
            return true;
        }
        while (j < n - 1) {
            j++;
            i++;
            window[s2.charAt(j) - 'a']++;
            window[s2.charAt(i) - 'a']--;
            if (equals(letters, window)) {
                return true;
            }
        }
        return false;
    }

    public boolean equals(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }
}
