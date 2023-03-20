### 225. Implement Stack using Queues

```java
class MyStack {
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    public MyStack() {

    }

    public void push(int x) {
        q1.offer(x);
    }

    private void move1() {
        while (q1.size() > 1) {
            q2.offer(q1.poll());
        }
    }

    private void move2() {
        while (!q2.isEmpty()) {
            q1.offer(q2.poll());
        }
    }

    public int pop() {
        if (empty()) throw new NullPointerException();
        move1();
        int t = q1.poll();
        move2();
        return t;
    }

    public int top() {
        int t = pop();
        push(t);
        return t;
    }

    public boolean empty() {
        return q1.isEmpty();
    }
}
```

### 232. Implement Queue using Stacks

```java
class MyQueue {
    Deque<Integer> s1 = new ArrayDeque<>();
    Deque<Integer> s2 = new ArrayDeque<>();

    public MyQueue() {

    }

    public void push(int x) {
        s1.push(x);
    }

    private void move1() {
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
    }

    private void move2() {
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }

    public int pop() {
        if (empty()) throw new NullPointerException();
        move1();
        int t = s2.pop();
        move2();
        return t;
    }

    public int peek() {
        if (empty()) throw new NullPointerException();
        move1();
        int t = s2.peek();
        move2();
        return t;
    }

    public boolean empty() {
        return s1.isEmpty();
    }
}
```

### 239. Sliding Window Maximum

```java
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        LinkedList<Integer> q = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        int idx = 0;
        int i = 0;
        int j = 0;
        while (j < nums.length) {
            while (!q.isEmpty() && nums[q.peekLast()] < nums[j]) {
                q.pollLast();
            }
            q.offer(j);
            if (j >= k) {
                if (i == q.peekFirst()) {
                    q.pollFirst();
                }
                i++;
            }
            if (j >= k - 1) {
                res[idx++] = nums[q.peekFirst()];
            }
            j++;
        }
        return res;
    }
}
```