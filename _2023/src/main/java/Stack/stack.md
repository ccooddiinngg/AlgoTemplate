### 71. Simplify Path

```java
class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] p = path.split("\\/");
        for (int i = 0; i < p.length; i++) {
            if (p[i].equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!p[i].equals(".") && !p[i].equals("")) {
                stack.push(p[i]);
            }
        }
        StringBuilder sb = new StringBuilder();
        if (!stack.isEmpty()) {
            while (!stack.isEmpty()) {
                sb.insert(0, "/" + stack.pop());
            }
        } else {
            sb.append("/");
        }
        return sb.toString();
    }
}
```

### 84. Largest Rectangle in Histogram

> heights[i] 为最高点时产生的面积， 左右找到比它低的最近的点

```java
class Solution {
    public int largestRectangleArea(int[] heights) {
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                int idx = stack.pop();
                int left = stack.isEmpty() ? -1 : stack.peek();
                max = Math.max(max, heights[idx] * (i - left - 1));
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int idx = stack.pop();
            int left = stack.isEmpty() ? -1 : stack.peek();
            max = Math.max(max, heights[idx] * (heights.length - left - 1));
        }
        return max;
    }
}
```

### 85. Maximal Rectangle

```java
class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] mat = new int[m][n];
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '0') {
                    mat[i][j] = 0;
                } else {
                    mat[i][j] = 1;
                    if (i > 0) {
                        mat[i][j] += mat[i - 1][j];
                    }
                }
            }
            max = Math.max(max, getMax(mat[i]));
        }
        return max;
    }

    int getMax(int[] height) {
        int m = height.length;
        int[] dp = new int[m];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < m; i++) {
            while (!stack.isEmpty() && height[stack.peek()] > height[i]) {
                int idx = stack.pop();
                int left = stack.isEmpty() ? -1 : stack.peek();
                dp[idx] = height[idx] * (i - left - 1);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int idx = stack.pop();
            int left = stack.isEmpty() ? -1 : stack.peek();
            dp[idx] = height[idx] * (m - left - 1);
        }
        int max = 0;
        for (int v : dp) {
            max = Math.max(max, v);
        }
        return max;
    }
}
```

### 150. Evaluate Reverse Polish Notation

```java
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            String str = tokens[i];
            if ("+-*/".contains(str)) {
                int b = s.pop();
                int a = s.pop();
                int c = 0;
                switch (str) {
                    case "+":
                        c = a + b;
                        break;
                    case "-":
                        c = a - b;
                        break;
                    case "*":
                        c = a * b;
                        break;
                    case "/":
                        c = a / b;
                        break;
                    default:
                        break;
                }
                s.push(c);
            } else {
                s.push(Integer.parseInt(str));
            }
        }
        return s.pop();
    }
}
```

### 224. Basic Calculator

> 例外(-1+1)：在数字栈里没有数字但出现-号，预先在数字栈里放0
> 例外(1)：遇到')'但符号栈里没有符号，检查栈里是否为'('，再eval，否则直接消掉'('

```java
class Solution {
    public int calculate(String s) {
        String str = s.replace(" ", "");
        int m = str.length();
        Stack<Integer> s1 = new Stack<>();
        s1.push(0);
        Stack<Character> s2 = new Stack<>();
        int pre = 0;
        for (int i = 0; i < m; i++) {
            char c = str.charAt(i);
            if (Character.isDigit(c)) {
                pre = pre * 10 + c - '0';
                if (i == m - 1 || (i < m - 1 && !Character.isDigit(str.charAt(i + 1)))) {
                    s1.push(pre);
                    pre = 0;
                }
            } else {
                if (c == '(') {
                    s2.push('(');
                    if (i < m - 1 && str.charAt(i + 1) == '-') {
                        s1.push(0);
                    }
                } else if (c == ')') {
                    if (s2.peek() != '(') {
                        eval(s1, s2);
                    }
                    s2.pop();
                } else {
                    if (!s2.isEmpty() && s2.peek() != '(') {
                        eval(s1, s2);
                    }
                    s2.push(c);
                }

            }
        }
        eval(s1, s2);
        return s1.pop();
    }

    void eval(Stack<Integer> s1, Stack<Character> s2) {
        if (s2.isEmpty()) return;
        int b = s1.pop();
        int a = s1.pop();
        int c = 0;
        Character op = s2.pop();
        switch (op) {
            case '+' -> c = a + b;
            case '-' -> c = a - b;
            default -> {
            }
        }
        s1.push(c);
    }
}
```

### 227. Basic Calculator II

```java
class Solution {
    public int calculate(String s) {
        Map<Character, Integer> map = Map.of('+', 0, '-', 0, '*', 1, '/', 1);
        String str = s.replace(" ", "");
        int m = str.length();
        Stack<Integer> s1 = new Stack<>();
        Stack<Character> s2 = new Stack<>();
        int pre = 0;
        for (int i = 0; i < m; i++) {
            char c = str.charAt(i);
            if (Character.isDigit(c)) {
                pre = pre * 10 + c - '0';
                if (i == m - 1 || (i < m - 1 && !Character.isDigit(str.charAt(i + 1)))) {
                    s1.push(pre);
                    pre = 0;
                }
            } else {
                while (!s2.isEmpty() && map.get(c) <= map.get(s2.peek())) {
                    eval(s1, s2);
                }
                s2.push(c);
            }
        }
        while (!s2.isEmpty()) {
            eval(s1, s2);
        }
        return s1.pop();
    }

    public void eval(Stack<Integer> s1, Stack<Character> s2) {
        int b = s1.pop();
        int a = s1.pop();
        int c = 0;
        char op = s2.pop();
        switch (op) {
            case '+' -> c = a + b;
            case '-' -> c = a - b;
            case '*' -> c = a * b;
            case '/' -> c = a / b;
            default -> {
            }
        }
        s1.push(c);
    }
}
```

### 234. Palindrome Linked List

```java
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode h2 = slow.next;
        slow.next = null;
        ListNode pre = null;
        ListNode p2 = h2;
        ListNode next = h2.next;
        while (next != null) {
            p2.next = pre;
            pre = p2;
            p2 = next;
            next = next.next;
        }
        p2.next = pre;
        ListNode p1 = head;
        while (p2 != null) {
            if (p2.val != p1.val) return false;
            p2 = p2.next;
            p1 = p1.next;
        }
        return true;
    }
}
```

### 316. Remove Duplicate Letters

```java
class Solution {
    public String removeDuplicateLetters(String s) {
        char[] chars = s.toCharArray();
        //后面还有几个可以选的
        int[] count = new int[26];
        for (int i = 0; i < chars.length; i++) {
            count[chars[i] - 'a']++;
        }
        int state = 0;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            //没选过
            if ((state >> (chars[i] - 'a') & 1) == 0) {
                state |= 1 << (chars[i] - 'a');
                //把可以顶掉的去掉
                while (!stack.isEmpty() && stack.peek() > chars[i] && count[stack.peek() - 'a'] > 0) {
                    char t = stack.pop();
                    state -= 1 << (t - 'a');
                }
                stack.push(chars[i]);
            }
            count[chars[i] - 'a']--;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        return sb.toString();
    }
}
```

### 321. Create Maximum Number

> nums1[5, 0]
> nums2[5, 0, 2]
> merge(nums1, nums2) => [5, 5, 0, 2, 0]

```java
class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] nums = null;
        for (int i = Math.max(0, k - nums2.length); i <= Math.min(nums1.length, k); i++) {
            int j = k - i;
            int[] ans = merge(maxNum(nums1, i), maxNum(nums2, j));
            if (nums == null || compare(nums, 0, ans, 0) < 0) {
                nums = Arrays.copyOf(ans, ans.length);
            }
        }
        return nums;
    }

    int[] maxNum(int[] nums, int k) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            //how many nums i have: nums.length - 1 - i
            while (!stack.isEmpty() && stack.peek() < nums[i] && (nums.length - 1 - i + stack.size() >= k)) {
                stack.pop();
            }
            stack.push(nums[i]);
        }
        int[] ans = new int[k];
        int idx = k - 1;
        while (stack.size() > k) {
            stack.pop();
        }
        while (!stack.isEmpty()) {
            ans[idx--] = stack.pop();
        }
        return ans;
    }

    int[] merge(int[] a, int[] b) {
        int[] ans = new int[a.length + b.length];
        int idx = 0;
        int i = 0;
        int j = 0;
        while (i < a.length && j < b.length) {
            if (compare(a, i, b, j) > 0) {
                ans[idx++] = a[i++];
            } else {
                ans[idx++] = b[j++];
            }
        }
        while (i < a.length) {
            ans[idx++] = a[i++];
        }
        while (j < b.length) {
            ans[idx++] = b[j++];
        }
        return ans;
    }

    //compare arr starts from i, j
    int compare(int[] a, int i, int[] b, int j) {
        while (i < a.length && j < b.length) {
            if (a[i] > b[j]) return 1;
            if (a[i] < b[j]) return -1;
            i++;
            j++;
        }
        return (a.length - i) - (b.length - j);
    }
}
```

### 341. Flatten Nested List Iterator

```java
public class NestedIterator implements Iterator<Integer> {
    Stack<NestedInteger> stack;

    public NestedIterator(List<NestedInteger> nestedList) {
        this.stack = new Stack<>();
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            stack.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        return hasNext() ? stack.pop().getInteger() : -1;
    }

    @Override
    public boolean hasNext() {
        if (stack.isEmpty()) return false;
        NestedInteger nestedInteger = stack.peek();
        if (nestedInteger.isInteger()) {
            return true;
        } else {
            nestedInteger = stack.pop();
            List<NestedInteger> nestedList = nestedInteger.getList();
            for (int i = nestedList.size() - 1; i >= 0; i--) {
                stack.push(nestedList.get(i));
            }
            return hasNext();
        }
    }
}
```