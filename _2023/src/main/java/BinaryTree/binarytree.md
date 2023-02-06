### 94. Binary Tree Inorder Traversal

```java
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> Stack = new Stack<>();
        TreeNode p = root;
        while (!Stack.isEmpty() || p != null) {
            while (p != null) {
                Stack.push(p);
                p = p.left;
            }
            p = Stack.pop();
            list.add(p.val);
            p = p.right;
        }
        return list;
    }
}
```

### 95. Unique Binary Search Trees II

```java
class Solution {
    public List<TreeNode> generateTrees(int n) {
        return helper(1, n);
    }

    public List<TreeNode> helper(int low, int high) {
        List<TreeNode> list = new ArrayList<>();
        if (low > high) {
            list.add(null);
        } else if (low == high) {
            list.add(new TreeNode(low));
        } else {
            for (int i = low; i <= high; i++) {
                List<TreeNode> l = helper(low, i - 1);
                List<TreeNode> r = helper(i + 1, high);
                for (TreeNode n1 : l) {
                    for (TreeNode n2 : r) {
                        TreeNode root = new TreeNode(i);
                        root.left = n1;
                        root.right = n2;
                        list.add(root);
                    }
                }
            }
        }
        return list;
    }
}
```

### 96. Unique Binary Search Trees

> dp为n个节点能产生的方案数
> 枚举2到n个节点， i个节点的方案数=∑左边方案数*右边方案数

```java
class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - 1 - j];
            }
        }
        return dp[n];
    }
}
```

### 98. Validate Binary Search Tree

```java
class Solution {
    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean helper(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        if (root.val <= min || root.val >= max) {
            return false;
        }
        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }
}
```

```java
class Solution {
    TreeNode pre;

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        boolean left = isValidBST(root.left);
        if (pre != null && pre.val >= root.val) {
            return false;
        }
        pre = root;
        boolean right = isValidBST(root.right);
        return left && right;
    }
}
```

### 99. Recover Binary Search Tree

> 中序遍历， 用2个变量记录倒序的节点对， 反转第一个和最后一个
> [3, 2, 1] -> 3, 2 and 2, 1, 交换3, 1即可

```java
class Solution {
    TreeNode p1;
    TreeNode p2;
    TreeNode pre;

    public void recoverTree(TreeNode root) {
        helper(root);
        int t = p1.val;
        p1.val = p2.val;
        p2.val = t;
    }

    public void helper(TreeNode root) {
        if (root == null) return;
        helper(root.left);
        if (pre != null && root.val <= pre.val) {
            if (p1 == null) {
                p1 = pre;
            }
            p2 = root;
        }
        pre = root;
        helper(root.right);
    }
}
```

### 100. Same Tree

```java
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
```

### 101. Symmetric Tree

```java
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return helper(root.left, root.right);
    }

    public boolean helper(TreeNode r1, TreeNode r2) {
        if (r1 == null && r2 == null) return true;
        if (r1 == null || r2 == null) return false;
        return r1.val == r2.val && helper(r1.left, r2.right) && helper(r1.right, r2.left);
    }
}
```

### 102. Binary Tree Level Order Traversal

```java
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if (root != null) {
            q.offer(root);
        }
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> l = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                l.add(curr.val);
                if (curr.left != null) q.offer(curr.left);
                if (curr.right != null) q.offer(curr.right);
            }
            list.add(l);
        }
        return list;
    }
}
```

### 103. Binary Tree Zigzag Level Order Traversal

```java
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if (root != null) {
            q.offer(root);
        }
        boolean toRight = true;
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> l = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                if (toRight) {
                    l.add(curr.val);
                } else {
                    l.add(0, curr.val);
                }
                if (curr.left != null) q.offer(curr.left);
                if (curr.right != null) q.offer(curr.right);
            }
            list.add(l);
            toRight = !toRight;
        }
        return list;
    }
}
```

### 104. Maximum Depth of Binary Tree

```java
class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
```

### 105. Construct Binary Tree from Preorder and Inorder Traversal

```java
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int m = preorder.length;
        return helper(preorder, 0, m - 1, inorder, 0, m - 1);
    }

    public TreeNode helper(int[] pre, int pl, int pr, int[] in, int il, int ir) {
        if (pl > pr) {
            return null;
        }
        TreeNode root = new TreeNode(pre[pl]);
        int idx = indexOf(in, il, ir, pre[pl]);
        root.left = helper(pre, pl + 1, pl + (idx - il), in, il, idx - 1);
        root.right = helper(pre, pl + (idx - il) + 1, pr, in, idx + 1, ir);
        return root;
    }

    public int indexOf(int[] in, int il, int ir, int t) {
        for (int i = il; i <= ir; i++) {
            if (in[i] == t) {
                return i;
            }
        }
        return -1;
    }
}
```

### 108. Convert Sorted Array to Binary Search Tree

```java
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    public TreeNode helper(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        }
        int mid = l + r >> 1;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, l, mid - 1);
        root.right = helper(nums, mid + 1, r);
        return root;
    }
}
```

### 111. Minimum Depth of Binary Tree

```java
class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) {
            return 1;
        }
        if (root.left == null) {
            return minDepth(root.right) + 1;
        }
        if (root.right == null) {
            return minDepth(root.left) + 1;
        }
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }

}
```

### 112. Path Sum

```java
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }
        boolean left = root.left != null && hasPathSum(root.left, targetSum - root.val);
        if (left) {
            return true;
        }
        boolean right = root.right != null && hasPathSum(root.right, targetSum - root.val);
        if (right) {
            return true;
        }
        return false;
    }
}
```

### 114. Flatten Binary Tree to Linked List

> postOrder starts from right

```java
class Solution {
    TreeNode pre;

    public void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.right);
        flatten(root.left);
        root.right = pre;
        root.left = null;
        pre = root;
    }
}
```

### 116. Populating Next Right Pointers in Each Node

```java
class Solution {
    public Node connect(Node root) {
        Queue<Node> q = new LinkedList<>();
        if (root != null) q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            Node pre = null;
            for (int i = 0; i < size; i++) {
                Node curr = q.poll();
                if (curr.left != null) q.offer(curr.left);
                if (curr.right != null) q.offer(curr.right);
                if (pre != null) {
                    pre.next = curr;
                }
                pre = curr;
            }
        }
        return root;
    }
}
```

### 117. Populating Next Right Pointers in Each Node II

> use next pointer traverse every level

```java
class Solution {
    public Node connect(Node root) {
        Node pre = root;
        while (pre != null) {
            Node dummy = new Node();
            Node p = dummy;
            while (pre != null) {
                if (pre.left != null) {
                    p.next = pre.left;
                    p = p.next;
                }
                if (pre.right != null) {
                    p.next = pre.right;
                    p = p.next;
                }
                pre = pre.next;
            }
            pre = dummy.next;
        }
        return root;
    }
}
```

### 124. Binary Tree Maximum Path Sum

```java
class Solution {
    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        helper(root);
        return max;
    }

    public int helper(TreeNode root) {
        if (root == null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        int o3 = left + right + root.val;
        int o2 = Math.max(left, right) + root.val;
        int o1 = root.val;
        max = Math.max(max, Math.max(o1, Math.max(o2, o3)));
        return Math.max(o1, o2);
    }
}
```

### 145. Binary Tree Postorder Traversal

```java
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> Stack = new Stack<>();
        TreeNode p = root;
        TreeNode pre = null;
        List<Integer> list = new ArrayList<>();
        while (!Stack.isEmpty() || p != null) {
            while (p != null) {
                Stack.push(p);
                p = p.left;
            }
            p = Stack.pop();
            if (p.right == null || p.right == pre) {
                list.add(p.val);
                pre = p;
                p = null;
            } else {
                Stack.push(p);
                p = p.right;
            }
        }
        return list;
    }
}
```

### 173. Binary Search Tree Iterator

```java
class BSTIterator {
    TreeNode p;
    Stack<TreeNode> Stack;

    public BSTIterator(TreeNode root) {
        this.p = root;
        this.Stack = new Stack<>();
    }

    public void pre() {
        while (p != null) {
            Stack.push(p);
            p = p.left;
        }
    }

    public int next() {
        pre();
        p = Stack.pop();
        int res = p.val;
        p = p.right;
        return res;
    }

    public boolean hasNext() {
        return !Stack.isEmpty() || p != null;
    }
}
```

### 199. Binary Tree Right Side View

```java
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        if (root != null) q.offer(root);
        List<Integer> list = new ArrayList<>();
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                if (curr.left != null) q.offer(curr.left);
                if (curr.right != null) q.offer(curr.right);
                if (i == size - 1) {
                    list.add(curr.val);
                }
            }
        }
        return list;
    }
}
```

### 226. Invert Binary Tree

```java
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
```

### 230. Kth Smallest Element in a BST

```java
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> Stack = new Stack<>();
        TreeNode p = root;
        while (k > 0) {
            while (p != null) {
                Stack.push(p);
                p = p.left;
            }
            p = Stack.pop();
            k--;
            if (k == 0) return p.val;
            p = p.right;
        }
        return -1;
    }
}
```

### 236. Lowest Common Ancestor of a Binary Tree

```java
class Solution {
    TreeNode ans;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        helper(root, p, q);
        return ans;
    }

    public boolean[] helper(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return new boolean[2];
        }
        boolean[] left = helper(root.left, p, q);
        boolean[] right = helper(root.right, p, q);
        boolean foundP = left[0] || right[0] || root == p;
        boolean foundQ = left[1] || right[1] || root == q;
        if (ans == null && foundP && foundQ) {
            ans = root;
        }
        return new boolean[]{foundP, foundQ};
    }
}
```

### 257. Binary Tree Paths

```java
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        if (root != null) helper(root, new ArrayList<>(), list);
        return list;
    }

    public void helper(TreeNode root, List<Integer> path, List<String> list) {
        if (root.left == null && root.right == null) {
            StringBuilder sb = new StringBuilder();
            for (Integer p : path) {
                sb.append(p).append("->");
            }
            sb.append(root.val);
            list.add(sb.toString());
            return;
        }
        path.add(root.val);
        if (root.left != null) helper(root.left, path, list);
        if (root.right != null) helper(root.right, path, list);
        path.remove(path.size() - 1);
    }
}
```

### 297. Serialize and Deserialize Binary Tree

```java
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "null";
        }
        return root.val + "," + serialize(root.left) + "," + serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strs = data.split(",");
        return de(strs);
    }

    int idx = 0;

    public TreeNode de(String[] strs) {
        if (idx >= strs.length || strs[idx].equals("null")) {
            idx++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(strs[idx++]));
        root.left = de(strs);
        root.right = de(strs);
        return root;
    }
}
```

### 331. Verify Preorder Serialization of a Binary Tree

```java
class Solution {
    public boolean isValidSerialization(String preorder) {
        int slots = 1;
        String[] pre = preorder.split(",");
        for (int i = 0; i < pre.length; i++) {
            if (slots <= 0) {
                return false;
            }
            if (pre[i].equals("#")) {
                slots--;
            } else {
                slots++;
            }
        }
        return slots == 0;
    }
}
```

### 337. House Robber III

```java
class Solution {
    public int rob(TreeNode root) {
        int[] res = helper(root);
        return Math.max(res[0], res[1]);
    }

    public int[] helper(TreeNode root) {
        if (root == null) return new int[2];
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        int no = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        int yes = root.val + left[0] + right[0];
        return new int[]{no, yes};
    }
}
```

### 437. Path Sum III

> dfs, preSum

```java
class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> map = new HashMap<>();
        map.put(0L, 1);
        dfs(root, targetSum, 0, map);
        return count;
    }

    int count = 0;

    public void dfs(TreeNode root, int t, long path, Map<Long, Integer> map) {
        if (root == null) return;
        path += root.val;
        if (map.containsKey(path - t)) {
            count += map.get(path - t);
        }
        map.put(path, map.getOrDefault(path, 0) + 1);
        dfs(root.left, t, path, map);
        dfs(root.right, t, path, map);
        map.put(path, map.get(path) - 1);
    }
}
```

### 450. Delete Node in a BST

```java
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val == key) {
            return delete(root);
        }
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else {
            root.right = deleteNode(root.right, key);
        }
        return root;
    }

    public TreeNode delete(TreeNode root) {
        if (root.right == null) {
            return root.left;
        }
        TreeNode p = root.right;
        while (p.left != null) {
            p = p.left;
        }
        p.left = root.left;
        return root.right;
    }
}
```

### 513. Find Bottom Left Tree Value

```java
class Solution {

    public int findBottomLeftValue(TreeNode root) {
        dfs(root, 0);
        return tar.val;
    }

    int max = Integer.MIN_VALUE;
    TreeNode tar;

    public void dfs(TreeNode root, int h) {
        if (root.left == null && root.right == null) {
            if (h > max) {
                max = h;
                tar = root;
            }
            return;
        }
        if (root.left != null) dfs(root.left, h + 1);
        if (root.right != null) dfs(root.right, h + 1);
    }
}
```

### 543. Diameter of Binary Tree

```java
class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return max;
    }

    int max = 0;

    public int helper(TreeNode root) {
        if (root.left == null && root.right == null) return 1;
        int left = root.left != null ? helper(root.left) : 0;
        int right = root.right != null ? helper(root.right) : 0;
        max = Math.max(max, left + right);
        return Math.max(left, right) + 1;
    }
}
```

### 617. Merge Two Binary Trees

```java
class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        }
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        TreeNode node = new TreeNode(root1.val + root2.val);
        node.left = mergeTrees(root1.left, root2.left);
        node.right = mergeTrees(root1.right, root2.right);
        return node;
    }
}
```

### 652. Find Duplicate Subtrees

```java
class Solution {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        postOrder(root);
        return list;
    }

    Map<String, Integer> map = new HashMap<>();
    List<TreeNode> list = new ArrayList<>();

    public String postOrder(TreeNode root) {
        if (root == null) {
            return "#";
        }
        String left = postOrder(root.left);
        String right = postOrder(root.right);
        String curr = left + "," + right + "," + root.val;
        map.put(curr, map.getOrDefault(curr, 0) + 1);
        if (map.get(curr) == 2) {
            list.add(root);
        }
        return curr;
    }
}
```

### 653. Two Sum IV - Input is a BST

```java
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        return dfs(root, k);
    }

    Set<Integer> set = new HashSet<>();

    public boolean dfs(TreeNode root, int k) {
        if (root == null) return false;
        if (set.contains(k - root.val)) {
            return true;
        }
        set.add(root.val);
        return dfs(root.left, k) || dfs(root.right, k);
    }
}
```

### 669. Trim a Binary Search Tree

```java
class Solution {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) return null;
        if (root.val < low) {
            return trimBST(root.right, low, high);
        }
        if (root.val > high) {
            return trimBST(root.left, low, high);
        }
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }
}
```

### 703. Kth Largest Element in a Stream

```java
class KthLargest {

    int[] heap;
    int k;
    int size;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.heap = new int[k + 1];
        this.size = 0;
        for (int num : nums) {
            add(num);
        }
    }

    void up(int idx) {
        while (heap[idx] < heap[(idx - 1) / 2]) {
            swap(idx, (idx - 1) / 2);
            idx = (idx - 1) / 2;
        }
    }

    void down(int idx) {
        while (idx * 2 + 1 < size) {
            int minIdx = idx * 2 + 1;
            if (idx * 2 + 2 < size && heap[idx * 2 + 2] < heap[idx * 2 + 1]) {
                minIdx = idx * 2 + 2;
            }
            if (heap[idx] < heap[minIdx]) {
                break;
            }
            swap(idx, minIdx);
            idx = minIdx;
        }
    }

    void offer(int v) {
        heap[size++] = v;
        up(size - 1);
        if (size > k) {
            poll();
        }
    }

    void poll() {
        heap[0] = heap[size - 1];
        down(0);
        size--;
    }

    int peek() {
        if (isEmpty()) {
            return -1;
        }
        return heap[0];
    }

    boolean isEmpty() {
        return size == 0;
    }

    void swap(int i, int j) {
        int t = heap[i];
        heap[i] = heap[j];
        heap[j] = t;
    }

    public int add(int val) {
        offer(val);
        return peek();
    }
}

```

### 1022. Sum of Root To Leaf Binary Numbers

```java
class Solution {
    public int sumRootToLeaf(TreeNode root) {
        return dfs(root, 0);
    }

    public int dfs(TreeNode root, int path) {
        if (root == null) return 0;
        path = path << 1 | root.val;
        if (root.left == null && root.right == null) {
            return path;
        }
        return dfs(root.left, path) + dfs(root.right, path);
    }
}
```

### 1382. Balance a Binary Search Tree

> inorder, rebuild tree

```java
class Solution {
    public TreeNode balanceBST(TreeNode root) {
        inOrder(root);
        return build(list, 0, list.size() - 1);
    }

    List<TreeNode> list = new ArrayList<>();

    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        list.add(root);
        inOrder(root.right);
    }

    public TreeNode build(List<TreeNode> list, int l, int r) {
        if (l > r) {
            return null;
        }
        int mid = l + r >> 1;
        TreeNode root = list.get(mid);
        root.left = build(list, l, mid - 1);
        root.right = build(list, mid + 1, r);
        return root;
    }
}
```

### 1569. Number of Ways to Reorder Array to Get Same BST

> C[n][k] = C[n-1][k-1] + C[n-1][k]

```java
class Solution {
    int MOD = (int) 1e9 + 7;
    long[][] C;

    public int numOfWays(int[] nums) {
        int m = nums.length;
        C = new long[m][m];
        C[0][0] = 1;
        for (int i = 1; i < m; i++) {
            C[i][0] = 1;
            for (int j = 1; j < m; j++) {
                C[i][j] = C[i - 1][j - 1] + C[i - 1][j];
                C[i][j] = C[i][j] % MOD;
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        return (int) helper(list) - 1;
    }

    public long helper(List<Integer> list) {
        if (list.isEmpty()) return 1;
        int root = list.get(0);
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        for (int v : list) {
            if (v > root) {
                right.add(v);
            }
            if (v < root) {
                left.add(v);
            }
        }
        return C[left.size() + right.size()][left.size()] * helper(left) % MOD * helper(right) % MOD;
    }
}
```