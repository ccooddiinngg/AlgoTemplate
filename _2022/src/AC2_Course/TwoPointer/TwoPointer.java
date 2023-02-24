package AC2_Course.TwoPointer;

import java.util.HashSet;
import java.util.Set;

public class TwoPointer {
    public static int find(int[] nums) {
        int m = nums.length;
        Set<Integer> set = new HashSet<>();
        int i = 0;
        int j = 0;
        int count = 0;
        while (i < m) {
            while (i < m && !set.contains(nums[i])) {
                set.add(nums[i]);
                i++;
            }
            count = Math.max(count, i - j);
            set.remove(nums[j]);
            j++;
        }
        return count;
    }
}
