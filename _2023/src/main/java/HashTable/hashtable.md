### 287. Find the Duplicate Number

```java
class Solution {
    public int findDuplicate(int[] nums) {
        int m = nums.length;
        int i = 0;
        while (i < m) {
            if (nums[i] - 1 != i) {
                if (nums[nums[i] - 1] == nums[i]) {
                    return nums[i];
                }
                swap(nums, i, nums[i] - 1);
            } else {
                i++;
            }
        }
        return -1;
    }

    void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
```