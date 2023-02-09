### 29. Divide Two Integers

```java
class Solution {
    int MIN = Integer.MIN_VALUE, MAX = Integer.MAX_VALUE;
    int HALF = -1073741824; // MIN 的一半

    public int divide(int a, int b) {
        if (a == MIN && b == -1) return MAX;
        boolean sign = (a > 0 && b > 0) || (a < 0 && b < 0);
        if (a > 0) a = -a;
        if (b > 0) b = -b;
        int ans = helper(a, b);
        return sign ? ans : -ans;
    }

    //a, b both negative
    public int helper(int a, int b) {
        if (a > b) return 0;
        int res = 1;
        int b1 = b;
        while (b1 >= HALF && b1 + b1 >= a) {
            b1 += b1;
            res += res;
        }
        return res + helper(a - b1, b);
    }
}
```

### 67. Add Binary

```java
class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int m = a.length();
        int n = b.length();
        int i = m - 1;
        int j = n - 1;
        int carry = 0;
        while (i >= 0 || j >= 0 || carry > 0) {
            int x = i >= 0 ? a.charAt(i) - '0' : 0;
            int y = j >= 0 ? b.charAt(j) - '0' : 0;
            int z = x + y + carry;
            sb.insert(0, z % 2);
            carry = z / 2;
            i--;
            j--;
        }
        return sb.toString();
    }
}
```