package AC2_Course.Sort;

public class ReversePairs {
    static int count = 0;

    public static void main(String[] args) {
        int[] nums = {2, 3, 4, 5, 6, 1};
        sort(nums, 0, nums.length - 1);
        System.out.println(count);
    }

    public static void sort(int[] nums, int l, int r) {
        if (l == r) {
            return;
        }
        int m = l + (r - l) / 2;
        sort(nums, l, m);
        sort(nums, m + 1, r);
        merge(nums, l, m, r);
    }

    public static void merge(int[] nums, int l, int m, int r) {
        int[] temp = new int[r - l + 1];
        int i = l;
        int j = m + 1;
        int index = 0;
        while (i <= m && j <= r) {
            if (nums[i] <= nums[j]) {
                temp[index++] = nums[i++];
            } else {
                temp[index++] = nums[j++];
                count += (m - i + 1);
            }
        }
        while (i <= m) {
            temp[index++] = nums[i++];
        }
        while (j <= r) {
            temp[index++] = nums[j++];
        }
        for (int k = 0; k < temp.length; k++) {
            nums[l + k] = temp[k];
        }
    }
}
