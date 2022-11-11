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

