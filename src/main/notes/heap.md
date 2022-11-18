### 218 天际线问题
[218. The Skyline Problem](https://leetcode.com/problems/the-skyline-problem/)
[218. 天际线问题](https://leetcode-cn.com/problems/the-skyline-problem/)
```java
class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<P> ps = new ArrayList<>();
        for (int[] building: buildings) {
            ps.add(new P(true, building[0], building[2]));
            ps.add(new P(false, building[1], building[2]));
        }
        ps.sort((a, b) -> {
            if (a.x == b.x) {
                return a.in? -1:b.in?1:0;
            }
            return a.x - b.x;
        });

        Queue<Integer> q = new PriorityQueue<>((a, b) -> b - a);
        q.offer(0);
        List<List<Integer>> list = new ArrayList<>();
        int max = 0;
        int i = 0;
        while (i < ps.size()) {
            P p = ps.get(i);
            if (p.in) {
                q.offer(p.y);
            }else {
                q.remove(p.y);
            }
            //if next is at same x
            if (i < ps.size() - 1 && ps.get(i).x == ps.get(i + 1).x) {
                i++;
                continue;
            }
            if (q.peek() != max) {
                max = q.peek();
                List<Integer> l = new ArrayList<>();
                l.add(p.x);
                l.add(max);
                list.add(l);
            }
            i++;
        }
        return list;
    }

    class P {
        boolean in;
        int x;
        int y;

        public P(boolean in, int x, int y) {
            this.in = in;
            this.x = x;
            this.y = y;
        }
    }
}
```

### 480 滑动窗口中位数
[480. Sliding Window Median](https://leetcode.com/problems/sliding-window-median/)
[480. 滑动窗口中位数](https://leetcode-cn.com/problems/sliding-window-median/)
```java
class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        Med med = new Med();
        int i = 0;
        int j = 0;
        double[] res = new double[nums.length - k + 1];
        int idx = 0;
        while (j < nums.length) {
            med.insert(nums[j]);
            if (med.size() > k) {
                med.remove(nums[i]);
                i++;
            }
            if (med.size() == k) {
                res[idx++] = med.getMed();
            }
            j++;
        }
        return res;
    }

    class Med {
        Queue<Integer> q1 = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        Queue<Integer> q2 = new PriorityQueue<>();

        public Med() {}

        public int size() {
            return q1.size() + q2.size();
        }

        private void balance() {
            if (q2.size() > q1.size() + 1) {
                q1.offer(q2.poll());
            }
            if (q1.size() > q2.size()) {
                q2.offer(q1.poll());
            }
        }

        public void insert(int v) {
            if (q2.isEmpty() || v >= q2.peek()) {
                q2.offer(v);
            }else {
                q1.offer(v);
            }
            balance();
        }

        public void remove(int v) {
            if (size() == 0) throw new NullPointerException();
            if (v >= q2.peek()) {
                q2.remove(v);
            }else {
                q1.remove(v);
            }
            balance();
        }

        public double getMed() {
            int size = size();
            if (size == 0) throw new NullPointerException();
            if (size % 2 == 0) {
                return ((double)q1.peek() + (double)q2.peek()) / 2.0;
            }
            return (double)q2.peek();
        }
    }
}
```
>Integer.compare()
