package tag.Tree;

import utils.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class PathSumIII {
    public int pathSum(TreeNode root, int targetSum) {
        map.put(0L, 1);
        bt(root, (long) targetSum, 0L);
//        System.out.println(map);
        return count;
    }

    Map<Long, Integer> map = new HashMap<>();
    int count = 0;

    void bt(TreeNode root, Long targetSum, Long sum) {
        if (root == null) return;
        sum += root.val;
        long key = sum - targetSum;
        if (map.containsKey(key)) {
            count += map.get(key);
        }
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        bt(root.left, targetSum, sum);
        bt(root.right, targetSum, sum);
        map.put(sum, map.get(sum) - 1);
    }
}
