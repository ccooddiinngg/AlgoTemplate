### 78. Subsets

```java
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        helper(nums, 0, new ArrayList<>(), list);
        return list;
    }

    public void helper(int[] nums, int idx, List<Integer> path, List<List<Integer>> list) {
        if (idx == nums.length) {
            list.add(new ArrayList<>(path));
            return;
        }
        helper(nums, idx + 1, path, list);
        path.add(nums[idx]);
        helper(nums, idx + 1, path, list);
        path.remove(path.size() - 1);
    }
}
```

### 89. Gray Code

> 找到答案就返回

```java
class Solution {
    public List<Integer> grayCode(int n) {
        int len = (int) Math.pow(2, n);
        buildMap(n);
        dfs(n, len, 0, 0, new ArrayList<>());
        return list;
    }

    Map<Integer, List<Integer>> map = new HashMap<>();
    List<Integer> list = new ArrayList<>();
    Set<Integer> set = new HashSet<>();

    public boolean dfs(int n, int len, int idx, int curr, List<Integer> path) {
        if (set.contains(curr)) return false;
        set.add(curr);
        path.add(curr);
        if (idx == len - 1) {
            list = new ArrayList<>(path);
            return true;
        }

        List<Integer> neis = map.get(curr);
        for (int nei : neis) {
            if (dfs(n, len, idx + 1, nei, path)) {
                return true;
            }
        }
        set.remove(curr);
        path.remove(path.size() - 1);
        return false;
    }

    boolean isEnd(int curr) {
        return (curr & (curr - 1)) == 0;
    }

    void buildMap(int n) {
        for (int key = 0; key < 1 << n; key++) {
            map.put(key, new ArrayList<>());
            List<Integer> list = map.get(key);
            for (int i = 0; i < n; i++) {
                if ((key >> i & 1) == 0) {
                    list.add(key | (1 << i));
                } else {
                    list.add(key - (1 << i));
                }
            }
        }
    }
}
```

### 90. Subsets II

> 上一个没选，这个相同的就不选了

```java
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(nums, 0, new ArrayList<>(), false);
        return list;
    }

    List<List<Integer>> list = new ArrayList<>();

    public void dfs(int[] nums, int idx, List<Integer> path, boolean selected) {
        if (idx == nums.length) {
            list.add(new ArrayList<>(path));
            return;
        }
        dfs(nums, idx + 1, path, false);
        if (idx > 0 && nums[idx] == nums[idx - 1] && !selected) {
            return;
        }
        path.add(nums[idx]);
        dfs(nums, idx + 1, path, true);
        path.remove(path.size() - 1);
    }
}
```

### 473. Matchsticks to Square

```java
class Solution {
    public boolean makesquare(int[] matchsticks) {
        int m = matchsticks.length;
        if (m < 4) return false;
        int sum = 0;
        for (int stick : matchsticks) {
            sum += stick;
        }
        if (sum % 4 != 0) return false;
        int LEN = sum / 4;
        for (int stick : matchsticks) {
            if (stick > LEN) return false;
        }
        Arrays.sort(matchsticks);
        return dfs(matchsticks, m - 1, new int[4], LEN);
    }

    public boolean dfs(int[] matchsticks, int idx, int[] group, int LEN) {
        if (idx < 0) {
            for (int l : group) {
                if (l < LEN) return false;
            }
            return true;
        }
        for (int i = 0; i < group.length; i++) {
            if (group[i] + matchsticks[idx] <= LEN) {
                group[i] += matchsticks[idx];
                if (dfs(matchsticks, idx - 1, group, LEN)) {
                    return true;
                }
                group[i] -= matchsticks[idx];
            }
        }
        return false;
    }

}
```

### 526. Beautiful Arrangement

```java
class Solution {
    public int countArrangement(int n) {
        int[] nums = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            nums[i] = i;
        }
        return dfs(nums, 1);
    }

    public int dfs(int[] nums, int idx) {
        if (idx == nums.length) {
            return 1;
        }
        int next = 0;
        for (int i = idx; i < nums.length; i++) {
            if (nums[i] % idx == 0 || idx % nums[i] == 0) {
                swap(nums, i, idx);
                next += dfs(nums, idx + 1);
                swap(nums, i, idx);
            }
        }
        return next;
    }

    public void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
```

### 698. Partition to K Equal Sum Subsets

```java
class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        sort(nums, 0, nums.length - 1);
        for (int num : nums) {
            System.out.print(num + " ");
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % k != 0) {
            return false;
        }
        int target = sum / k;
        for (int num : nums) {
            if (num > target) return false;
        }
        return dfs(nums, 0, 0, target, target, k);
    }

    //试着先填充一个集合
    //用0，1代表nums中的选择状态
    public boolean dfs(int[] nums, int idx, int state, int target, int rest, int k) {
        if (k == 0) {
            return true;
        }
        if (rest == 0) {
            return dfs(nums, 0, state, target, target, k - 1);
        }
        for (int i = idx; i < nums.length; i++) {
            if (nums[i] <= rest && (state >> i & 1) == 0) {
                if (dfs(nums, i + 1, state + (1 << i), target, rest - nums[i], k)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void sort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int idx = partition(nums, left, right);
        sort(nums, left, idx);
        sort(nums, idx + 1, right);
    }

    public int partition(int[] nums, int left, int right) {
        int seed = nums[left + right >> 1];
        int i = left - 1;
        int j = right + 1;
        while (i < j) {
            while (nums[++i] > seed) ;
            while (nums[--j] < seed) ;
            if (i < j) {
                swap(nums, i, j);
            }
        }
        return j;
    }

    public void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
```

### 756. Pyramid Transition Matrix

> ABC -> 001010 -> 011

```java
class Solution {
    int[] asc = new int[128];
    Map<Integer, List<Integer>> map = new HashMap<>();

    public boolean pyramidTransition(String bottom, List<String> allowed) {
        for (int i = 'A'; i <= 'F'; i++) {
            asc[i] = i - 'A' + 1;
        }

        for (String s : allowed) {
            int a = asc[s.charAt(0)] << 3 | asc[s.charAt(1)];
            int b = asc[s.charAt(2)];
            if (!map.containsKey(a)) {
                map.put(a, new ArrayList<>());
            }
            map.get(a).add(b);
        }

        int state = 0;
        for (int i = 0, j = (bottom.length() - 1) * 3; i < bottom.length(); i++, j -= 3) {
            state |= (asc[bottom.charAt(i)] << j);
        }

        return dfs(state);
    }

    boolean dfs(int state) {
        if (state < 8) return true;
        List<Integer> next = new ArrayList<>();
        getNext(state, 0, 0, next);
        for (int n : next) {
            if (dfs(n)) return true;
        }
        return false;
    }

    void getNext(int curr, int offset, int path, List<Integer> list) {
        if (curr < 8) {
            list.add(path);
            return;
        }
        //加上括号
        int mask = (1 << 6) - 1;
        if (!map.containsKey(curr & mask)) return;
        for (int next : map.get(curr & mask)) {
            getNext(curr >> 3, offset + 3, path + (next << offset), list);
        }
    }
}
```

### 784. Letter Case Permutation

```java
class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> list = new ArrayList<>();
        dfs(s, 0, new StringBuilder(), list);
        return list;
    }

    public void dfs(String s, int idx, StringBuilder path, List<String> list) {
        if (idx == s.length()) {
            list.add(path.toString());
            return;
        }
        char c = s.charAt(idx);
        if (Character.isLetter(c)) {
            path.append(Character.toLowerCase(c));
            dfs(s, idx + 1, path, list);
            path.setLength(path.length() - 1);
            path.append(Character.toUpperCase(c));
            dfs(s, idx + 1, path, list);
            path.setLength(path.length() - 1);
        } else {
            path.append(c);
            dfs(s, idx + 1, path, list);
            path.setLength(path.length() - 1);
        }
    }
}
```

### 980. Unique Paths III

```java
class Solution {
    public int uniquePathsIII(int[][] grid) {
        int count = 0;
        int x = 0;
        int y = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    count++;
                }
                if (grid[i][j] == 1) {
                    x = i;
                    y = j;
                }
            }
        }
        return dfs(grid, x, y, count + 1);
    }

    public int dfs(int[][] grid, int x, int y, int count) {
        if (x < 0 || x == grid.length || y < 0 || y == grid[0].length || grid[x][y] == -1) {
            return 0;
        }
        if (grid[x][y] == 2) {
            if (count == 0) {
                return 1;
            }
            return 0;
        }
        int t = grid[x][y];
        grid[x][y] = -1;
        int next = 0;
        count--;
        next += dfs(grid, x - 1, y, count);
        next += dfs(grid, x + 1, y, count);
        next += dfs(grid, x, y - 1, count);
        next += dfs(grid, x, y + 1, count);
        grid[x][y] = t;
        return next;
    }
}
```