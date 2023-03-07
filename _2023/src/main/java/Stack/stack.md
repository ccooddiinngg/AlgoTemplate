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
            //how many nums left: nums.length - 1 - i
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

### 331. Verify Preorder Serialization of a Binary Tree

```java
class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] p = preorder.split(",");
        Stack<String> stack = new Stack<>();
        int i = 0;
        while (i < p.length) {
            String str = p[i];
            if (str.equals("#")) {
                if (!stack.isEmpty() && stack.peek().equals("#")) {
                    stack.pop();
                    if (stack.isEmpty()) return false;
                    stack.pop();
                    continue;
                }
            }
            stack.push(str);
            i++;
        }
        return stack.size() == 1 && stack.pop().equals("#");
    }
}
```

### 341. Flatten Nested List Iterator

```java
import Stack.NestedInteger;

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

### 385. Mini Parser

```java
class Solution {
    public NestedInteger deserialize(String s) {
        int m = s.length();
        Stack<NestedInteger> stack = new Stack<>();
        NestedInteger head = new NestedInteger();
        int pre = 0;
        int sign = 1;
        for (int i = 0; i < m; i++) {
            char c = s.charAt(i);
            if (c == '[') {
                stack.push(new NestedInteger());
                stack.push(head);
            } else if (c == '-') {
                sign = -1;
            } else if (c == ']') {
                List<NestedInteger> list = new ArrayList<>();
                while (stack.peek() != head) {
                    list.add(stack.pop());
                }
                //pop head
                stack.pop();
                for (int j = list.size() - 1; j >= 0; j--) {
                    stack.peek().add(list.get(j));
                }
            } else if (Character.isDigit(c)) {
                pre = pre * 10 + c - '0';
                if (i == m - 1 || (i < m - 1 && !Character.isDigit(s.charAt(i + 1)))) {
                    stack.push(new NestedInteger(sign * pre));
                    pre = 0;
                    sign = 1;
                }
            }
        }
        return stack.pop();
    }
}
```

### 388. Longest Absolute File Path

> stack存储子树的head,当子树遍历结束后(发现节点的层级高于或等于head的层级),弹出head直到找到正确的head

```java
class Solution {
    public int lengthLongestPath(String input) {
        Stack<Node> stack = new Stack<>();
        String[] strs = input.split("\n");
        int max = -1;
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            int l = 0;
            while (l < str.length() && str.charAt(l) == '\t') {
                l++;
            }
            while (!stack.isEmpty() && stack.peek().level >= l) {
                stack.pop();
            }
            int len = (stack.isEmpty() ? 0 : stack.peek().len) + str.length() - l + 1;
            if (str.contains(".")) {
                max = Math.max(max, len);
            }
            stack.push(new Node(len, l));
        }
        return max == -1 ? 0 : max - 1;
    }

    class Node {
        int len;
        int level;

        public Node(int _len, int _level) {
            len = _len;
            level = _level;
        }
    }
}
```

### 394. Decode String

```java
class Solution {
    public String decodeString(String s) {
        int m = s.length();
        Stack<Integer> s1 = new Stack<>();
        Stack<StringBuilder> s2 = new Stack<>();
        int pre = 0;
        StringBuilder sb = new StringBuilder();
        s2.push(sb);
        for (int i = 0; i < m; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                pre = pre * 10 + c - '0';
                if (i < m - 1 && !Character.isDigit(s.charAt(i + 1))) {
                    s1.push(pre);
                    pre = 0;
                }
            } else if (Character.isLetter(c)) {
                s2.peek().append(c);
            } else if (c == '[') {
                s2.push(new StringBuilder());
            } else if (c == ']') {
                int k = s1.pop();
                StringBuilder t = s2.pop();
                StringBuilder nt = new StringBuilder();
                while (k > 0) {
                    nt.append(t);
                    k--;
                }
                s2.peek().append(nt);
            }
        }
        return s2.pop().toString();
    }
}
```

### 402. Remove K Digits

```java
class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Integer> stack = new Stack<>();
        int m = num.length();
        for (int i = 0; i < m; i++) {
            int d = num.charAt(i) - '0';
            while (!stack.isEmpty() && k > 0 && stack.peek() > d) {
                stack.pop();
                k--;
            }
            stack.push(d);
        }
        while (k > 0) {
            stack.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        while (sb.length() > 0 && sb.charAt(0) == '0') {
            sb.delete(0, 1);
        }
        if (sb.length() == 0) return "0";
        return sb.toString();
    }
}
```

### 445. Add Two Numbers II

> ArrayDeque instead of Stack

```java
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<Integer> s1 = new ArrayDeque<>();
        Deque<Integer> s2 = new ArrayDeque<>();
        int carry = 0;
        ListNode p1 = l1;
        ListNode p2 = l2;
        while (p1 != null) {
            s1.push(p1.val);
            p1 = p1.next;
        }
        while (p2 != null) {
            s2.push(p2.val);
            p2 = p2.next;
        }
        ListNode pre = null;
        while (!s1.isEmpty() || !s2.isEmpty() || carry != 0) {
            int a = s1.isEmpty() ? 0 : s1.pop();
            int b = s2.isEmpty() ? 0 : s2.pop();
            int c = a + b + carry;
            carry = c / 10;
            ListNode node = new ListNode(c % 10);
            node.next = pre;
            pre = node;
        }
        return pre;
    }
}
```

### 456. 132 Pattern

> 从后向前枚举one，栈内元素为Three，弹出的最大值为Two
> [3,5,0,3,4]
> i=3 4>> MIN
> i=2 0,3,4>> MIN
> i=1 5>> 4
> i=0 TRUE

```java
class Solution {
    public boolean find132pattern(int[] nums) {
        int m = nums.length;
        Deque<Integer> s = new ArrayDeque<>();
        s.push(nums[m - 1]);
        int two = Integer.MIN_VALUE;
        // 遍历one, 栈顶为Three
        for (int i = m - 2; i >= 0; i--) {
            if (nums[i] < two) return true;
            while (!s.isEmpty() && s.peek() < nums[i]) {
                two = s.pop();
            }
            s.push(nums[i]);
        }
        return false;
    }
}
```

### 921. Minimum Add to Make Parentheses Valid

```java
class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }
        return stack.size();
    }
}
```

```java
class Solution {
    public int minAddToMakeValid(String s) {
        int l = 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                l++;
            } else {
                //消掉一个l
                if (l > 0) {
                    l--;
                } else {
                    //需要补一个左括号
                    count++;
                }
            }
        }
        //需要补几个右括号
        count += l;
        return count;
    }
}
```

### 1021. Remove Outermost Parentheses

```java
class Solution {
    public String removeOuterParentheses(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ')') {
                stack.pop();
            }
            //如果栈为空, 表示是最外面一层括号, 不计入结果
            if (!stack.isEmpty()) {
                sb.append(c);
            }
            if (c == '(') {
                stack.push(c);
            }
        }
        return sb.toString();
    }
}
```

```java
class Solution {
    public String removeOuterParentheses(String s) {
        int l = 0;
        int r = 0;
        int start = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ')') {
                r++;
            } else {
                l++;
            }
            //找到一组Primitive
            if (l == r) {
                sb.append(s, start + 1, i);
                l = 0;
                r = 0;
                start = i + 1;
            }
        }
        return sb.toString();
    }
}
```