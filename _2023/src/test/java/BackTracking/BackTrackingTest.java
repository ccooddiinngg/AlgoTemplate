package BackTracking;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

class BackTrackingTest {

    @Test
    void test() {
        String[] stickers = {"claim", "last", "determine", "cry", "bed", "result", "human", "duck", "seem"};
        String target = "camereal";
        Assertions.assertEquals(3, minStickers(stickers, target));
    }

    public int minStickers(String[] stickers, String target) {
        int m = target.length();
        int[][] count = new int[stickers.length][26];
        for (int i = 0; i < stickers.length; i++) {
            for (int j = 0; j < stickers[i].length(); j++) {
                count[i][stickers[i].charAt(j) - 'a']++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        q.offer(0);
        set.add(0);
        int step = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            step++;
            for (int i = 0; i < size; i++) {
                int curr = q.poll();
//                System.out.println(Integer.toBinaryString(curr));
                if (curr == (1 << m) - 1) {
                    return step - 1;
                }
                for (int[] c : count) {
                    int state = curr;
                    int[] temp = Arrays.copyOf(c, c.length);
                    for (int j = 0; j < m; j++) {
                        int idx = target.charAt(j) - 'a';
                        if ((state >> (m - 1 - j) & 1) == 0 && temp[idx] > 0) {
                            state |= (1 << (m - 1 - j));
                            temp[idx]--;
                        }
                    }
                    if (!set.contains(state)) {
                        set.add(state);
                        q.offer(state);
                    }
                }
            }

        }
        return -1;
    }

    @Test
    void test1() {
        int[] nums = {3, 3, 10, 2, 6, 5, 10, 6, 8, 3, 2, 1, 6, 10, 7, 2};
        int k = 6;
        Assertions.assertFalse(canPartitionKSubsets(nums, k));
    }

    public boolean canPartitionKSubsets(int[] nums, int k) {
        sort(nums, 0, nums.length - 1);
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % k != 0) {
            return false;
        }
        int target = sum / k;
        return dfs(nums, 0, 0, target, target, k);
    }

    //试着先填充一个集合
    public boolean dfs(int[] nums, int idx, int state, int target, int rest, int k) {
        if (k == 0) {
            return true;
        }
        if (rest == 0) {
            return dfs(nums, 0, state, target, target, k - 1);
        }
        for (int i = idx; i < nums.length; i++) {
            if (nums[i] <= rest && (state >> i & 1) == 0) {
                if (dfs(nums, i + 1, state + (1 << i), target, rest - nums[i], k)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void sort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int idx = partition(nums, left, right);
        sort(nums, left, idx);
        sort(nums, idx + 1, right);
    }

    public int partition(int[] nums, int left, int right) {
        int seed = nums[left + right >> 1];
        int i = left - 1;
        int j = right + 1;
        while (i < j) {
            while (nums[++i] > seed) ;
            while (nums[--j] < seed) ;
            if (i < j) {
                swap(nums, i, j);
            }
        }
        return j;
    }

    public void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    @Test
    void test2() {
        String bottom = "AAA";
        List<String> allowed = List.of("AAB", "AAC", "BCA");
        Assertions.assertTrue(pyramidTransition(bottom, allowed));
    }


    int[] asc = new int[128];
    Map<Integer, List<Integer>> map = new HashMap<>();

    public boolean pyramidTransition(String bottom, List<String> allowed) {
        for (int i = 'A'; i <= 'F'; i++) {
            asc[i] = i - 'A' + 1;
        }

        for (String s : allowed) {
            int a = asc[s.charAt(0)] << 3 | asc[s.charAt(1)];
            int b = asc[s.charAt(2)];
            if (!map.containsKey(a)) {
                map.put(a, new ArrayList<>());
            }
            map.get(a).add(b);
        }

        int state = 0;
        for (int i = 0, j = (bottom.length() - 1) * 3; i < bottom.length(); i++, j -= 3) {
            state |= (asc[bottom.charAt(i)] << j);
        }

        return dfs(state);
    }

    boolean dfs(int state) {
        if (state < 8) return true;
        List<Integer> next = new ArrayList<>();
        getNext(state, 0, 0, next);
        for (int n : next) {
            if (dfs(n)) return true;
        }
        return false;
    }

    void getNext(int curr, int offset, int path, List<Integer> list) {
        if (curr < 8) {
            list.add(path);
            return;
        }
        int mask = (1 << 6) - 1;
        if (!map.containsKey(curr & mask)) return;
        for (int next : map.get(curr & mask)) {
            getNext(curr >> 3, offset + 3, path + (next << offset), list);
        }
    }


}

