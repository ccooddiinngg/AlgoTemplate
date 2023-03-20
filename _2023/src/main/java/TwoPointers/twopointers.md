### 844. Backspace String Compare

> from right to left

```java
class Solution {
    public boolean backspaceCompare(String s, String t) {
        int m = s.length();
        int n = t.length();
        int i = m - 1;
        int i1 = 0;
        int j = n - 1;
        int j1 = 0;
        while (i >= 0 || j >= 0) {
            while (i >= 0 && s.charAt(i) == '#') {
                i1++;
                i--;
                while (i1 > 0 && i >= 0 && s.charAt(i) != '#') {
                    i1--;
                    i--;
                }
            }
            while (j >= 0 && t.charAt(j) == '#') {
                j1++;
                j--;
                while (j1 > 0 && j >= 0 && t.charAt(j) != '#') {
                    j1--;
                    j--;
                }
            }
            if (i >= 0 && j >= 0) {
                if (s.charAt(i) != t.charAt(j)) return false;
                i--;
                j--;
            } else if (i >= 0 || j >= 0) {
                return false;
            }
        }
        return true;
    }
}
```