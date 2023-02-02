### 94. Binary Tree Inorder Traversal

```java
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while (!stack.isEmpty() || p != null) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
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
