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

### 622. Design Circular Queue

```java
class MyCircularQueue {
    int[] nums;
    int k;
    int size;
    int end;


    public MyCircularQueue(int k) {
        this.k = k;
        nums = new int[k];
        size = 0;
        end = 0;
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        nums[end] = value;
        end = (end + 1) % k;
        size++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        size--;
        return true;
    }

    public int Front() {
        if (isEmpty()) return -1;
        int f = (end - size + k) % k;
        return nums[f];
    }

    public int Rear() {
        if (isEmpty()) return -1;
        int e = (end - 1 + k) % k;
        return nums[e];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == k;
    }
}
```

### 641. Design Circular Deque

```java
class MyCircularDeque {

    class Node {
        int val;
        Node pre;
        Node next;

        public Node(int _val) {
            val = _val;
        }
    }

    int k;
    int size;
    Node head;
    Node tail;

    public MyCircularDeque(int k) {
        this.k = k;
        size = 0;
        head = new Node(-1);
        tail = new Node(-1);
        head.next = tail;
        tail.pre = head;
    }

    public boolean insertFront(int value) {
        if (isFull()) return false;
        Node node = new Node(value);
        node.next = head.next;
        node.next.pre = node;
        head.next = node;
        node.pre = head;
        size++;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) return false;
        Node node = new Node(value);
        node.pre = tail.pre;
        node.pre.next = node;
        node.next = tail;
        tail.pre = node;
        size++;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) return false;
        head.next = head.next.next;
        head.next.pre = head;
        size--;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) return false;
        tail.pre = tail.pre.pre;
        tail.pre.next = tail;
        size--;
        return true;
    }

    public int getFront() {
        return head.next.val;
    }

    public int getRear() {
        return tail.pre.val;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == k;
    }
}
```

### 649. Dota2 Senate

```java
class Solution {
    public String predictPartyVictory(String senate) {
        int m = senate.length();
        Queue<Integer> R = new LinkedList<>();
        Queue<Integer> D = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            if (senate.charAt(i) == 'R') {
                R.offer(i);
            } else {
                D.offer(i);
            }
        }
        while (!R.isEmpty() && !D.isEmpty()) {
            int ri = R.poll(), di = D.poll();
            if (ri < di) {
                R.offer(ri + m);
            } else {
                D.offer(di + m);
            }
        }
        return D.isEmpty() ? "Radiant" : "Dire";
    }
}
```

### 862. Shortest Subarray with Sum at Least K

> 前缀和
> 单调队列:
> nums: [84,-37,32,40,95], k = 167
> preSum: [84, 47, 79, 119, 214]
> q: [84]
> q: [~~84~~, 47]
> q: [47, 79]
> q: [47, 79, 119]
> q: [~~47~~, 79, 119, 214]

```java
class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int m = nums.length;
        LinkedList<Integer> q = new LinkedList<>();
        long[] pre = new long[m + 1];
        for (int i = 1; i < m + 1; i++) {
            pre[i] = pre[i - 1] + nums[i - 1];
        }
        long min = Long.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < m + 1; i++) {
            while (!q.isEmpty() && pre[i] - pre[q.peekFirst()] >= k) {
                min = Math.min(min, i - q.peekFirst());
                q.pollFirst();
            }
            while (!q.isEmpty() && pre[i] <= pre[q.peekLast()]) {
                q.pollLast();
            }
            q.offerLast(i);
        }
        return min == Long.MAX_VALUE ? -1 : (int) min;
    }
}
```