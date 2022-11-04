### 10正则表达式匹配
```java
class Solution {
    public boolean isMatch(String s, String p) {
        cache = new int[s.length() + 1][p.length()];
        return bt(s, p, 0, 0);
    }

    int[][] cache;
    boolean bt(String s, String p, int si, int pi) {
        if (pi == p.length()) {
            return si == s.length();
        }
        if (cache[si][pi] != 0) {
            return cache[si][pi] == 1;
        }
        boolean match = si < s.length() && (s.charAt(si) == p.charAt(pi) || p.charAt(pi) == '.');
        boolean next = false;
        if (pi < p.length() - 1 && p.charAt(pi + 1) == '*') {
            next = (match && bt(s, p, si + 1, pi)) || bt(s, p, si, pi + 2);
        }else {
            next = match && bt(s, p, si + 1, pi + 1);
        }
        cache[si][pi] = next ? 1:2;
        return next;
    }
}
```

### 17电话号码的字母组合
```java
class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if (digits.length() == 0) return list;
        bt(digits, 0, new StringBuilder(), list);
        return list;
    }

    String[] map = {"", "", "abc", "edf", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    
    void bt(String digits, int idx, StringBuilder path, List<String> list) {
        if (idx == digits.length()) {
            list.add(path.toString());
            return;
        }
        String str = map[digits.charAt(idx) - '0'];
        for (int i = 0; i < str.length(); i++) {
            path.append(str.charAt(i));
            bt(digits, idx + 1, path, list);
            path.setLength(path.length() - 1);
        }
    }
    
}
```

### 22括号生成
```java
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        bt(n, 0, 0, new StringBuilder(), list);
        return list;
    }

    void bt(int n, int l, int r, StringBuilder path, List<String> list) {
        if (l + r == n * 2) {
            list.add(path.toString());
            return;
        }
        if (l < n) {
            path.append('(');
            bt(n, l + 1, r, path, list);
            path.setLength(path.length() - 1);
        }
        if (r < l) {
            path.append(')');
            bt(n, l, r + 1, path, list);
            path.setLength(path.length() - 1);
        }
    }
}
```

### 37解数独
```java
class Solution {
    public void solveSudoku(char[][] board) {
        row = new boolean[9][9];
        col = new boolean[9][9];
        unit = new boolean[3][3][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0' - 1;
                    row[i][num] = true;
                    col[j][num] = true;
                    unit[i / 3][j / 3][num] = true;
                }
            }
        }
        bt(board, 0, 0);
    }

    boolean[][] row;
    boolean[][] col;
    boolean[][][] unit;

    boolean bt(char[][] board, int x, int y) {
        if (y == 9) {
            x++;
            y = 0;
        }
        if (x == 9) return true;
        if (board[x][y] != '.') {
            return bt(board, x , y + 1);
        }else {
            for (int i = 0; i < 9; i++) {
                if (row[x][i] || col[y][i] || unit[x / 3][y / 3][i]) {
                    continue;
                }
                board[x][y] = (char)(i + '1');
                row[x][i] = true;
                col[y][i] = true;
                unit[x / 3][y / 3][i] = true;
                if (bt(board, x, y + 1)) {
                    return true;
                }
                board[x][y] = '.';
                row[x][i] = false;
                col[y][i] = false;
                unit[x / 3][y / 3][i] = false;
            }
            return false;
        }
    }
}
```

### 39组合总和
```java
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        bt(candidates, 0, target, new ArrayList<>(), list);
        return list;
    }

    void bt(int[] candidates, int idx, int rest, List<Integer> path, List<List<Integer>> list) {
        if (rest == 0) {
            list.add(new ArrayList<>(path));
            return;
        }
        if (idx == candidates.length) {
            return;
        }
        for (int i = idx; i < candidates.length; i++) {
            if (candidates[i] <= rest) { 
                path.add(candidates[i]);
                bt(candidates, i, rest - candidates[i], path, list);
                path.remove(path.size() - 1);
            }
        }
    }
}
```

### 40组合总和II
```java
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> list = new ArrayList<>();
        bt(candidates, 0, target, new ArrayList<>(), list);
        return list;
    }

    void bt(int[] candidates, int idx, int rest, List<Integer> path, List<List<Integer>> list) {
        if (rest == 0) {
            list.add(new ArrayList<>(path));
            return;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = idx; i < candidates.length; i++) {
            if (candidates[i] <= rest) {
                if (!set.contains(candidates[i])) {
                    set.add(candidates[i]);
                    path.add(candidates[i]);
                    bt(candidates, i + 1, rest - candidates[i], path, list);
                    path.remove(path.size() - 1);
                }
            }
        }
    }
}
```

### 44通配符匹配
```java
class Solution {
    public boolean isMatch(String s, String p) {
        cache = new int[s.length() + 1][p.length() + 1];
        return bt(s, p, 0, 0);
    }
    int[][] cache;
    boolean bt(String s, String p, int si, int pi) {
        if (pi == p.length()) {
            return si == s.length();
        }
        if (si > s.length()) return false;
        if (cache[si][pi] != 0) {
            return cache[si][pi] == 1;
        }
        boolean match = si < s.length() && (s.charAt(si) == p.charAt(pi) || p.charAt(pi) == '?');
        boolean next = false;
        if (p.charAt(pi) == '*') {
            next = bt(s, p, si + 1, pi) || bt(s, p, si, pi + 1);
        }else {
            next = match && bt(s, p, si + 1, pi + 1);
        }
        cache[si][pi] = next? 1:2;
        return next;
    }
}
```

### 46全排列
```java
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        bt(nums, 0, new ArrayList<>(), list);
        return list;
    }

    void bt(int[] nums, int idx, List<Integer> path, List<List<Integer>> list) {
        if (idx == nums.length) {
            list.add(new ArrayList<>(path));
            return;
        }
        for (int i = idx; i < nums.length; i++) {
            swap(nums, idx, i);
            path.add(nums[idx]);
            bt(nums, idx + 1, path, list);
            swap(nums, idx, i);
            path.remove(path.size() - 1);
        }
    }

    void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
```

### 47全排列II
```java
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        bt(nums, 0, new ArrayList<>(), list);
        return list;
    }

    void bt(int[] nums, int idx, List<Integer> path, List<List<Integer>> list) {
        if (idx == nums.length) {
            list.add(new ArrayList<>(path));
            return;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = idx; i < nums.length; i++) {
            if (!set.contains(nums[i])) {
                set.add(nums[i]);
                swap(nums, idx, i);
                path.add(nums[idx]);
                bt(nums, idx + 1, path, list);
                swap(nums, idx, i);
                path.remove(path.size() - 1);
            }
        }
    }

    void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
```








