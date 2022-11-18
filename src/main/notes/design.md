### 146 LRU 缓存
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
>双链表 + HashMap

### 155 最小栈
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

### 173 二叉搜索树迭代器
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

### 208 实现 Trie (前缀树)
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

### 211 添加与搜索单词 - 数据结构设计
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

### 225 用队列实现栈
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

### 232 用栈实现队列
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

### 284 顶端迭代器
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

### 295 数据流的中位数
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

### 297 二叉树的序列化与反序列化
```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return ser(root);
    }

    private String ser(TreeNode root) {
        if (root == null) {
            return "null";
        }
        return String.valueOf(root.val) + "," + ser(root.left) + "," + ser(root.right);
    }

    // Decodes your encoded data to tree.
    int idx = 0;
    public TreeNode deserialize(String data) {
        String[] str = data.split(",");
        return des(str);
    }

    private TreeNode des(String[] str) {
        if ("null".equals(str[idx])) {
            idx++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(str[idx++]));
        root.left = des(str);
        root.right = des(str);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
```
>前序遍历, 用逗号分隔, 空节点用null表示

### 307 区域和检索 - 数组可修改
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

### 341 扁平化嵌套列表迭代器
```java
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    List<Integer> list;
    Iterator<Integer> it;

    public NestedIterator(List<NestedInteger> nestedList) {
        this.list = new ArrayList<>();
        flat(nestedList, list);
        this.it = list.iterator();
    }

    private void flat(List<NestedInteger> nestedList, List<Integer> list) {
        for (NestedInteger ni: nestedList) {
            if (ni.isInteger()) {
                list.add(ni.getInteger());
            }else {
                flat(ni.getList(), list);
            }
        }
    }

    @Override
    public Integer next() {
        return it.next();
    }

    @Override
    public boolean hasNext() {
        return it.hasNext();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
```
>用list存储所有的整数, 然后用迭代器遍历

### 355 设计推特
```java
class Twitter {
    Map<Integer, User> map = new HashMap<>();
    public Twitter() {

    }

    private User getUser(int userId) {
        if (!map.containsKey(userId)) {
            map.put(userId, new User(userId));
        }
        return map.get(userId);
    }
    
    public void postTweet(int userId, int tweetId) {
        User user = getUser(userId);
        user.post(tweetId);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        User user = getUser(userId);
        return user.getNewsFeed(10);
    }
    
    public void follow(int followerId, int followeeId) {
        User follower = getUser(followerId);
        User followee = getUser(followeeId);
        follower.follow(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        User follower = getUser(followerId);
        User followee = getUser(followeeId);
        follower.unfollow(followeeId);
    }

    class User {
        int userId;
        Set<Integer> followees;
        Tweet head;

        public User(int userId) {
            this.userId = userId;
            this.followees = new HashSet<>();
            this.followees.add(userId);
            this.head = null;
        }

        public void follow(int followeeId) {
            followees.add(followeeId);
        }

        public void unfollow(int followeeId) {
            followees.remove(followeeId);
        }

        public void post(int tweetId) {
            Tweet tweet = new Tweet(this.userId, tweetId);
            tweet.next = head;
            head = tweet;
        }

        public List<Integer> getNewsFeed(int count) {
            List<Integer> list = new ArrayList<>();
            Queue<Tweet> q = new PriorityQueue<>((a, b) -> b.timestamp - a.timestamp);
            for (int followeeId: followees) {
                User followee = getUser(followeeId);
                if (followee.head != null) {
                    q.offer(followee.head);
                }
            }
            while (list.size() < count && !q.isEmpty()) {
                Tweet head = q.poll();
                list.add(head.tweetId);
                if (head.next != null) {
                    q.offer(head.next);
                }
            }
            return list;
        }
    }

    int time = 0;
    class Tweet {
        int tweetId;
        int userId;
        int timestamp;
        Tweet next;

        public Tweet(int userId, int tweetId) {
            this.userId = userId;
            this.tweetId = tweetId;
            this.timestamp = time++;
            this.next = null;
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
```
>用一个map存储所有的用户, 每个用户有一个set存储关注的人, 一个链表存储自己的推文, 每次获取新闻时, 遍历所有关注的人的链表, 把所有的推文放到一个优先队列中, 优先队列按照时间戳排序, 每次取一个, 然后把这个推文的下一个推文放到队列中, 直到取够10个或者队列为空

### 380 O(1) 时间插入、删除和获取随机元素
```java
class RandomizedSet {
    Map<Integer, Integer> map = new HashMap<>();
    int[] arr = new int[100000];
    int size = 0;

    public RandomizedSet() {

    }
    
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        arr[size] = val;
        map.put(val, size);
        size++;
        return true;
    }
    
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int idx = map.get(val);
        map.remove(val);
        if (idx != size - 1) {
            arr[idx] = arr[size - 1];  
            map.put(arr[idx], idx);
        }
        size--;
        return true;
    }
    
    public int getRandom() {
        int r = (int)(Math.random() * size);
        return arr[r];
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
```
>用一个map存储每个数的下标, 用一个数组存储所有的数, 每次删除时, 把最后一个数放到删除的位置, 然后更新map中最后一个数的下标
