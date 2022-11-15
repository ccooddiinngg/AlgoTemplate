### 3无重复字符的最长子串
```java
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int pre = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                int idx = map.get(c);
                for (int k = pre + 1; k <= idx; k++) {
                    map.remove(s.charAt(k));
                }
                pre = idx;
            }
            max = Math.max(max, i - pre);
            map.put(c, i);
        }
        return max;
    }
}
```
>发现有重复的字符c，找到c的位置idx, 把(pre,idx]之间的字符都移除掉，然后更新pre的值，max的值，最后把当前字符和下标放入map中

### 76最小覆盖子串
```java
class Solution {
    
    public String minWindow(String s, String t) {
        int[] map = new int[128];
        for (int i = 0; i < t.length(); i++) {
            map[t.charAt(i)]++;
        }
        int sum = 0;
        for (int v: map) {
            if (v > 0) {
                sum++;
            }
        }
        int[] count = new int[128];
        int l = 0;
        int r = 0;
        int cnt = 0;
        int min = Integer.MAX_VALUE; 
        int[] res = new int[2];
        while (r < s.length()) {
            count[s.charAt(r)]++;
            if (count[s.charAt(r)] == map[s.charAt(r)]) {
                cnt++;
            }
            if (cnt == sum) {
                while (l <= r) {
                    count[s.charAt(l)]--;
                    if (count[s.charAt(l)] < map[s.charAt(l)]) {
                        cnt--;
                        if (r - l + 1 < min) {
                            min = r - l + 1;
                            res[0] = l;
                            res[1] = r + 1;
                        }
                        l++;
                        break;
                    }
                    l++;
                }
            }
            r++;
        }
        return min == Integer.MAX_VALUE ? "":s.substring(res[0], res[1]);
    }
}
```

### 239滑动窗口最大值
```java
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int m = nums.length;
        LinkedList<Integer> q = new LinkedList<>();
        int[] res = new int[m - k + 1];
        int i = 0;
        int j = 0;
        int idx = 0;
        while (j < m) {
            if (j >= k) {
                if (!q.isEmpty() && q.peekFirst() == i) {
                    q.pollFirst();
                }
                i++;
            }
            while (!q.isEmpty() && nums[q.peekLast()] <= nums[j]) {
                q.pollLast();
            }
            q.offerLast(j);
            if (j >= k - 1) {
                res[idx++] = nums[q.peekFirst()];
            }
            j++;
        }
        return res;
    }
}
```