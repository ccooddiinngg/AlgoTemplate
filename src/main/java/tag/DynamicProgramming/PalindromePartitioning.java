package tag.DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<>();
        int m = s.length();
        dp = new boolean[m][m];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = i; j < m; j++) {
                if (i == j) {
                    dp[i][j] = true;
                } else if (i == j - 1) {
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1];
                }
            }
        }
        bt(s, 0, new ArrayList<>(), list);
        return list;
    }

    boolean[][] dp;

    void bt(String s, int idx, List<String> path, List<List<String>> list) {
        if (idx == s.length()) {
            list.add(new ArrayList<>(path));
            return;
        }
        int i = 0;
        while (idx + i < s.length()) {
            if (dp[idx][idx + i]) {
                path.add(s.substring(idx, idx + i + 1));
                bt(s, idx + i + 1, path, list);
                path.remove(path.size() - 1);
            }
            i++;
        }
    }

    /*Different*/
    public List<List<String>> partition1(String s) {
        List<List<String>> list = new ArrayList<>();
        int m = s.length();
        cache = new int[m][m + 1];
        bt1(s, 0, new ArrayList<>(), list);
        return list;
    }

    int[][] cache;

    void bt1(String s, int idx, List<String> path, List<List<String>> list) {
        if (idx == s.length()) {
            list.add(new ArrayList<>(path));
            return;
        }
        int i = 1;
        while (idx + i <= s.length()) {
            if (cache[idx][idx + i] == 1 || (cache[idx][idx + i] == 0 && isValid(s, idx, idx + i))) {
                path.add(s.substring(idx, idx + i));
                bt1(s, idx + i, path, list);
                path.remove(path.size() - 1);
            }
            i++;
        }
    }

    boolean isValid(String s, int l, int r) {
        int i = l;
        int j = r - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                cache[l][r] = 2;
                return false;
            }
            i++;
            j--;
        }
        cache[l][r] = 1;
        return true;
    }
}
