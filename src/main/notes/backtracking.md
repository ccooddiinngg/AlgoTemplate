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

### 51N皇后
```java
class Solution {
    public List<List<String>> solveNQueens(int n) {
        col = new boolean[n];
        d1 = new boolean[n * 2];
        d2 = new boolean[n * 2];
        List<List<String>> list = new ArrayList<>();
        bt(n, 0, new ArrayList<>(), list);
        return list;
    }

    boolean[] col;
    boolean[] d1;
    boolean[] d2;

    void bt(int n, int x, List<Integer> board, List<List<String>> list) {
        if (x == n) {
            // System.out.println(board);
            List<String> rows = new ArrayList<>();
            for (int p: board) {
                String[] row = new String[n];
                Arrays.fill(row, ".");
                row[p] = "Q";
                rows.add(String.join("", row));
            }
            list.add(rows);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (col[i] || d1[x + i] || d2[n + x - i]) {
                continue;
            }
            col[i] = true;
            d1[x + i] = true;
            d2[n + x - i] = true;
            board.add(i);
            bt(n, x + 1, board, list);
            board.remove(board.size() - 1);
            col[i] = false;
            d1[x + i] = false;
            d2[n + x - i] = false;
        }
    }
}
```

### 52N皇后II
```java
class Solution {
    public int totalNQueens(int n) {
        col = new boolean[n];
        d1 = new boolean[n * 2];
        d2 = new boolean[n * 2];
        return bt(n, 0);
    }

    boolean[] col;
    boolean[] d1;
    boolean[] d2;

    int bt(int n, int x) {
        if (x == n) {
            return 1;
        }
        int next = 0;
        for (int i = 0; i < n; i++) {
            if (col[i] || d1[x + i] || d2[n + x - i]) {
                continue;
            }
            col[i] = true;
            d1[x + i] = true;
            d2[n + x - i] = true;
            next += bt(n, x + 1);
            col[i] = false;
            d1[x + i] = false;
            d2[n + x - i] = false;
        }
        return next;
    }
}
```

### 60排列序列
```java
class Solution {
    public String getPermutation(int n, int k) {
		int[] nums = new int[n];
		int count = 1;
		for (int i = 1; i <= n; i++) {
			nums[i - 1] = i;
			count *= i;
		}

		StringBuilder sb = new StringBuilder();
		while (n > 0) {
            //每组的个数
			count /= n;
            //第几组
			int idx = (k - 1) / count;
			k -= idx * count;
            //找到第几个数
			int i = 0;
			while (idx >= 0) {
				if (nums[i] != 0) {
					idx--;
					if (idx < 0) {
						break;
					}
				}
				i++;
			}
			sb.append(nums[i]);
			nums[i] = 0;
			n--;
		}
		return sb.toString();
	}
}
```

### 77组合
```java
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<>();
        bt(n, 1, k, new ArrayList<>(), list);
        return list;
    }

    void bt(int n, int idx, int k, List<Integer> path, List<List<Integer>> list) {
        if (path.size() == k) {
            list.add(new ArrayList<>(path));
            return;
        }
        if (idx == n + 1) return;
        for (int i = idx; i <= n; i++) {
            path.add(i);
            bt(n, i + 1, k, path, list);
            path.remove(path.size() - 1);
        }
    }
}
```

### 78子集
```java
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        bt(nums, 0, new ArrayList<>(), list);
        return list;
    }

    void bt(int[] nums, int idx, List<Integer> path, List<List<Integer>> list) {
        if (idx == nums.length) {
            list.add(new ArrayList<>(path));
            return;
        }
        bt(nums, idx + 1, path, list);
        path.add(nums[idx]);
        bt(nums, idx + 1, path, list);
        path.remove(path.size() - 1);
    }
}
```

### 79单词搜索
```java
class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (bt(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    boolean bt(char[][] board, int x, int y, String word, int idx) {
        if (board[x][y] != word.charAt(idx)) {
            return false;
        }
        if (idx == word.length() - 1) {
            return true;
        }
        char t = board[x][y];
        board[x][y] = '.';
        for (int i = 0; i < dir.length; i++) {
            int x1 = x + dir[i][0];
            int y1 = y + dir[i][1];
            if (x1 >= 0 && x1 < board.length && y1 >= 0 && y1 < board[0].length && board[x1][y1] != '.') {
                if (bt(board, x1, y1, word, idx + 1)) return true;
            }
        }
        board[x][y] = t;
        return false;
    }
}
```

### 90子集II
```java
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        bt(nums, 0, true, new ArrayList<>(), list);
        return list;
    }

    void bt(int[] nums, int idx, boolean pre, List<Integer> path, List<List<Integer>> list) {
        if (idx == nums.length) {
            list.add(new ArrayList<>(path));
            return;
        }
        if (idx > 0 && nums[idx] == nums[idx - 1] && pre) {

        }else {
            bt(nums, idx + 1, false, path, list);
        }
        path.add(nums[idx]);
        bt(nums, idx + 1, true, path, list);
        path.remove(path.size() - 1);
    }
}
```

### 93复原IP地址
```java
class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> list = new ArrayList<>();
        bt(s, 0, new ArrayList<>(), list);
        return list;
    }

    void bt(String s, int idx, List<String> path, List<String> list) {
        if (idx == s.length()) {
            if (path.size() == 4) {
                list.add(String.join(".", path));
            }
            return;
        }
        if (s.charAt(idx) == '0') {
            path.add("0");
            bt(s, idx + 1, path, list);
            path.remove(path.size() - 1);
            return;
        }
        for (int i = idx + 1; i <= idx + 3 && i <= s.length(); i++) {
            int num = Integer.parseInt(s.substring(idx, i));
            if (num <= 255) {
                path.add(num + "");
                bt(s, i, path, list);
                path.remove(path.size() - 1);
            }
        }
    }
}
```

### 131分割回文串
```java
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<>();
        bt(s, 0, new ArrayList<>(), list);
        return list;
    }

    void bt(String s, int idx, List<String> path, List<List<String>> list) {
        if (idx == s.length()) {
            list.add(new ArrayList<>(path));
            return;
        }
        for (int i = idx + 1; i <= s.length(); i++) {
            String str = s.substring(idx, i);
            if (isPal(str)) {
                path.add(str);
                bt(s, i, path, list);
                path.remove(path.size() - 1);
            } 
        }
    }

    boolean isPal(String str) {
        int i = 0;
        int j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
```

### 140单词拆分II
```java
class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>();
        for (String word: wordDict) {
            dict.add(word);
        }
        List<String> list = new ArrayList<>();
        bt(s, 0, dict, new ArrayList<>(), list);
        return list;
    }

    void bt(String s, int idx, Set<String> dict, List<String> path, List<String> list) {
        if (idx == s.length()) {
            list.add(String.join(" ", path));
            return;
        }
        for (int i = idx + 1; i <= s.length(); i++) {
            String str = s.substring(idx, i);
            if (dict.contains(str)) {
                path.add(str);
                bt(s, i, dict, path, list);
                path.remove(path.size() - 1);
            }
        }
    }
}
```

### 212单词搜索II
```java
class Solution {
    Trie root = new Trie();

    class Trie {
        Trie[] next = new Trie[26];
        String word = null;
    }

    public void insert(String s) {
        Trie p = root;
        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            if (p.next[idx] == null) {
                p.next[idx] = new Trie();
            }
            p = p.next[idx];
        }
        p.word = s;
    }

    public List<String> findWords(char[][] board, String[] words) {
        Set<String> set = new HashSet<>();
        for (String word: words) {
            insert(word);
            set.add(word);
        }
        List<String> list = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                bt(board, i, j, root, set, list);
            }
        } 
        return list;
    }

    void bt(char[][] board, int x, int y, Trie p, Set<String> set, List<String> list) {
        if (p == null || x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] == '.') {
            return;
        }
        char c = board[x][y];
        int idx = c - 'a';
        Trie _p = p.next[idx];
        if (_p == null) return;
        if (_p.word != null && set.contains(_p.word)) {
            list.add(_p.word);
            set.remove(_p.word);
        }
        board[x][y] = '.';
        bt(board, x + 1, y, _p, set, list);
        bt(board, x - 1, y, _p, set, list);
        bt(board, x, y + 1, _p, set, list);
        bt(board, x, y - 1, _p, set, list);
        board[x][y] = c;
    }
}
```

### 216组合总和III
```java
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> list = new ArrayList<>();
        bt(n, k, 1, new ArrayList<>(), list);
        return list;
    }

    void bt(int rest, int k, int curr, List<Integer> path, List<List<Integer>> list) {
        if (k == 0) {
            if (rest == 0) {
                list.add(new ArrayList<>(path));
            }
            return;
        }
        for (int i = curr; i <= 9 && i <= rest; i++) {
            path.add(i);
            bt(rest - i, k - 1, i + 1, path, list);
            path.remove(path.size() - 1);
        }
    } 
}
```

### 306累加数
```java
class Solution {
    public boolean isAdditiveNumber(String num) {
        for (int i = 1; i < num.length() - 1; i++) {
            for (int j = i + 1; j < num.length(); j++) {
                String sa = num.substring(0, i);
                String sb = num.substring(i, j);
                if ((sa.length() > 1 && sa.charAt(0) == '0') || (sb.length() > 1 && sb.charAt(0) == '0')) {
                    continue;
                }
                if (bt(num, sa, sb, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean bt(String num, String sa, String sb, int idx) {
        if (idx == num.length()) {
            return true;
        }
        for (int i = idx + 1; i <= num.length(); i++) {
            String sc = num.substring(idx, i);
            if (sc.length() > 1 && sc.charAt(0) == '0') {
                return false;
            }
            if (sc.equals(add(sa, sb))) {
                if (bt(num, sb, sc, i)) {
                    return true;
                }
            }
        }
        return false;
    }

    String add(String sa, String sb) {
        StringBuilder res = new StringBuilder();
        int i = sa.length() - 1;
        int j = sb.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0 || carry > 0) {
            int a = i >= 0 ? (sa.charAt(i) - '0') : 0;
            int b = j >= 0 ? (sb.charAt(j) - '0') : 0;
            int c = a + b + carry;
            carry = c / 10;
            res.insert(0, c % 10);
            i--;
            j--;
        }
        return res.toString();
    }
}
```

















