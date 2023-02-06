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