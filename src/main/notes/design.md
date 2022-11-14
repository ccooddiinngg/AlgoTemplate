### 146LRU 缓存
```java
class LRUCache {

    Map<Integer, Node> map;
    int capacity;
    Node head;
    Node tail;

    class Node {
        int key;
        int val;
        Node pre;
        Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.pre = null;
            this.next = null;
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        this.head.next = tail;
        this.tail.pre = head;
    }
    
    void addNode(Node node) {
        node.next = head.next;
        head.next = node;
        node.next.pre = node;
        node.pre = head;
    }

    void removeNode(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    Node getNode(int key) {
        return map.get(key);
    }

    boolean isFull() {
        return map.size() == capacity;
    }

    public int get(int key) {
        Node node = getNode(key);
        if (node == null) {
            return -1;
        }
        removeNode(node);
        addNode(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = getNode(key);
            node.val = value;
            removeNode(node);
            addNode(node);
            return;
        }
        if (isFull()) {
            Node node = tail.pre;
            map.remove(node.key);
            removeNode(node);
        }
        Node node = new Node(key, value);
        map.put(key, node);
        addNode(node);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
```

### 155最小栈
```java
class MinStack {
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    public MinStack() {

    }
    
    public void push(int val) {
        s1.push(val);
        if (s2.isEmpty() || s2.peek() > val) {
            s2.push(val);
        }else {
            s2.push(s2.peek());
        }
    }
    
    public void pop() {
        if (s1.isEmpty()) {
            throw new NullPointerException();
        }
        s1.pop();
        s2.pop();
    }
    
    public int top() {
        if (s1.isEmpty()) {
            throw new NullPointerException();
        }
        return s1.peek();
    }
    
    public int getMin() {
        if (s1.isEmpty()) {
            throw new NullPointerException();
        }
        return s2.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
```

### 173二叉搜索树迭代器
```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BSTIterator {
    Stack<TreeNode> stack = new Stack<>();
    TreeNode p;

    public BSTIterator(TreeNode root) {
        this.p = root;
    }
    
    public int next() {
        while (p != null) {
            stack.push(p);
            p = p.left;
        }
        p = stack.pop();
        int res = p.val;
        p = p.right;
        return res;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty() || p != null;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
```

### 208实现 Trie (前缀树)
```java
class Trie {
    Node root;

    class Node {
        Node[] next;
        boolean isEnd;

        public Node() {
            next = new Node[26];
            isEnd = false;
        }
    }
    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node p = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (p.next[idx] == null) {
                p.next[idx] = new Node();
            }
            p = p.next[idx];
        }
        p.isEnd = true;
    }

    private Node getNode(String prefix) {
        Node p = root;
        for (int i = 0; i < prefix.length(); i++) {
            int idx = prefix.charAt(i) - 'a';
            if (p.next[idx] == null) {
                return null;
            }
            p = p.next[idx];
        }
        return p;
    }
    
    public boolean search(String word) {
        Node p = getNode(word);
        return  p!= null && p.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        return getNode(prefix) != null;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
```

### 211添加与搜索单词 - 数据结构设计
```java
class WordDictionary {
    Trie root;

    public WordDictionary() {
        this.root = new Trie();
    }
    
    public void addWord(String word) {
        Trie p = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (p.next[idx] == null) {
                p.next[idx] = new Trie();
            }
            p = p.next[idx];
        }
        p.isEnd = true;
    }
    
    private boolean _search(String word, Trie p) {
        if (p == null) {
            return false;
        }
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == '.') {
                for (int j = 0; j < p.next.length; j++) {
                    if (_search(word.substring(i + 1), p.next[j])) {
                        return true;
                    }
                }
                return false;
            }else {
                int idx = word.charAt(i) - 'a';
                if (p.next[idx] == null) {
                    return false;
                }
                p = p.next[idx];
            }
        }
        return p.isEnd;
    }

    public boolean search(String word) {
        Trie p = root;
        return _search(word, p);
    }

    class Trie {
        Trie[] next;
        boolean isEnd;

        public Trie() {
            this.next = new Trie[26];
            this.isEnd = false;
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
```

### 225用队列实现栈
```java
class MyStack {
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    public MyStack() {

    }
    
    public void push(int x) {
        q1.offer(x);
    }
    
    private void q2ToQ1() {
        while (!q2.isEmpty()) {
            q1.offer(q2.poll());
        }
    }

    private void q1ToQ2() {
        if (q1.isEmpty()) {
            q2ToQ1();
        }
        while (q1.size() > 1) {
            q2.offer(q1.poll());
        }
    }

    public int pop() {
        q1ToQ2();
        return q1.poll();
    }
    
    public int top() {
        q1ToQ2();
        return q1.peek();
    }
    
    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
```
>放的时候, 直接放入q1, 取得时候, q1ToQ2, (只有q1为空的时候, 才会把q2的元素放到q1中), 保证q1中只有一个元素, 即为栈顶元素

### 232用栈实现队列
```java
class MyQueue {
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    public MyQueue() {

    }
    
    public void push(int x) {
        s1.push(x);
    }

    private void s1ToS2() {
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
    }
    
    public int pop() {
        if(s2.isEmpty()) {
            s1ToS2();
        }
        return s2.pop();
    }
    
    public int peek() {
        if(s2.isEmpty()) {
            s1ToS2();
        }
        return s2.peek();
    }
    
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
```
>放的时候, 直接放入s1, 取得时候, 从s2中取, (只有s2为空的时候, 才会把s1的元素全部放到s2中)

### 284顶端迭代器
```java
// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {
    Iterator<Integer> it;
    Integer next;

	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    this.it = iterator;
        next = this.it.next();
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return next;
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
        int res = next;
	    next = it.hasNext() ? it.next():null;
        return res;
	}
	
	@Override
	public boolean hasNext() {
	    return next != null;
	}
}
```
>预读取下一个元素, 用一个变量保存, next()的时候, 直接返回这个变量, 然后再预读取下一个元素

### 295数据流的中位数
```java
class MedianFinder {
    Queue<Integer> q1 = new PriorityQueue<>((a, b) -> b - a);
    Queue<Integer> q2 = new PriorityQueue<>();

    public MedianFinder() {

    }
    
    public void addNum(int num) {
        if (q2.isEmpty() || q2.peek() <= num) {
            q2.offer(num);
            if (q2.size() > q1.size() + 1) {
            q1.offer(q2.poll());
        }
        }else {
            q1.offer(num);
            if (q1.size() > q2.size()) {
                q2.offer(q1.poll());
            }
        }
        
    }
    
    public double findMedian() {
        if (q1.size() == 0 && q2.size() == 0) throw new NullPointerException();
        return q1.size() == q2.size() ? (q1.peek() + q2.peek()) / 2.0:q2.peek();  
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
```
>保证q2的size不会比q1大1, q1的size不会比q2大

### 307区域和检索 - 数组可修改
```java
class NumArray {
    int n;
    int[] bit;
    int[] nums;

    public NumArray(int[] nums) {
        this.n = nums.length;
        this.nums = new int[n + 1];
        this.bit = new int[n + 1];
        for (int i = 0; i < nums.length; i++) {
            update(i, nums[i]);
        }
    }

    private int lowBit(int x) {
        return x & -x;
    }
    
    private int ask(int index) {
        int i = index + 1;
        int sum = 0;
        while (i > 0) {
            sum += bit[i];
            i -= lowBit(i);
        }
        return sum;
    }
    
    public void update(int index, int val) {
        int i = index + 1;
        int offset = val - nums[i];
        nums[i] = val;
        while (i <= n) {
            bit[i] += offset;
            i += lowBit(i);
        }
    }
    
    public int sumRange(int left, int right) {
        return ask(right) - ask(left - 1);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
```

