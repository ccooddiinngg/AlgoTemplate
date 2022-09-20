package tag.Tree;

import java.util.ArrayList;
import java.util.List;

public class NumberOfWaysToReorderArrayToGetSameBST {
    int mod = (int) 1e9 + 7;
    long[][] dp;

    public int numOfWays(int[] nums) {
        int m = nums.length;
        dp = new long[m + 1][m + 1];
        dp[0][0] = 1;
        for (int i = 1; i < m + 1; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= i; j++) {
                dp[i][j] = (dp[i - 1][j] + dp[i - 1][j - 1]) % mod;
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        return (int) dfs(list) - 1;
    }

    long dfs(List<Integer> nums) {
        int m = nums.size();
        if (m <= 1) return 1;

        int root = nums.get(0);
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        for (int num : nums) {
            if (num < root) {
                left.add(num);
            } else if (num > root) {
                right.add(num);
            }
        }
        return ((dfs(left) * (dfs(right)) % mod) * ((dp[m - 1][left.size()]))) % mod;
    }
}

/*So, we can know that for a fixed root, the left subtree elements and the right subtree elements are also fixed.

We can find the left subtree elements which are all the elements that is smaller than root value, and right subtree elements which are greater than root value.

And in order to make it identical with original BST, we should keep the relative order in left subtree elements and in right subtree elements.

Assume the length of left subtree elements is left_len and right is right_len, they can change their absolute position but need to keep their relative position in either left subtree or right subtree.

So as the subtree, so we use recursion.*/
