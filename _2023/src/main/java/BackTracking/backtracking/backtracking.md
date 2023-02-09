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

### 136. Single Number

```java
class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res = res ^ num;
        }
        return res;
    }
}
```

### 137. Single Number II

> count 1

```java
class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int one = 0;
            for (int num : nums) {
                if ((num >> i & 1) == 1) {
                    one++;
                }
            }
            if (one % 3 == 1) {
                res |= 1 << i;
            }
        }
        return res;
    }
}
```