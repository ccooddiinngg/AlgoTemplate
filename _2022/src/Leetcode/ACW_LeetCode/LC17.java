package Leetcode.ACW_LeetCode;

import java.util.ArrayList;
import java.util.List;

public class LC17 {
    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if (digits.equals("")) return list;
        String[] map = {"", "", "abc", "edf", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        String[] strs = digits.split("");
        int[] nums = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            nums[i] = Integer.parseInt(strs[i]);
        }
        dfs(nums, 0, new StringBuilder(), list, map);
        return list;
    }

    void dfs(int[] nums, int idx, StringBuilder path, List<String> list, String[] map) {
        if (idx == nums.length) {
            list.add(path.toString());
            return;
        }
        String curr = map[nums[idx]];
        for (int i = 0; i < curr.length(); i++) {
            path.append(curr.charAt(i));
            dfs(nums, idx + 1, path, list, map);
            path.setLength(path.length() - 1);
        }
    }
}
