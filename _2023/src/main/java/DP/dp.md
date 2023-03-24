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

### 53. Maximum Subarray

```java
class Solution {
    public int maxSubArray(int[] nums) {
        int m = nums.length;
        int[] dp = new int[m];
        dp[0] = nums[0];
        for (int i = 1; i < m; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
        }
        int max = Integer.MIN_VALUE;
        for (int v : dp) {
            max = Math.max(max, v);
        }
        return max;
    }
}
```

### 918. Maximum Sum Circular Subarray

> 1. 最大值出现在中间区间，求连续字串的最大值：max
> 2. 最大值出现在首位相连区间，求中间区间连续字串的最小值(和为负数的一段)，max = Math.max(max, sum - min)
> 3. 如果都为负数，找最大值即可

```java
class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int m = nums.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        //以i为结尾的连续子串最小值
        int[] dp1 = new int[m];
        //以i为结尾的连续子串的最大值
        int[] dp2 = new int[m];
        dp1[0] = nums[0];
        dp2[0] = nums[0];

        int sum = nums[0];
        boolean negative = nums[0] < 0;
        for (int i = 1; i < m; i++) {
            sum += nums[i];
            if (nums[i] >= 0) negative = false;
            dp1[i] = Math.min(nums[i], dp1[i - 1] + nums[i]);
            dp2[i] = Math.max(nums[i], dp2[i - 1] + nums[i]);
        }
        for (int v : dp1) {
            min = Math.min(min, v);
        }
        for (int v : dp2) {
            max = Math.max(max, v);
        }
        if (negative) {
            return max;
        } else {
            return Math.max(max, sum - min);
        }
    }
}
```