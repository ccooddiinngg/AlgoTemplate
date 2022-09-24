package tag.DynamicProgramming;

public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        int m = s.length();
        int max = 0;
        int[] dp = new int[m];
        for (int i = 1; i < m; i++) {
            if (s.charAt(i) == ')') {
                int j = i - 1;
                //(...)()
                if (s.charAt(j) == '(') {
                    dp[i] = 2 + (j - 1 >= 0 ? dp[j - 1] : 0);
                }
                //((...))
                if (s.charAt(j) == ')' && j - dp[j] >= 0 && s.charAt(j - dp[j]) == '(') {
                    int v = dp[j] + 2;
                    //(...)((...))
                    if (j - dp[j] - 1 >= 0) v += dp[j - dp[j] - 1];
                    dp[i] = Math.max(dp[i], v);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
