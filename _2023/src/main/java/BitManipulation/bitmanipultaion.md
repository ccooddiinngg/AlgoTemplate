### 78. Subsets

> 利用比特位代表选与不选

```java
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        int m = nums.length;
        int n = 1 << m;
        for (int i = 0; i < n; i++) {
            List<Integer> path = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                if ((i >> j & 1) == 1) {
                    path.add(nums[j]);
                }
            }
            list.add(path);
        }
        return list;
    }
}
```

### 89. Gray Code

> 0->0->00
> .->1->01
> ....->11
> ....->10

```java
class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        for (int i = 1; i <= n; i++) {
            int size = list.size();
            for (int j = size - 1; j >= 0; j--) {
                list.add(list.get(j) | (1 << (i - 1)));
            }
        }
        return list;
    }
}
```

### 187. Repeated DNA Sequences

```java
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<Integer> set = new HashSet<>();
        Set<String> res = new HashSet<>();
        int[] map = new int[128];
        map['A'] = 0;
        map['C'] = 1;
        map['G'] = 2;
        map['T'] = 3;
        int i = 0;
        int j = 0;
        int num = 0;

        while (j < s.length()) {
            if (j >= 10) {
                num -= (map[s.charAt(i)] << 18);
                i++;
            }
            num = (num << 2) | map[s.charAt(j)];
            j++;
            if (j >= 10 && !set.add(num)) {
                res.add(s.substring(i, j));
            }
        }
        return new ArrayList<>(res);
    }
}
```

### 190. Reverse Bits

```java
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res |= (n >> i & 1) << (31 - i);
        }
        return res;
    }
}
```

### 191. Number of 1 Bits

```java
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }
}
```

### 201. Bitwise AND of Numbers Range

> 求二进制的公共前缀

```java
class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int bit = 0;
        while (left < right) {
            left = left >> 1;
            right = right >> 1;
            bit++;
        }
        return left << bit;
    }
}
```

### 231. Power of Two

```java
class Solution {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
```

### 260. Single Number III

> 分成bit位不同的两组

```java
class Solution {
    public int[] singleNumber(int[] nums) {
        int XOR = 0;
        for (int num : nums) {
            XOR ^= num;
        }
        int bit = XOR & -XOR;
        int g1 = 0;
        int g2 = 0;
        for (int num : nums) {
            if ((num & bit) == 0) {
                g1 ^= num;
            } else {
                g2 ^= num;
            }
        }
        return new int[]{g1, g2};
    }
}
```

### 268. Missing Number

```java
class Solution {
    public int missingNumber(int[] nums) {
        int XOR = 0;
        int m = nums.length;
        for (int i = 0; i <= m; i++) {
            XOR ^= i;
        }
        for (int i = 0; i < m; i++) {
            XOR ^= nums[i];
        }
        return XOR;
    }
}
```