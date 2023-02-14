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

### 338. Counting Bits

```java
class Solution {
    public int[] countBits(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            if ((i & 1) == 0) {
                dp[i] = dp[i >> 1];
            } else {
                dp[i] = dp[i - 1] + 1;
            }
        }
        return dp;
    }
}
```

### 371. Sum of Two Integers

```java
class Solution {
    public int getSum(int a, int b) {
        if (b == 0) return a;
        return getSum(a ^ b, (a & b) << 1);
    }
}
```

### 401. Binary Watch

```java
class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> list = new ArrayList<>();
        int[] dp = count(60);
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 60; j++) {
                if (dp[i] + dp[j] == turnedOn) {
                    list.add(toString(i, j));
                }
            }
        }
        return list;
    }

    int[] count(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            if ((i & 1) == 1) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = dp[i >> 1];
            }
        }
        return dp;
    }

    String toString(int i, int j) {
        StringBuilder sb = new StringBuilder();
        String min = j == 0 ? "00" : j < 10 ? "0" + j : "" + j;
        return sb.append(i).append(':').append(min).toString();
    }
}
```

```java
class Solution {

    public List<String> readBinaryWatch(int turnedOn) {
        int H = 4;
        int M = 6;
        List<String> list = new ArrayList<>();
        for (int i = 0; i < H && i <= turnedOn; i++) {
            List<Integer> hours = new ArrayList<>();
            dfs(i, H - 1, 0, hours, 11);
            List<Integer> mins = new ArrayList<>();
            dfs(turnedOn - i, M - 1, 0, mins, 59);
            for (int h : hours) {
                for (int m : mins) {
                    list.add(toString(h, m));
                }
            }
        }
        return list;
    }

    //0000
    //000000
    void dfs(int count, int idx, int path, List<Integer> list, int max) {
        if (path > max) return;
        if (count == 0) {
            list.add(path);
            return;
        }
        if (count < 0 || idx == -1) return;
        dfs(count - 1, idx - 1, path + (1 << idx), list, max);
        dfs(count, idx - 1, path, list, max);
    }

    String toString(int hour, int min) {
        StringBuilder sb = new StringBuilder();
        String m = min == 0 ? "00" : min < 10 ? "0" + min : min + "";
        sb.append(hour).append(":").append(m);
        return sb.toString();
    }
}
```

### 421. Maximum XOR of Two Numbers in an Array

```java
class Solution {
    public int findMaximumXOR(int[] nums) {
        int max = 0;
        for (int num : nums) {
            insert(num);
            Node p = root;
            int res = 0;
            for (int i = 30; i >= 0; i--) {
                int bit = (num >> i & 1);
                if (p.next[1 - bit] != null) {
                    res += 1 << i;
                    p = p.next[1 - bit];
                } else {
                    p = p.next[bit];
                }
            }
            max = Math.max(max, res);
        }
        return max;
    }

    Node root = new Node();

    class Node {
        Node[] next;

        public Node() {
            next = new Node[2];
        }
    }

    void insert(int num) {
        Node p = root;
        for (int i = 30; i >= 0; i--) {
            int bit = (num >> i & 1);
            if (p.next[bit] == null) {
                p.next[bit] = new Node();
            }
            p = p.next[bit];
        }
    }


}
```

### 461. Hamming Distance

```java
class Solution {
    public int hammingDistance(int x, int y) {
        int dis = 0;
        for (int i = 0; i < 32; i++) {
            if ((x >> i & 1) != (y >> i & 1)) {
                dis++;
            }
        }
        return dis;
    }
}
```

### 464. Can I Win

> state 确定的话 curr也就确定了， 所以cache不需要二维数组

```java
class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (desiredTotal == 0) return true;
        if ((1 + maxChoosableInteger) * maxChoosableInteger / 2 < desiredTotal) {
            return false;
        }
        cache = new int[1 << maxChoosableInteger];
        return dfs(maxChoosableInteger, desiredTotal, 0, 0);
    }

    int[] cache;

    public boolean dfs(int maxChoosableInteger, int desiredTotal, int curr, int state) {
        if (cache[state] != 0) return cache[state] == 1;
        for (int i = 0; i < maxChoosableInteger; i++) {
            if ((state >> i & 1) == 0) {
                if (curr + (i + 1) >= desiredTotal || !dfs(maxChoosableInteger, desiredTotal, curr + (i + 1), state + (1 << i))) {
                    cache[state] = 1;
                    return true;
                }
            }
        }
        cache[state] = 2;
        return false;
    }
}
```

### 476. Number Complement

```java
class Solution {
    public int findComplement(int num) {
        int i = 31;
        while ((num >> i & 1) == 0) {
            i--;
        }
        return ~num << (31 - i) >> (31 - i);
    }
}
```

### 477. Total Hamming Distance

> 所有数在i位置上为1的个数*为0的个数， 就是在这个位置上贡献的HammingDistance

```java
class Solution {
    public int totalHammingDistance(int[] nums) {
        int m = nums.length;
        int sum = 0;
        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int num : nums) {
                if ((num >> i & 1) == 0) {
                    count++;
                }
            }
            sum += count * (m - count);
        }
        return sum;
    }
}
```

### 762. Prime Number of Set Bits in Binary Representation

```java
class Solution {
    public int countPrimeSetBits(int left, int right) {
        int[] dp = new int[right + 1];
        for (int i = 1; i < right + 1; i++) {
            if ((i & 1) == 0) {
                dp[i] = dp[i >> 1];
            } else {
                dp[i] = dp[i - 1] + 1;
            }
        }
        Set<Integer> set = getPrime(32);
        int count = 0;
        for (int i = left; i <= right; i++) {
            if (set.contains(dp[i])) {
                count++;
            }
        }
        return count;
    }

    Set<Integer> getPrime(int n) {
        Set<Integer> set = new HashSet<>();
        if (n < 2) return set;
        boolean[] p = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            if (!p[i]) {
                set.add(i);
                for (int j = 2; j * i < n + 1; j++) {
                    p[j * i] = true;
                }
            }
        }
        return set;
    }
}
```

```java
class Solution {
    public int countPrimeSetBits(int left, int right) {
        int count = 0;
        for (int i = left; i <= right; i++) {
            int c = count(i);
            // System.out.println(c);
            if (isPrime(c)) {
                count++;
            }
        }
        return count;
    }

    int count(int i) {
        int res = 0;
        while (i != 0) {
            i = i & (i - 1);
            res++;
        }
        return res;
    }

    boolean isPrime(int i) {
        if (i < 2) return false;
        // <=
        for (int j = 2; j <= i / j; j++) {
            if (i % j == 0) return false;
        }
        return true;
    }
}
```

### 1009. Complement of Base 10 Integer

```java
class Solution {
    public int bitwiseComplement(int n) {
        int f1 = 31;
        while ((n >> f1 & 1) == 0 && f1 > 0) {
            f1--;
        }
        return ~n << (31 - f1) >>> (31 - f1);
    }
}
```