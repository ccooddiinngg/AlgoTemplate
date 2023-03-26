### 23. Merge k Sorted Lists

> merge sort

```java
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        return mergeKLists(lists, 0, lists.length - 1);
    }

    private ListNode mergeKLists(ListNode[] lists, int l, int r) {
        if (l == r) return lists[l];
        int mid = l + r >> 1;
        ListNode left = mergeKLists(lists, l, mid);
        ListNode right = mergeKLists(lists, mid + 1, r);
        return merge(left, right);
    }

    private ListNode merge(ListNode h1, ListNode h2) {
        ListNode dummy = new ListNode();
        ListNode p = dummy;
        ListNode p1 = h1;
        ListNode p2 = h2;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                p.next = p1;
                p1 = p1.next;
            } else {
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
        }
        if (p1 != null) {
            p.next = p1;
        }
        if (p2 != null) {
            p.next = p2;
        }
        return dummy.next;
    }
}
```

### 215. Kth Largest Element in an Array

> quick sort
> after quick sort, nums[i <= p] <= nums[i > p]

```java
class Solution {
    public int findKthLargest(int[] nums, int k) {
        int m = nums.length;
        int i = 0;
        int j = m - 1;
        while (i < j) {
            int idx = partition(nums, i, j);
            if (idx >= m - k) {
                j = idx;
            } else {
                i = idx + 1;
            }
        }
        return nums[j];
    }

    private int partition(int[] nums, int l, int r) {
        if (l == r) return l;
        int seed = nums[l + r >> 1];
        int i = l - 1;
        int j = r + 1;
        while (i < j) {
            while (nums[++i] < seed) ;
            while (nums[--j] > seed) ;
            if (i < j) {
                swap(nums, i, j);
            }
        }
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
```

### 347. Top K Frequent Elements

> quick sort
> [...p...] p>(m-k), j=p; p<(m-k), i=p+1; p==(m-k), 不能确定p是最大值, j=p

```java
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        int i = 0;
        int j = list.size() - 1;
        while (i < j) {
            int p = partition(list, i, j);
            if (p >= list.size() - k) {
                j = p;
            } else {
                i = p + 1;
            }
        }

        int[] ans = new int[k];
        int idx = 0;
        while (idx < ans.length) {
            ans[idx++] = list.get(i++).getKey();
        }
        return ans;
    }

    int partition(List<Map.Entry<Integer, Integer>> list, int l, int r) {
        if (l == r) return l;
        int seed = list.get(l + r >> 1).getValue();
        int i = l - 1;
        int j = r + 1;
        while (i < j) {
            while (list.get(++i).getValue() < seed) ;
            while (list.get(--j).getValue() > seed) ;
            if (i < j) {
                var t = list.get(i);
                list.set(i, list.get(j));
                list.set(j, t);
            }
        }
        return j;
    }
}
```