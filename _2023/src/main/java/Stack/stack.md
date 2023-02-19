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