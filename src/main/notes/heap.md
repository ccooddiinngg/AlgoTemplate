### 218天际线问题
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
