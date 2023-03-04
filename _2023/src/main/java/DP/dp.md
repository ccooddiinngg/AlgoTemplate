### 32. Longest Valid Parentheses

> ()()
> ()(())

```java
class Solution {
    public int longestValidParentheses(String s) {
        int m = s.length();
        int[] dp = new int[m];
        for (int i = 0; i < m; i++) {
            if (s.charAt(i) == '(') continue;
            if (i > 0 && s.charAt(i - 1) == '(') {
                dp[i] += 2;
                if (i - 2 > 0) {
                    dp[i] += dp[i - 2];
                }
            }
            if (i > 0 && dp[i - 1] > 0 && i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                dp[i] += 2 + dp[i - 1];
                if (i - dp[i - 1] - 2 >= 0) {
                    dp[i] += dp[i - dp[i - 1] - 2];
                }
            }
        }
        int max = 0;
        for (int v : dp) {
            max = Math.max(max, v);
        }
        return max;
    }
}
```

### 42. Trapping Rain Water

```java
class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[][] dp = new int[n][2];
        //[][0]maxLeft, [][1]maxRight
        dp[0][0] = height[0];
        dp[n - 1][1] = height[n - 1];
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], height[i]);
            dp[n - 1 - i][1] = Math.max(dp[n - i][1], height[n - 1 - i]);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += Math.max(Math.min(dp[i][0], dp[i][1]) - height[i], 0);
        }
        return ans;
    }
}
```