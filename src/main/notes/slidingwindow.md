[3. 无重复字符的最长子串](https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/)

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

> 发现有重复的字符c，找到c的位置idx, 把(pre,idx]之间的字符都移除掉，然后更新pre的值，max的值，最后把当前字符和下标放入map中

[76. 最小覆盖子串](https://leetcode-cn.com/problems/minimum-window-substring/)

```java
class Solution {

    public String minWindow(String s, String t) {
        int[] map = new int[128];
        for (int i = 0; i < t.length(); i++) {
            map[t.charAt(i)]++;
        }
        int sum = 0;
        for (int v : map) {
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
        return min == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1]);
    }
}
```

[209. 长度最小的子数组](https://leetcode-cn.com/problems/minimum-size-subarray-sum/)

```java
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int m = nums.length;
        int i = 0;
        int j = 0;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        while (j < m) {
            while (j < m && sum < target) {
                sum += nums[j];
                j++;
            }
            if (j == m && sum < target) {
                break;
            }
            while (sum >= target) {
                sum -= nums[i];
                i++;
            }
            min = Math.min(min, j - i + 1);
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
```

[239. 滑动窗口最大值](https://leetcode-cn.com/problems/sliding-window-maximum/)

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

[424. 替换后的最长重复字符](https://leetcode-cn.com/problems/longest-repeating-character-replacement/)

```java
class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int max = 0;
        int i = 0;
        int j = 0;
        // 记录window中哪个字符的频率最高
        int main = 0;
        while (j < s.length()) {
            count[s.charAt(j) - 'A']++;
            //如果只需要求最大长度, 当一个最大main出现后, 其他小于它的长度都不用考虑
            main = Math.max(main, count[s.charAt(j) - 'A']);
            j++;
            //以i开始的字串不满足要求了, 尝试i+1开始的字串
            if (j - i > main + k) {
                count[s.charAt(i) - 'A']--;
                i++;
            }
            //现在window中字符的个数是满足要求的
            max = Math.max(max, j - i);
        }
        return max;
    }
}
```

> 滑动窗口，维护一个窗口，窗口内的字符个数减去窗口内出现次数最多的字符的个数，如果小于等于k，那么就可以替换

[567. 字符串的排列](https://leetcode-cn.com/problems/permutation-in-string/)

```java
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        if (m > n) return false;
        int[] map = new int[26];
        for (int i = 0; i < m; i++) {
            map[s1.charAt(i) - 'a']++;
        }
        int l = 0;
        int r = 0;
        while (l <= n - m) {
            while (r < l + m && map[s2.charAt(r) - 'a'] >= 1) {
                map[s2.charAt(r) - 'a']--;
                r++;
            }
            if (r == l + m) {
                return true;
            }
            map[s2.charAt(l) - 'a']++;
            l++;
        }
        return false;
    }
}
```

> 记录s1中每个字符的频率, 在s2上滑动窗口, 如果r字符频率大于0, 扩大窗口, 把r字符频率减1, 否则说明窗口内的字符不满足要求, 把l字符频率加1, 窗口左边界右移. 如果窗口长度等于s1的长度, 说明满足要求, 返回true
