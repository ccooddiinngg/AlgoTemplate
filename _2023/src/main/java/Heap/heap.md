### 23. Merge k Sorted Lists

```java
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> q = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode head : lists) {
            if (head != null) {
                q.offer(head);
            }
        }
        ListNode dummy = new ListNode();
        ListNode p = dummy;
        while (!q.isEmpty()) {
            ListNode node = q.poll();
            p.next = node;
            p = p.next;
            if (node.next != null) {
                q.offer(node.next);
            }
        }
        return dummy.next;
    }
}
```

### 218. The Skyline Problem

> 用优先队列存储高度

```java
class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        int m = buildings.length;
        List<Node> bs = new ArrayList<>();
        for (int[] b : buildings) {
            bs.add(new Node(b[0], b[2], true));
            bs.add(new Node(b[1], b[2], false));
        }
        Collections.sort(bs, (a, b) -> a.x - b.x);
        List<List<Integer>> list = new ArrayList<>();
        Queue<Integer> q = new PriorityQueue<>((a, b) -> b - a);
        q.offer(0);
        int i = 0;
        int pre = 0;
        while (i < bs.size()) {
            int j = i;
            while (j < bs.size() && bs.get(j).x == bs.get(i).x) {
                if (bs.get(j).in) {
                    q.offer(bs.get(j).h);
                } else {
                    q.remove(bs.get(j).h);
                }
                j++;
            }
            if (q.peek() != pre) {
                List<Integer> l = List.of(bs.get(i).x, q.peek());
                list.add(l);
                pre = q.peek();
            }
            i = j;
        }
        return list;
    }

    class Node {
        int x;
        int h;
        boolean in;

        public Node(int _x, int _h, boolean _in) {
            x = _x;
            h = _h;
            in = _in;
        }
    }
}
```

### 264. Ugly Number II

```java
class Solution {
    public int nthUglyNumber(int n) {
        Queue<Long> q = new PriorityQueue<>();
        q.offer(1L);
        Set<Long> set = new HashSet<>();
        set.add(1L);
        int count = 0;
        long ans = 0;
        while (count < n) {
            ans = q.poll();
            if (!set.contains(ans * 2)) {
                q.offer(ans * 2);
                set.add(ans * 2);
            }
            if (!set.contains(ans * 3)) {
                q.offer(ans * 3);
                set.add(ans * 3);
            }
            if (!set.contains(ans * 5)) {
                q.offer(ans * 5);
                set.add(ans * 5);
            }
            count++;
        }
        return (int) ans;
    }
}
```

### 295. Find Median from Data Stream

```java
class MedianFinder {
    Queue<Integer> q1 = new PriorityQueue<>((a, b) -> b - a);
    Queue<Integer> q2 = new PriorityQueue<>();

    public MedianFinder() {

    }

    public void addNum(int num) {
        if (!q2.isEmpty() && num >= q2.peek()) {
            q2.offer(num);
            if (q2.size() > q1.size()) {
                q1.offer(q2.poll());
            }
        } else {
            q1.offer(num);
            if (q1.size() > q2.size() + 1) {
                q2.offer(q1.poll());
            }
        }
    }

    public double findMedian() {
        return q1.size() == q2.size() ? (q1.peek() + q2.peek()) / 2.0 : q1.peek();
    }
}
```

### 355. Design Twitter

```java
class Twitter {
    Map<Integer, User> map = new HashMap<>();

    User getUser(int userId) {
        if (!map.containsKey(userId)) {
            map.put(userId, new User(userId));
        }
        return map.get(userId);
    }

    public Twitter() {

    }

    public void postTweet(int userId, int tweetId) {
        User user = getUser(userId);
        user.post(tweetId);
    }

    public List<Integer> getNewsFeed(int userId) {
        User user = getUser(userId);
        return user.getNewsFeed();
    }

    public void follow(int followerId, int followeeId) {
        User user = getUser(followerId);
        user.follow(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        User user = getUser(followerId);
        user.unfollow(followeeId);
    }

    class User {
        int userId;
        Set<Integer> followees;
        Tweet head;

        public User(int userId) {
            this.userId = userId;
            this.followees = new HashSet<>();
            this.followees.add(userId);
        }

        public void follow(int followeeId) {
            followees.add(followeeId);
        }

        public void unfollow(int followeeId) {
            followees.remove(followeeId);
        }

        public void post(int tweetId) {
            Tweet tweet = new Tweet(tweetId);
            tweet.next = head;
            head = tweet;
        }

        public List<Integer> getNewsFeed() {
            Queue<Tweet> q = new PriorityQueue<>((a, b) -> b.timestamp - a.timestamp);
            for (int f : followees) {
                User followee = getUser(f);
                if (followee.head != null) {
                    q.offer(followee.head);
                }
            }
            List<Integer> list = new ArrayList<>();
            while (!q.isEmpty() && list.size() < 10) {
                Tweet tweet = q.poll();
                list.add(tweet.id);
                if (tweet.next != null) {
                    q.offer(tweet.next);
                }
            }
            return list;
        }
    }

    int time = 0;

    class Tweet {
        int id;
        int timestamp;
        Tweet next;

        public Tweet(int id) {
            this.id = id;
            this.timestamp = time;
            time++;
        }
    }
}
```

### 373. Find K Pairs with Smallest Sums

> 合并n个链表
> [0,0][0,1][0,2]
> [1,0][1,1][1,2]
> [2,0][2,1][2,2]

```java
class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int m = nums1.length;
        int n = nums2.length;
        List<List<Integer>> list = new ArrayList<>();
        Queue<int[]> q = new PriorityQueue<>((a, b) -> (nums1[a[0]] + nums2[a[1]]) - (nums1[b[0]] + nums2[b[1]]));
        for (int i = 0; i < m; i++) {
            q.offer(new int[]{i, 0});
        }
        while (!q.isEmpty() && list.size() < k) {
            int[] p = q.poll();
            list.add(List.of(nums1[p[0]], nums2[p[1]]));
            if (p[1] < n - 1) {
                q.offer(new int[]{p[0], p[1] + 1});
            }
        }
        return list;
    }
}
```